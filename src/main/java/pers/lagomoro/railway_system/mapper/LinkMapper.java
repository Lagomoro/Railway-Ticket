package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.Link;

public interface LinkMapper {
    int insert(Link record);

    int insertSelective(Link record);
}