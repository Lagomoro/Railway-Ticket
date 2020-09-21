package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.Railway;

public interface RailwayMapper {
    int insert(Railway record);

    int insertSelective(Railway record);
}