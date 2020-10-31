package pers.lagomoro.railway_system.controller;

import org.springframework.web.bind.annotation.*;
import pers.lagomoro.railway_system.entity.Passenger;
import pers.lagomoro.railway_system.entity.SchedulePlus;
import pers.lagomoro.railway_system.manager.TokenManager;
import pers.lagomoro.railway_system.service.impl.PassengerServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerServiceImpl passengerService;

    public PassengerController(PassengerServiceImpl passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/add")
    public String addPassenger(HttpServletRequest request, HttpServletResponse response,
                               @CookieValue(value = "token", defaultValue = "null") String token){
        String name = request.getParameter("name");
        String identity = request.getParameter("identity");
        int sex = Integer.parseInt(request.getParameter("sex"));
        int gid = Integer.parseInt(request.getParameter("gid"));

        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            passengerService.addPassenger(new Passenger(0, uid, name, identity, sex, gid));
            return "{\"status\": 200,\"msg\":\"Add successfully!\"}";
        }
        return "{\"status\": 500,\"msg\":\"Add failed: Invalid token!\"}";
    }

    @GetMapping("/del")
    public String deletePassenger(HttpServletRequest request, HttpServletResponse response,
                               @CookieValue(value = "token", defaultValue = "null") String token){
        int pid = Integer.parseInt(request.getParameter("pid"));

        Passenger passenger = passengerService.getPassengerByPid(pid);
        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            if(uid != passenger.getUid()){
                return "{\"status\": 501,\"msg\":\"Add failed: Invalid User!\"}";
            }
            passengerService.deletePassenger(pid);
            return "{\"status\": 200,\"msg\":\"Add successfully!\"}";
        }
        return "{\"status\": 500,\"msg\":\"Add failed: Invalid token!\"}";
    }

    @GetMapping("/modify")
    public String modifyPassenger(HttpServletRequest request, HttpServletResponse response,
                               @CookieValue(value = "token", defaultValue = "null") String token){
        int pid = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("name");
        String identity = request.getParameter("identity");
        int sex = Integer.parseInt(request.getParameter("sex"));
        int gid = Integer.parseInt(request.getParameter("gid"));

        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            passengerService.modifyPassenger(new Passenger(pid, uid, name, identity, sex, gid));
            return "{\"status\": 200,\"msg\":\"Modify successfully!\"}";
        }
        return "{\"status\": 500,\"msg\":\"Modify failed: Invalid token!\"}";
    }

    @GetMapping("/get")
    public String getPassenger(HttpServletRequest request, HttpServletResponse response,
                               @CookieValue(value = "token", defaultValue = "null") String token){
        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            List<Passenger> passengerList = passengerService.getPassengerByUid(uid);

            StringBuilder str = new StringBuilder();
            str.append("{\"status\": 200, \"data\":[");
            boolean have = false;
            for(Passenger passenger : passengerList){
                str.append("{\"pid\":" + passenger.getPid() + ",");
                str.append("\"name\":\"" + passenger.getName() + "\",");
                str.append("\"identity\":\"" + passenger.getIdentity() + "\",");
                str.append("\"sex\":" + passenger.getSex() + ",");
                str.append("\"gid\":" + passenger.getGid());
                str.append("},");
                have = true;
            }
            if(have) str.deleteCharAt(str.length() - 1);
            str.append("]}");
            return str.toString();
        }
        return "{\"status\": 500,\"msg\":\"Get failed: Invalid token!\"}";
    }
}