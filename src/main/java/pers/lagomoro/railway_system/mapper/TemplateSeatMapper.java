package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.TemplateSeat;

public interface TemplateSeatMapper {
    int deleteByPrimaryKey(Integer seatId);

    int insert(TemplateSeat record);

    int insertSelective(TemplateSeat record);

    TemplateSeat selectByPrimaryKey(Integer seatId);

    int updateByPrimaryKeySelective(TemplateSeat record);

    int updateByPrimaryKey(TemplateSeat record);
}