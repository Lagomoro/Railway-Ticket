package pers.lagomoro.railway_system.entity.unused;

import java.util.Date;

public class Schedule {
    private String tid;

    private Integer sid;

    private Date date;

    private Integer order;

    private Date arrivalTime;

    private Date departureTime;

    private String entrance;

    public Schedule(String tid, Integer sid, Date date, Integer order, Date arrivalTime, Date departureTime, String entrance) {
        this.tid = tid;
        this.sid = sid;
        this.date = date;
        this.order = order;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.entrance = entrance;
    }

    public Schedule() {
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
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance == null ? null : entrance.trim();
    }
}