package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import pers.lagomoro.railway_system.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderMapper {

    @Select("select * from `order` where uid = #{uid, jdbcType=INTEGER}")
    List<Order> getOrderByUid(int uid);

    @Select("select * from `order` where oid = #{oid, jdbcType=INTEGER}")
    Order getOrderByOid(int oid);

    @Select("select * from `order` where uid = #{uid, jdbcType=INTEGER} and time = #{time, jdbcType=VARCHAR}")
    Order getOrderByInfo(int uid, String time);

    @Select("insert into `order` (uid, `time`, price) values " +
            "(#{uid, jdbcType=INTEGER}, #{time, jdbcType=VARCHAR}, #{price, jdbcType=INTEGER})")
    void addOrder(Order order);

    @Delete("delete from `order` where `oid` = #{oid, jdbcType=INTEGER};")
    void deleteOrder(int oid);

    //====================================================================================================

    int deleteByPrimaryKey(Integer oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}