package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.Schedule;

public interface ScheduleMapper {
    int insert(Schedule record);

    int insertSelective(Schedule record);
}