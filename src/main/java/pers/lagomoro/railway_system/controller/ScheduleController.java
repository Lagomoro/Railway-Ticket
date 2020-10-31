package pers.lagomoro.railway_system.controller;

import org.springframework.web.bind.annotation.*;
import pers.lagomoro.railway_system.entity.SchedulePlus;
import pers.lagomoro.railway_system.entity.Station;
import pers.lagomoro.railway_system.service.impl.ScheduleServiceImpl;
import pers.lagomoro.railway_system.service.impl.StationServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleServiceImpl scheduleService;

    public ScheduleController(ScheduleServiceImpl scheduleService) {
        this.scheduleService = scheduleService;
    }

    private List<SchedulePlus> getScheduleListByTid(String tid) {
        List<SchedulePlus> scheduleList = scheduleService.getTrainSchedule(tid);

        scheduleList.sort(new Comparator<SchedulePlus>() {
            @Override
            public int compare(SchedulePlus o1, SchedulePlus o2) {
                return o1.compareTo(o2);
            }
        });

        return scheduleList;
    }

    private String getScheduleDataByTid(String tid) {
        List<SchedulePlus> scheduleList = this.getScheduleListByTid(tid);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StringBuilder str = new StringBuilder();
        str.append("\"schedule\":[");
        Date lastTime = null, temp = null;
        String time, stop;
        for (SchedulePlus schedule : scheduleList){
            time = lastTime == null ? "-" : Long.toString((schedule.getArrivalTime().getTime() - lastTime.getTime())/(1000 * 60));
            stop = Long.toString((schedule.getDepartureTime().getTime() - schedule.getArrivalTime().getTime())/(1000 * 60));
            lastTime = schedule.getArrivalTime();

            str.append("{");
            str.append("\"station\":\"" + schedule.getName() + "\",");
            str.append("\"time_a\":\"" + format.format(schedule.getArrivalTime()) + "\",");
            str.append("\"time\":\"" + time + "\",");
            str.append("\"stop\":\"" + stop + "\",");
            str.append("\"time_b\":\"" + format.format(schedule.getDepartureTime()) + "\",");
            str.append("\"entrance\":\"" + schedule.getEntrance() + "\"");
            str.append("},");
        }
        str.deleteCharAt(str.length() - 1);
        str.append("]");
        return str.toString();
    }

    @GetMapping("/tid")
    public String GetScheduleByTid(HttpServletRequest request, HttpServletResponse response){
        String tid = request.getParameter("tid");

        List<SchedulePlus> scheduleTidList = this.getScheduleListByTid(tid);
        SchedulePlus start = scheduleTidList.get(0);
        SchedulePlus end = scheduleTidList.get(scheduleTidList.size() - 1);

        StringBuilder str = new StringBuilder();
        str.append("{\"status\": 200, \"data\":[");
        str.append("{\"tid\":\"" + tid + "\",");
        str.append("\"start\":\"" + start.getName() + "\",");
        str.append("\"end\":\"" + end.getName() + "\",");
        str.append(this.getScheduleDataByTid(tid));
        str.append("}]}");
        return str.toString();
    }

    @GetMapping("/station")
    public String GetScheduleByStation(HttpServletRequest request, HttpServletResponse response){
        String station = request.getParameter("station");
        List<SchedulePlus> scheduleList = scheduleService.getAllSchedule();

        ArrayList<String> tidList = new ArrayList<String>();
        for (SchedulePlus schedule : scheduleList){
            if(schedule.getName().equals(station)){
                if(!tidList.contains(schedule.getTid())){
                    tidList.add(schedule.getTid());
                }
            }
        }

        StringBuilder str = new StringBuilder();
        str.append("{\"status\": 200, \"data\":[");
        boolean have = false;
        for (String tid : tidList){

            List<SchedulePlus> scheduleTidList = this.getScheduleListByTid(tid);
            SchedulePlus start = scheduleTidList.get(0);
            SchedulePlus end = scheduleTidList.get(scheduleTidList.size() - 1);

            str.append("{\"tid\":\"" + tid + "\",");
            str.append("\"start\":\"" + start.getName() + "\",");
            str.append("\"end\":\"" + end.getName() + "\",");
            str.append(this.getScheduleDataByTid(tid));
            str.append("},");
            have = true;
        }
        if(have) str.deleteCharAt(str.length() - 1);
        str.append("]}");
        return str.toString();
    }

    @GetMapping("/station2")
    public String GetScheduleByStation2(HttpServletRequest request, HttpServletResponse response){
        String station1 = request.getParameter("station1");
        String station2 = request.getParameter("station2");
        List<SchedulePlus> scheduleList = scheduleService.getAllSchedule();

        HashMap<String, Integer> tidList = new HashMap<String, Integer>();
        for (SchedulePlus schedule : scheduleList){
            if(schedule.getName().equals(station1) || schedule.getName().equals(station2)){
                if(tidList.containsKey(schedule.getTid())){
                    tidList.put(schedule.getTid(), 2);
                }else{
                    tidList.put(schedule.getTid(), 1);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        str.append("{\"status\": 200, \"data\":[");
        boolean have = false;
        for (String tid : tidList.keySet()){
            if(tidList.get(tid) == 2){

                List<SchedulePlus> scheduleTidList = this.getScheduleListByTid(tid);
                SchedulePlus start = scheduleTidList.get(0);
                SchedulePlus end = scheduleTidList.get(scheduleTidList.size() - 1);

                str.append("{\"tid\":\"" + tid + "\",");
                str.append("\"start\":\"" + start.getName() + "\",");
                str.append("\"end\":\"" + end.getName() + "\",");
                str.append(this.getScheduleDataByTid(tid));
                str.append("},");
                have = true;
            }
        }
        if(have) str.deleteCharAt(str.length() - 1);
        str.append("]}");
        return str.toString();
    }

    @GetMapping("/buy")
    public String GetScheduleBuy(HttpServletRequest request, HttpServletResponse response){
        String station1 = request.getParameter("station1");
        String station2 = request.getParameter("station2");
        List<SchedulePlus> scheduleList = scheduleService.getAllSchedule();

        HashMap<String, Integer> tidList = new HashMap<String, Integer>();
        for (SchedulePlus schedule : scheduleList){
            if(schedule.getName().equals(station1) || schedule.getName().equals(station2)){
                if(tidList.containsKey(schedule.getTid())){
                    tidList.put(schedule.getTid(), 2);
                }else{
                    tidList.put(schedule.getTid(), 1);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        str.append("{\"status\": 200, \"data\":[");
        boolean have = false;
        for (String tid : tidList.keySet()){
            if(tidList.get(tid) == 2){

                List<SchedulePlus> scheduleTidList = this.getScheduleListByTid(tid);
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                SchedulePlus start = scheduleTidList.get(0);
                SchedulePlus end = scheduleTidList.get(scheduleTidList.size() - 1);
                String time = Long.toString((start.getDepartureTime().getTime() - end.getArrivalTime().getTime())/(1000 * 60));

                str.append("{\"tid\":\"" + tid + "\",");
                str.append("\"start\":\"" + start.getName() + "\",");
                str.append("\"end\":\"" + end.getName() + "\",");
                str.append("\"time_a\":\"" + format.format(start.getDepartureTime().getTime()) + "\",");
                str.append("\"time_b\":\"" + format.format(end.getArrivalTime().getTime()) + "\",");
                str.append("\"time\":\"" + time + "\",");
                str.append(this.getScheduleDataByTid(tid));
                str.append("},");
                have = true;
            }
        }
        if(have) str.deleteCharAt(str.length() - 1);
        str.append("]}");
        return str.toString();
    }
}