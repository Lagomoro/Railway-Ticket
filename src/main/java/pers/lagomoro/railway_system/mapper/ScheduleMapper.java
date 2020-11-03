package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Select;
import pers.lagomoro.railway_system.entity.Carriage;
import pers.lagomoro.railway_system.entity.Link;
import pers.lagomoro.railway_system.entity.SchedulePlus;
import pers.lagomoro.railway_system.entity.User;
import pers.lagomoro.railway_system.entity.unused.Schedule;

import java.util.List;

public interface ScheduleMapper {

    @Select("select * from _schedule a left join station b on a.sid = b.sid")
    List<SchedulePlus> getAllSchedule();

    @Select("select * from _schedule a left join station b on a.sid = b.sid where tid = #{tid, jdbcType=VARCHAR}")
    List<SchedulePlus> getTrainSchedule(String tid);

    @Select("select * from _link where tid = #{tid, jdbcType=VARCHAR}")
    List<Link> getTrainLink(String tid);

    @Select("select * from carriage")
    List<Carriage> getCarriage();

    //====================================================================================================

    int insert(Schedule record);

    int insertSelective(Schedule record);
}