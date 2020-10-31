package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Select;
import pers.lagomoro.railway_system.entity.Passenger;

import java.util.List;

public interface PassengerMapper {

    @Select("select * from passenger where uid = #{uid, jdbcType=INTEGER}")
    List<Passenger> getPassenger(String uid);

    @Select("insert into passenger (uid, name, identity, sex, gid) values (#{passenger.uid, jdbcType=INTEGER}," +
            "#{passenger.name, jdbcType=VARCHAR}, #{passenger.identity, jdbcType=VARCHAR}," +
            "#{passenger.sex, jdbcType=INTEGER}, #{passenger.gid, jdbcType=INTEGER})")
    int addPassenger(Passenger passenger);

    //====================================================================================================

    int deleteByPrimaryKey(Integer pid);

    int insert(Passenger record);

    int insertSelective(Passenger record);

    Passenger selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Passenger record);

    int updateByPrimaryKey(Passenger record);
}