package pers.lagomoro.railway_system.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pers.lagomoro.railway_system.entity.User;
import pers.lagomoro.railway_system.mapper.UserMapper;
import pers.lagomoro.railway_system.service.UserService;
import pers.lagomoro.railway_system.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping("/users")
public class HelloController {

    private final UserServiceImpl userService;

    public HelloController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper dao = ac.getBean(UserMapper.class);
        User u1 = dao.selectByPrimaryKey(1);
        System.out.println(u1.getUsername());
        return "Hello World!";
    }

    @GetMapping("/user")
    public String users1() {
        return userService.getUserByUid(1).getUsername();
    }

}