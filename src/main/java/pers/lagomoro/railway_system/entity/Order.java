package pers.lagomoro.railway_system.entity;

import java.util.Date;

public class Order {
    private Integer oid;

    private Integer uid;

    private Date time;

    private Integer price;

    private Integer status;

    public Order(Integer oid, Integer uid, Date time, Integer price, Integer status) {
        this.oid = oid;
        this.uid = uid;
        this.time = time;
        this.price = price;
        this.status = status;
    }

    public Order() {
        super();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}