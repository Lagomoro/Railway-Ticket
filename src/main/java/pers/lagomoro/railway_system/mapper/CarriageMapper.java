package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.Carriage;

public interface CarriageMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Carriage record);

    int insertSelective(Carriage record);

    Carriage selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Carriage record);

    int updateByPrimaryKey(Carriage record);
}