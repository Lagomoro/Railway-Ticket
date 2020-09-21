package pers.lagomoro.railway_system.entity;

public class TemplateCarriage {
    private Integer carriageId;

    private Integer cid;

    private String name;

    private Integer seat;

    private Integer line;

    private Integer row;

    private Integer aisle;

    public TemplateCarriage(Integer carriageId, Integer cid, String name, Integer seat, Integer line, Integer row, Integer aisle) {
        this.carriageId = carriageId;
        this.cid = cid;
        this.name = name;
        this.seat = seat;
        this.line = line;
        this.row = row;
        this.aisle = aisle;
    }

    public TemplateCarriage() {
        super();
    }

    public Integer getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(Integer carriageId) {
        this.carriageId = carriageId;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getAisle() {
        return aisle;
    }

    public void setAisle(Integer aisle) {
        this.aisle = aisle;
    }
}