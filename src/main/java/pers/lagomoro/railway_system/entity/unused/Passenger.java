package pers.lagomoro.railway_system.entity.unused;

public class Passenger {
    private Integer pid;

    private Integer uid;

    private String name;

    private String identity;

    private Integer sex;

    private Integer gid;

    public Passenger(Integer pid, Integer uid, String name, String identity, Integer sex, Integer gid) {
        this.pid = pid;
        this.uid = uid;
        this.name = name;
        this.identity = identity;
        this.sex = sex;
        this.gid = gid;
    }

    public Passenger() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}