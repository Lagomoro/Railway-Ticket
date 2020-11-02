package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Select;
import pers.lagomoro.railway_system.entity.Railway;
import pers.lagomoro.railway_system.entity.SchedulePlus;

import java.util.List;

public interface RailwayMapper {

    @Select("select * from _railway where sid_prev = #{sid_prev, jdbcType=VARCHAR} and sid_next = #{sid_next, jdbcType=VARCHAR}")
    Railway getRailway(int sid_prev, int sid_next);

    //====================================================================================================

    int insert(Railway record);

    int insertSelective(Railway record);
}