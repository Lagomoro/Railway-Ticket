package pers.lagomoro.railway_system.entity;

public class Railway {
    private Integer sidPrev;

    private Integer sidNext;

    private Integer distance;

    public Railway(Integer sidPrev, Integer sidNext, Integer distance) {
        this.sidPrev = sidPrev;
        this.sidNext = sidNext;
        this.distance = distance;
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}