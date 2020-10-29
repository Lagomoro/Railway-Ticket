package pers.lagomoro.railway_system.entity.unused;

public class Link {
    private String tid;

    private Integer cid;

    private Integer order;

    public Link(String tid, Integer cid, Integer order) {
        this.tid = tid;
        this.cid = cid;
        this.order = order;
    }

    public Link() {
        super();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
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