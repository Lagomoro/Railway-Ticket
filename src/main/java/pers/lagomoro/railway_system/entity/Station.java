package pers.lagomoro.railway_system.entity;

public class Station {
    private Integer sid;

    private String name;

    public Station(Integer sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    public Station() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}