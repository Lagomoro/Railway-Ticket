package pers.lagomoro.railway_system.entity;

import java.util.Date;

public class RuleEnabled {
    private Integer rid;

    private String tid;

    private Date date;

    private Byte enabled;

    public RuleEnabled(Integer rid, String tid, Date date, Byte enabled) {
        this.rid = rid;
        this.tid = tid;
        this.date = date;
        this.enabled = enabled;
    }

    public RuleEnabled() {
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

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }
}