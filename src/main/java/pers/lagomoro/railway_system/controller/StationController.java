package pers.lagomoro.railway_system.controller;

import org.springframework.web.bind.annotation.*;
import pers.lagomoro.railway_system.entity.Station;
import pers.lagomoro.railway_system.service.impl.StationServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    private final StationServiceImpl stationService;

    public StationController(StationServiceImpl stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/list")
    public String GetAllStation(HttpServletRequest request, HttpServletResponse response){
        List<Station> stationList = stationService.getAllStation();
        StringBuilder str = new StringBuilder();
        str.append("{\"status\": 200, \"data\":[");
        for (Station station : stationList){
            str.append("\"" + station.getName() + "\",");
        }
        str.deleteCharAt(str.length() - 1);
        str.append("]}");
        return str.toString();
    }

}