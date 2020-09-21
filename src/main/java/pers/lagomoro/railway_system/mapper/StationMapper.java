package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.Station;

public interface StationMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
}