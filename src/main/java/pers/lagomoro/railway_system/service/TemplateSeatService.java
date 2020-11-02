package pers.lagomoro.railway_system.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.lagomoro.railway_system.entity.Seat;

import java.util.Date;
import java.util.List;

public interface TemplateSeatService {

    List<Seat> getSeatByInfo(String tid, String date);

    Seat getSeatBySeatId(int seat_id);

    void addSeat(Seat seat);

    void deleteSeat(int seat_id);

    void modifyJourney(int seat_id, int journey);

}
