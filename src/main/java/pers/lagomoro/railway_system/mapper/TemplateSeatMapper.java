package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.lagomoro.railway_system.entity.Seat;
import pers.lagomoro.railway_system.entity.unused.TemplateSeat;

import java.util.Date;
import java.util.List;

public interface TemplateSeatMapper {

    @Select("select * from template_seat where tid = #{tid, jdbcType=VARCHAR} and `date` = #{date, jdbcType=VARCHAR}")
    List<Seat> getSeatByInfo(String tid, String date);

    @Select("select * from template_seat where `seat_id` = #{seat_id, jdbcType=INTEGER}")
    Seat getSeatBySeatId(int seat_id);

    @Select("insert into template_seat (tid, date, carriage_order, seat_number) values " +
            "(#{tid, jdbcType=VARCHAR}, #{date, jdbcType=VARCHAR}, " +
            "#{carriage_order, jdbcType=INTEGER}, #{seat_number, jdbcType=VARCHAR})")
    void addSeat(Seat seat);

    @Delete("delete from template_seat where seat_id = #{seat_id, jdbcType=INTEGER}")
    void deleteSeat(int seat_id);

    @Update("update template_seat set `journey` = #{journey, jdbcType=INTEGER} where `seat_id` = #{seat_id, jdbcType=INTEGER}")
    void modifyJourney(int seat_id, int journey);

    //====================================================================================================

    int deleteByPrimaryKey(Integer seatId);

    int insert(TemplateSeat record);

    int insertSelective(TemplateSeat record);

    TemplateSeat selectByPrimaryKey(Integer seatId);

    int updateByPrimaryKeySelective(TemplateSeat record);

    int updateByPrimaryKey(TemplateSeat record);
}