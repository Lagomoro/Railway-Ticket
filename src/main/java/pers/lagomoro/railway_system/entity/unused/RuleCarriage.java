package pers.lagomoro.railway_system.entity.unused;

import java.util.Date;

public class RuleCarriage {
    private Integer rid;

    private String tid;

    private Date date;

    private Integer cid;

    private Integer order;

    public RuleCarriage(Integer rid, String tid, Date date, Integer cid, Integer order) {
        this.rid = rid;
        this.tid = tid;
        this.date = date;
        this.cid = cid;
        this.order = order;
    }

    public RuleCarriage() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}