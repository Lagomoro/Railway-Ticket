package pers.lagomoro.railway_system.mapper.unused;

import pers.lagomoro.railway_system.entity.unused.PassengerGroup;

public interface PassengerGroupMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(PassengerGroup record);

    int insertSelective(PassengerGroup record);

    PassengerGroup selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(PassengerGroup record);

    int updateByPrimaryKey(PassengerGroup record);
}