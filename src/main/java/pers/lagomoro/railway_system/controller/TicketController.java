package pers.lagomoro.railway_system.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lagomoro.railway_system.entity.*;
import pers.lagomoro.railway_system.manager.TokenManager;
import pers.lagomoro.railway_system.service.impl.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.JarEntry;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final PassengerServiceImpl passengerService;
    private final TicketServiceImpl ticketService;
    private final OrderServiceImpl orderService;
    private final TemplateSeatServiceImpl templateSeatService;
    private final ScheduleServiceImpl scheduleService;
    private final RailwayServiceImpl railwayService;

    public TicketController(PassengerServiceImpl passengerService, TicketServiceImpl ticketService,
                            OrderServiceImpl orderService, TemplateSeatServiceImpl templateSeatService,
                            ScheduleServiceImpl scheduleService, RailwayServiceImpl railwayService) {
        this.passengerService = passengerService;
        this.ticketService = ticketService;
        this.orderService = orderService;
        this.templateSeatService = templateSeatService;
        this.scheduleService = scheduleService;
        this.railwayService = railwayService;
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

    private String generateStation(List<SchedulePlus> scheduleList, int journey) {
        String s_journey = new StringBuilder(Integer.toBinaryString(journey)).reverse().toString();
        boolean start = false;
        String temp = "";
        for(int i = 0; i < s_journey.length(); i++){
            if(s_journey.charAt(i) == '1' && !start){
                start = true;
                temp += scheduleList.get(i).getName() + "-";
            }
            if(start && s_journey.charAt(i) == '0'){
                temp += scheduleList.get(i).getName();
                break;
            }
            if(i == s_journey.length() - 1){
                temp += scheduleList.get(i+1).getName();
                break;
            }
        }
        return temp;
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

    @GetMapping("/buy")
    public String BuyTicket(HttpServletRequest request, HttpServletResponse response,
                               @CookieValue(value = "token", defaultValue = "null") String token){
        String tid = request.getParameter("tid");
        String date = request.getParameter("date");
        int pid = Integer.parseInt(request.getParameter("pid"));
        int seat_type = Integer.parseInt(request.getParameter("seat_type"));
        int seat_select = Integer.parseInt(request.getParameter("seat_select"));
        int type = Integer.parseInt(request.getParameter("type"));
        int sid1 = Integer.parseInt(request.getParameter("sid1"));
        int sid2 = Integer.parseInt(request.getParameter("sid2"));

        Passenger passenger = passengerService.getPassengerByPid(pid);
        List<SchedulePlus> scheduleList = this.getScheduleListByTid(tid);

        int price = (int) Math.floor(this.getPrice(scheduleList, sid1, sid2) * new double[]{0.1, 0.05, 0.08}[type]);
        int journey = this.generateJourney(scheduleList, sid1, sid2);

        int seat_id = 0;
        List<Seat> seatList = templateSeatService.getSeatByInfo(tid, date);
        boolean haveSeat = false, canPass = false;
        for(Seat seat: seatList){
            canPass = false;
            if(this.fitJourney(journey, seat.getJourney())){
                if(seat_select > 0){
                    if(seat.getSeatNumber().startsWith(new String[]{"N", "A", "B", "C", "D", "E"}[seat_select])){
                        canPass = true;
                    }
                }else{
                    canPass = true;
                }
                if(canPass){
                    seat_id = seat.getSeatId();
                    templateSeatService.modifyJourney(seat_id, journey + seat.getJourney());
                    haveSeat = true;
                    break;
                }
            }
        }
        if(!haveSeat) {
            return "{\"status\": 501,\"msg\":\"Buy failed: Ticket Sellout!\"}";
        }

        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(new Date());
            orderService.addOrder(new Order(0, uid, time, price, 0));
            int oid = orderService.getOrderByInfo(uid, time).getOid();
            ticketService.addTicket(new Ticket(0, oid, seat_id, journey, passenger.getName(), passenger.getIdentity(), passenger.getGid(), 0));
            return "{\"status\": 200,\"msg\":\"Buy successfully!\"}";
        }
        return "{\"status\": 500,\"msg\":\"Buy failed: Invalid token!\"}";
    }

    @GetMapping("/del")
    public String delOrder(HttpServletRequest request, HttpServletResponse response,
                            @CookieValue(value = "token", defaultValue = "null") String token){
        int oid = Integer.parseInt(request.getParameter("oid"));
        Order order = orderService.getOrderByOid(oid);

        int uid = TokenManager.checkToken(token);
        if(uid > 0){
            if(uid != order.getUid()){
                return "{\"status\": 501,\"msg\":\"Del failed: Invalid User!\"}";
            }
            orderService.deleteOrder(oid);
            List<Ticket> ticketList = ticketService.getTicketByOid(oid);
            for(Ticket ticket : ticketList){
                Seat seat = templateSeatService.getSeatBySeatId(ticket.getSeatId());
                templateSeatService.modifyJourney(ticket.getSeatId(), seat.getJourney() - ticket.getJourney());
                ticketService.deleteTicket(ticket.getTicketId());
            }
            return "{\"status\": 200,\"msg\":\"Del successfully!\"}";
        }
        return "{\"status\": 500,\"msg\":\"Del failed: Invalid token!\"}";
    }

    @GetMapping("/get")
    public String getOrder(HttpServletRequest request, HttpServletResponse response,
                           @CookieValue(value = "token", defaultValue = "null") String token){
        int uid = TokenManager.checkToken(token);

        if(uid > 0){
            StringBuilder str = new StringBuilder();
            str.append("{\"status\": 200, \"data\":[");
            List<Order> orderList = orderService.getOrderByUid(uid);
            boolean have = false;
            for(Order order : orderList){
                Ticket ticket = ticketService.getTicketByOid(order.getOid()).get(0);
                Seat seat = templateSeatService.getSeatBySeatId(ticket.getSeatId());
                List<SchedulePlus> scheduleList = this.getScheduleListByTid(seat.getTid());

                str.append("{\"oid\":" + order.getOid() + ",");
                str.append("\"time\":\"" + order.getTime() + "\",");
                str.append("\"price\":" + order.getPrice() + ",");
                str.append("\"ticket_id\":" + ticket.getTicketId() + ",");
                str.append("\"passenger\":\"" + ticket.getPassengerName() + "\",");
                str.append("\"identity\":\"" + ticket.getPassengerIdentity() + "\",");
                str.append("\"journey\":\"" + this.generateStation(scheduleList, ticket.getJourney()) + "\",");
                str.append("\"seat_number\":\"" + seat.getSeatNumber() + "\",");
                str.append("\"tid\":\"" + seat.getTid() + "\"");
                str.append("},");
                have = true;
            }
            if(have) str.deleteCharAt(str.length() - 1);
            str.append("]}");
            return str.toString();
        }
        return "{\"status\": 500,\"msg\":\"Get failed: Invalid token!\"}";
    }

    @GetMapping("/add-seat")
    public String addSeat(HttpServletRequest request, HttpServletResponse response){
        String date = request.getParameter("date");

        List<SchedulePlus> scheduleList = scheduleService.getAllSchedule();

        ArrayList<String> tidList = new ArrayList<String>();
        for (SchedulePlus schedule : scheduleList){
            if(!tidList.contains(schedule.getTid())){
                tidList.add(schedule.getTid());
            }
        }

        for(String tid : tidList){
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 10;j++){
                    templateSeatService.addSeat(new Seat(0, tid, date, 1, new String[]{"A", "B", "C", "D", "E"}[i] + j, 0));
                }
            }
        }

        return "{\"status\": 200,\"msg\":\"Add successfully!\"}";
    }

    @GetMapping("/del-seat")
    public String delSeat(HttpServletRequest request, HttpServletResponse response){
        String date = request.getParameter("date");

        List<SchedulePlus> scheduleList = scheduleService.getAllSchedule();

        ArrayList<String> tidList = new ArrayList<String>();
        for (SchedulePlus schedule : scheduleList){
            if(!tidList.contains(schedule.getTid())){
                tidList.add(schedule.getTid());
            }
        }

        for(String tid : tidList){
            List<Seat> seatList = templateSeatService.getSeatByInfo(tid, date);
            for(Seat seat: seatList){
                int id = seat.getSeatId();
                System.out.println(id);
                templateSeatService.deleteSeat(id);
            }
        }
        return "{\"status\": 200,\"msg\":\"Delete successfully!\"}";
    }

}