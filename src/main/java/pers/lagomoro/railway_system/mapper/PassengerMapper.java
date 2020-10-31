package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.lagomoro.railway_system.entity.Passenger;

import java.util.List;

public interface PassengerMapper {

    @Select("select * from passenger where uid = #{uid, jdbcType=INTEGER}")
    List<Passenger> getPassengerByUid(int uid);

    @Select("select * from passenger where pid = #{pid, jdbcType=INTEGER}")
    Passenger getPassengerByPid(int pid);

    @Select("insert into passenger (uid, name, identity, sex, gid) values (#{uid, jdbcType=INTEGER}," +
            "#{name, jdbcType=VARCHAR}, #{identity, jdbcType=VARCHAR}," +
            "#{sex, jdbcType=INTEGER}, #{gid, jdbcType=INTEGER})")
    void addPassenger(Passenger passenger);

    @Delete("delete from passenger where `pid` = #{pid, jdbcType=INTEGER};")
    void deletePassenger(int pid);

    @Update("update passenger set `name` = #{name, jdbcType=VARCHAR}, `identity` = #{identity, jdbcType=VARCHAR}, " +
            "`sex` = #{sex, jdbcType=INTEGER}, `gid` = #{gid, jdbcType=INTEGER} where `pid` = #{pid, jdbcType=INTEGER}")
    void modifyPassenger(Passenger passenger);

    //====================================================================================================

    int deleteByPrimaryKey(Integer pid);

    int insert(Passenger record);

    int insertSelective(Passenger record);

    Passenger selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Passenger record);

    int updateByPrimaryKey(Passenger record);
}