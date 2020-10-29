package pers.lagomoro.railway_system.entity.unused;

import java.util.Date;

public class TemplateSeat {
    private Integer seatId;

    private String tid;

    private Date date;

    private Integer carriageOrder;

    private Integer seatNumber;

    private Integer journey;

    public TemplateSeat(Integer seatId, String tid, Date date, Integer carriageOrder, Integer seatNumber, Integer journey) {
        this.seatId = seatId;
        this.tid = tid;
        this.date = date;
        this.carriageOrder = carriageOrder;
        this.seatNumber = seatNumber;
        this.journey = journey;
    }

    public TemplateSeat() {
        super();
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCarriageOrder() {
        return carriageOrder;
    }

    public void setCarriageOrder(Integer carriageOrder) {
        this.carriageOrder = carriageOrder;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getJourney() {
        return journey;
    }

    public void setJourney(Integer journey) {
        this.journey = journey;
    }
}