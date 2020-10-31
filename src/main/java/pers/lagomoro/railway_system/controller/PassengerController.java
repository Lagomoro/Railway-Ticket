package pers.lagomoro.railway_system.controller;

import org.springframework.web.bind.annotation.*;
import pers.lagomoro.railway_system.service.impl.PassengerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/schedule")
public class PassengerController {

    private final PassengerServiceImpl passengerService;

    public PassengerController(PassengerServiceImpl passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/station")
    public String GetScheduleByStation(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

}