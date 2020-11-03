package pers.lagomoro.railway_system.entity;

import java.util.Date;

public class Seat {
    private Integer seat_id;

    private String tid;

    private String date;

    private Integer carriage_order;

    private String seat_number;

    private Integer journey;

    public Seat(Integer seat_id, String tid, String date, Integer carriage_order, String seat_number, Integer journey) {
        this.seat_id = seat_id;
        this.tid = tid;
        this.date = date;
        this.carriage_order = carriage_order;
        this.seat_number = seat_number;
        this.journey = journey;
    }

    public Seat() {
        super();
    }

    public Integer getSeatId() {
        return seat_id;
    }

    public void setSeatId(Integer seatId) {
        this.seat_id = seatId;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCarriageOrder() {
        return carriage_order;
    }

    public void setCarriageOrder(Integer carriage_order) {
        this.carriage_order = carriage_order;
    }

    public String getSeatNumber() {
        return seat_number;
    }

    public void setSeatNumber(String seat_number) {
        this.seat_number = seat_number;
    }

    public Integer getJourney() {
        return journey;
    }

    public void setJourney(Integer journey) {
        this.journey = journey;
    }
}