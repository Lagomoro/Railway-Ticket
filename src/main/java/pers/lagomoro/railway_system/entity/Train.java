package pers.lagomoro.railway_system.entity;

public class Train {
    private String tid;

    private Integer typeId;

    private Byte enabled;

    private Integer conductorOrder;

    public Train(String tid, Integer typeId, Byte enabled, Integer conductorOrder) {
        this.tid = tid;
        this.typeId = typeId;
        this.enabled = enabled;
        this.conductorOrder = conductorOrder;
    }

    public Train() {
        super();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public Integer getConductorOrder() {
        return conductorOrder;
    }

    public void setConductorOrder(Integer conductorOrder) {
        this.conductorOrder = conductorOrder;
    }
}