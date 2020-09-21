package pers.lagomoro.railway_system.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import pers.lagomoro.railway_system.entity.User;
import pers.lagomoro.railway_system.manager.TokenManager;
import pers.lagomoro.railway_system.mapper.UserMapper;
import pers.lagomoro.railway_system.service.impl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserServiceImpl userService;

    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/token.php")
    public String LoginWithToken(HttpServletRequest request, HttpServletResponse response,
                                 @CookieValue(value = "token", defaultValue = "null") String token){
        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            return Integer.toString(uid);
        }
        return "Failed!";
    }

    @GetMapping("/pwd.php")
    public String LoginWithPassword(HttpServletRequest request, HttpServletResponse response) {
        request.getParameter("canshu1");
        TokenManager.removeAllTokenFromUser(1);
        TokenManager.addToken("0121", 1);

        Cookie cookie = new Cookie("token", "0121");
        cookie.setMaxAge(TokenManager.TOKEN_TIME);
        response.addCookie(cookie);

        return "Success!";
    }

    @GetMapping("/logout.php")
    public String Logout(HttpServletRequest request, HttpServletResponse response,
                                 @CookieValue(value = "token", defaultValue = "null") String token){
        TokenManager.removeToken(token);

        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "Failed!";
    }

}