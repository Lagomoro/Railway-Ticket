package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.PassengerGroup;

public interface PassengerGroupMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(PassengerGroup record);

    int insertSelective(PassengerGroup record);

    PassengerGroup selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(PassengerGroup record);

    int updateByPrimaryKey(PassengerGroup record);
}