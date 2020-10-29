package pers.lagomoro.railway_system.mapper.unused;

import pers.lagomoro.railway_system.entity.unused.Railway;

public interface RailwayMapper {
    int insert(Railway record);

    int insertSelective(Railway record);
}