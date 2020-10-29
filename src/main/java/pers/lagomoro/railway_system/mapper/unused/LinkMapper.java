package pers.lagomoro.railway_system.mapper.unused;

import pers.lagomoro.railway_system.entity.unused.Link;

public interface LinkMapper {
    int insert(Link record);

    int insertSelective(Link record);
}