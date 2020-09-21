package pers.lagomoro.railway_system.entity;

public class PassengerGroup {
    private Integer gid;

    private String name;

    private Byte enabled;

    public PassengerGroup(Integer gid, String name, Byte enabled) {
        this.gid = gid;
        this.name = name;
        this.enabled = enabled;
    }

    public PassengerGroup() {
        super();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }
}