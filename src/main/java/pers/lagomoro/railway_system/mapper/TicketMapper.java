package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.lagomoro.railway_system.entity.Passenger;
import pers.lagomoro.railway_system.entity.Ticket;

import java.util.List;

public interface TicketMapper {

    @Select("select * from ticket where oid = #{oid, jdbcType=INTEGER}")
    List<Ticket> getTicketByOid(int oid);

    @Select("select * from ticket where ticket_id = #{ticket_id, jdbcType=INTEGER}")
    Ticket getTicketByTid(int ticket_id);

    @Select("insert into ticket (oid, seat_id, journey, passenger_name, passenger_identity, passenger_gid) values " +
            "(#{oid, jdbcType=INTEGER}, #{seat_id, jdbcType=INTEGER}, #{journey, jdbcType=INTEGER}, " +
            "#{passenger_name, jdbcType=VARCHAR}, #{passenger_identity, jdbcType=VARCHAR}, #{passenger_gid, jdbcType=INTEGER})")
    void addTicket(Ticket ticket);

    @Delete("delete from ticket where `ticket_id` = #{ticket_id, jdbcType=INTEGER};")
    void deleteTicket(int ticket_id);

    //====================================================================================================

    int deleteByPrimaryKey(Integer ticketId);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Integer ticketId);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}