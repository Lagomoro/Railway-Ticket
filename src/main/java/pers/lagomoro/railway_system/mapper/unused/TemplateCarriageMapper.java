package pers.lagomoro.railway_system.mapper.unused;

import pers.lagomoro.railway_system.entity.unused.TemplateCarriage;

public interface TemplateCarriageMapper {
    int deleteByPrimaryKey(Integer carriageId);

    int insert(TemplateCarriage record);

    int insertSelective(TemplateCarriage record);

    TemplateCarriage selectByPrimaryKey(Integer carriageId);

    int updateByPrimaryKeySelective(TemplateCarriage record);

    int updateByPrimaryKey(TemplateCarriage record);
}