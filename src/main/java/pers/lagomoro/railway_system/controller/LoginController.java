package pers.lagomoro.railway_system.controller;

import org.springframework.web.bind.annotation.*;
import pers.lagomoro.railway_system.entity.User;
import pers.lagomoro.railway_system.manager.TokenManager;
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

    @GetMapping("/token")
    public String LoginWithToken(HttpServletRequest request, HttpServletResponse response,
                                 @CookieValue(value = "token", defaultValue = "null") String token){
        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            return "{\"status\": 200,\"msg\":\"Login successfully!\"}";
        }

        TokenManager.removeToken(token);

        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "{\"status\": 500,\"msg\":\"Login failed: Invalid token!\"}";
    }

    @GetMapping("/pwd")
    public String LoginWithPassword(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.getUserByUsername(username);
        if(user == null)
            return "{\"status\": 500,\"msg\":\"Login failed: Invalid user!\"}";
        if(password.equals(user.getPassword())){
            int value = (int)Math.floor(Math.random() * 100000000);
            String token = username + value;

            TokenManager.removeAllTokenFromUser(user.getUid());
            TokenManager.addToken(token, user.getUid());

            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(TokenManager.TOKEN_TIME);
            response.addCookie(cookie);
            return "{\"status\": 200,\"msg\":\"Login successfully!\"}";
        }else{
            return "{\"status\": 501,\"msg\":\"Login failed: Invalid password!\"}";
        }
    }

    @GetMapping("/logout")
    public String Logout(HttpServletRequest request, HttpServletResponse response,
                                 @CookieValue(value = "token", defaultValue = "null") String token){
        TokenManager.removeToken(token);

        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "{\"status\": 200,\"msg\":\"Logout successfully!\"}";
    }

}