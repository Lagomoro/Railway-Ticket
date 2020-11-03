package pers.lagomoro.railway_system.controller;

import org.springframework.web.bind.annotation.*;
import pers.lagomoro.railway_system.entity.Carriage;
import pers.lagomoro.railway_system.entity.Link;
import pers.lagomoro.railway_system.entity.SchedulePlus;
import pers.lagomoro.railway_system.entity.Seat;
import pers.lagomoro.railway_system.service.impl.RailwayServiceImpl;
import pers.lagomoro.railway_system.service.impl.ScheduleServiceImpl;
import pers.lagomoro.railway_system.service.impl.TemplateSeatServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleServiceImpl scheduleService;
    private final RailwayServiceImpl railwayService;
    private final TemplateSeatServiceImpl templateSeatService;

    public ScheduleController(ScheduleServiceImpl scheduleService, RailwayServiceImpl railwayService,
                              TemplateSeatServiceImpl templateSeatService) {
        this.scheduleService = scheduleService;
        this.railwayService = railwayService;
        this.templateSeatService = templateSeatService;
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

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        StringBuilder str = new StringBuilder();
        str.append("\"schedule\":[");
        Date lastTime = null, temp = null;
        String time, stop;
        for (SchedulePlus schedule : scheduleList){
            time = lastTime == null ? "-" : Long.toString((schedule.getArrivalTime().getTime() - lastTime.getTime())/(1000 * 60)) + "分钟";
            stop = Long.toString((schedule.getDepartureTime().getTime() - schedule.getArrivalTime().getTime())/(1000 * 60)) + "分钟";
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
        if(scheduleTidList == null || scheduleTidList.size() == 0)
            return "{\"status\": 200,\"data\":[]}";
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
            if(schedule.getName().equals(station1)){
                if(tidList.containsKey(schedule.getTid())){
                    tidList.put(schedule.getTid(), 0);
                }else{
                    tidList.put(schedule.getTid(), 1);
                }
            }else if(schedule.getName().equals(station2)){
                if(tidList.containsKey(schedule.getTid())){
                    tidList.put(schedule.getTid(), 2);
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

    private int generateJourney(List<SchedulePlus> scheduleList, int sid1, int sid2) {
        boolean start = false;
        int temp = 1;
        int journey = 0;
        for (SchedulePlus schedule : scheduleList){
            if(schedule.getSid() == sid1)
                start = true;
            if(schedule.getSid() == sid2)
                break;
            if(start)
                journey += temp;
            temp *= 2;
        }
        return journey;
    }

    private int getPrice(List<SchedulePlus> scheduleList, int sid1, int sid2) {
        boolean start = false;
        int lastSid = 0;
        int price = 0;
        for (SchedulePlus schedule : scheduleList){
            if(start)
                price += 2 * railwayService.getRailway(lastSid, schedule.getSid()).getDistance();
            lastSid = schedule.getSid();
            if(schedule.getSid() == sid1)
                lastSid = schedule.getSid();
            start = true;
            if(schedule.getSid() == sid2)
                break;
        }
        return price;
    }

    private boolean fitJourney(int journey, int fit) {
        String s_journey = new StringBuilder(Integer.toBinaryString(journey)).reverse().toString();
        String s_fit = new StringBuilder(Integer.toBinaryString(fit)).reverse().toString();

        boolean isFit = true;
        int length = Math.min(s_fit.length(), s_journey.length());
        for(int i = 0; i < length; i++){
            if(s_fit.charAt(i) == '1' && s_journey.charAt(i) == '1'){
                isFit = false;
                break;
            }
        }

        return isFit;
    }

    private int[] getTicket(String tid, String date, int journey){
        List<Seat> seatList = templateSeatService.getSeatByInfo(tid, date);
        List<Link> carriageLink = scheduleService.getTrainLink(tid);
        int[] seatNumber = new int[3];

        int index = 0;
        for(Seat seat: seatList){
            for(Link link : carriageLink){
                if(link.getOrder() == seat.getCarriageOrder()){
                    index = link.getCid() - 1;
                }
            }
            if(this.fitJourney(journey, seat.getJourney())){
                seatNumber[2 - index] ++;
            }
        }
        return seatNumber;
    }

    @GetMapping("/buy")
    public String GetScheduleBuy(HttpServletRequest request, HttpServletResponse response){
        String station1 = request.getParameter("station1");
        String station2 = request.getParameter("station2");
        String date = request.getParameter("date");
        List<SchedulePlus> scheduleList = scheduleService.getAllSchedule();

        HashMap<String, Integer> tidList = new HashMap<String, Integer>();
        for (SchedulePlus schedule : scheduleList){
            if(schedule.getName().equals(station1)){
                if(tidList.containsKey(schedule.getTid())){
                    tidList.put(schedule.getTid(), 0);
                }else{
                    tidList.put(schedule.getTid(), 1);
                }
            }else if(schedule.getName().equals(station2)){
                if(tidList.containsKey(schedule.getTid())){
                    tidList.put(schedule.getTid(), 2);
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
                SchedulePlus s1 = null, s2 = null;
                for(SchedulePlus schedule: scheduleTidList){
                    if(schedule.getName().equals(station1))
                        s1 = schedule;
                    if(schedule.getName().equals(station2))
                        s2 = schedule;
                }
                long time = (s2.getArrivalTime().getTime() - s1.getDepartureTime().getTime())/(1000 * 60);

                String date_phrase = "2020-" + date.substring(0, 2) + "-" + date.substring(3, 5);

                int price = this.getPrice(scheduleTidList, s1.getSid(), s2.getSid());
                int journey = this.generateJourney(scheduleTidList, s1.getSid(), s2.getSid());
                int[] ticket = this.getTicket(tid, date_phrase, journey);

                str.append("{\"tid\":\"" + tid + "\",");
                str.append("\"start\":\"" + start.getName() + "\",");
                str.append("\"end\":\"" + end.getName() + "\",");
                str.append("\"s1\":\"" + s1.getName() + "\",");
                str.append("\"s2\":\"" + s2.getName() + "\",");
                str.append("\"date\":\""+ date_phrase + "\",");
                str.append("\"sid1\":" + s1.getSid() + ",");
                str.append("\"sid2\":" + s2.getSid() + ",");
                str.append("\"price\":" + price + ",");
                str.append("\"ticket\":[" + ticket[0] + "," + ticket[1] + "," + ticket[2] + "],");
                str.append("\"time_a\":\"" + format.format(s1.getDepartureTime().getTime()) + "\",");
                str.append("\"time_b\":\"" + format.format(s2.getArrivalTime().getTime()) + "\",");
                str.append("\"time\":" + time + ",");
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