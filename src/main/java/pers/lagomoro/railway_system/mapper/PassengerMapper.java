package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.Passenger;

public interface PassengerMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Passenger record);

    int insertSelective(Passenger record);

    Passenger selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Passenger record);

    int updateByPrimaryKey(Passenger record);
}