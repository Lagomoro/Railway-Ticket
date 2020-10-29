package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Select;
import pers.lagomoro.railway_system.entity.Station;

import java.util.List;

public interface StationMapper {

    @Select("select * from station")
    List<Station> getAllStation();

    //====================================================================================================

    int deleteByPrimaryKey(Integer sid);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
}