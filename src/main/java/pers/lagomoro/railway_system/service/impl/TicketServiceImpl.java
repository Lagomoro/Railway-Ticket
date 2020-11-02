package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import pers.lagomoro.railway_system.entity.Ticket;
import pers.lagomoro.railway_system.mapper.TicketMapper;
import pers.lagomoro.railway_system.service.TicketService;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("user")
public class TicketServiceImpl implements TicketService {

    @Resource
    private TicketMapper ticketMapper;

    @Override
    public List<Ticket> getTicketByOid(int oid) {
        return ticketMapper.getTicketByOid(oid);
    }

    @Override
    public Ticket getTicketByTid(int ticket_id) {
        return ticketMapper.getTicketByTid(ticket_id);
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketMapper.addTicket(ticket);
    }

    @Override
    public void deleteTicket(int ticket_id) {
        ticketMapper.deleteTicket(ticket_id);
    }
}
