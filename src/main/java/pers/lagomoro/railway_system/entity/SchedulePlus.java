package pers.lagomoro.railway_system.entity;

import java.util.Date;

public class SchedulePlus {

    private String tid;

    private Integer sid;

    private String name;

    private Date date;

    private Integer order;

    private Date arrival_time;

    private Date departure_time;

    private String entrance;

    public SchedulePlus(String tid, Integer sid, String name, Date date, Integer order, Date arrival_time, Date departure_time, String entrance) {
        this.tid = tid;
        this.sid = sid;
        this.name = name;
        this.date = date;
        this.order = order;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
        this.entrance = entrance;
    }

    public SchedulePlus() {
        super();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getArrivalTime() {
        return arrival_time;
    }

    public void setArrivalTime(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Date getDepartureTime() {
        return departure_time;
    }

    public void setDepartureTime(Date departure_time) {
        this.departure_time = departure_time;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance == null ? null : entrance.trim();
    }

    public int compareTo(SchedulePlus schedule){
        return this.order - schedule.order;
    }

}