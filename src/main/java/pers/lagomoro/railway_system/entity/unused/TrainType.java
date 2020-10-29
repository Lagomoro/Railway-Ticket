package pers.lagomoro.railway_system.entity.unused;

public class TrainType {
    private Integer typeId;

    private String name;

    public TrainType(Integer typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public TrainType() {
        super();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}