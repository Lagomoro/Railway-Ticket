package pers.lagomoro.railway_system.entity;

public class Trade {
    private Integer gid;

    private Integer eid;

    private Integer discount;

    public Trade(Integer gid, Integer eid, Integer discount) {
        this.gid = gid;
        this.eid = eid;
        this.discount = discount;
    }

    public Trade() {
        super();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}