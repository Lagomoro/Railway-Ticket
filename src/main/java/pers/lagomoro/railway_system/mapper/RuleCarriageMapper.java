package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.RuleCarriage;

public interface RuleCarriageMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(RuleCarriage record);

    int insertSelective(RuleCarriage record);

    RuleCarriage selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(RuleCarriage record);

    int updateByPrimaryKey(RuleCarriage record);
}