package pers.lagomoro.railway_system.entity;

public class Railway {
    private Integer sidPrev;

    private Integer sidNext;

    private Integer diatance;

    public Railway(Integer sidPrev, Integer sidNext, Integer diatance) {
        this.sidPrev = sidPrev;
        this.sidNext = sidNext;
        this.diatance = diatance;
    }

    public Railway() {
        super();
    }

    public Integer getSidPrev() {
        return sidPrev;
    }

    public void setSidPrev(Integer sidPrev) {
        this.sidPrev = sidPrev;
    }

    public Integer getSidNext() {
        return sidNext;
    }

    public void setSidNext(Integer sidNext) {
        this.sidNext = sidNext;
    }

    public Integer getDiatance() {
        return diatance;
    }

    public void setDiatance(Integer diatance) {
        this.diatance = diatance;
    }
}