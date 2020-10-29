package pers.lagomoro.railway_system.entity.unused;

public class Carriage {
    private Integer cid;

    private String name;

    private Integer seat;

    private Integer line;

    private Integer row;

    private Integer aisle;

    public Carriage(Integer cid, String name, Integer seat, Integer line, Integer row, Integer aisle) {
        this.cid = cid;
        this.name = name;
        this.seat = seat;
        this.line = line;
        this.row = row;
        this.aisle = aisle;
    }

    public Carriage() {
        super();
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