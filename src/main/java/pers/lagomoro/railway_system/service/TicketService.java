package pers.lagomoro.railway_system.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import pers.lagomoro.railway_system.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getTicketByOid(int oid);

    Ticket getTicketByTid(int ticket_id);

    void addTicket(Ticket ticket);

    void deleteTicket(int ticket_id);

}
