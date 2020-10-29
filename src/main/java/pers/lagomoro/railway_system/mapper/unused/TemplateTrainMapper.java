package pers.lagomoro.railway_system.mapper.unused;

import pers.lagomoro.railway_system.entity.unused.TemplateTrain;

public interface TemplateTrainMapper {
    int deleteByPrimaryKey(Integer trainId);

    int insert(TemplateTrain record);

    int insertSelective(TemplateTrain record);

    TemplateTrain selectByPrimaryKey(Integer trainId);

    int updateByPrimaryKeySelective(TemplateTrain record);

    int updateByPrimaryKey(TemplateTrain record);
}