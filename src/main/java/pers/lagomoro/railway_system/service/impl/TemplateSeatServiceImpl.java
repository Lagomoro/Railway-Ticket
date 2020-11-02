package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import pers.lagomoro.railway_system.entity.Seat;
import pers.lagomoro.railway_system.mapper.StationMapper;
import pers.lagomoro.railway_system.mapper.TemplateSeatMapper;
import pers.lagomoro.railway_system.service.TemplateSeatService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@DS("cache")
public class TemplateSeatServiceImpl implements TemplateSeatService {

    @Resource
    private TemplateSeatMapper templateSeatMapper;

    @Override
    public List<Seat> getSeatByInfo(String tid, String date) {
        return templateSeatMapper.getSeatByInfo(tid, date);
    }

    @Override
    public Seat getSeatBySeatId(int seat_id) {
        return templateSeatMapper.getSeatBySeatId(seat_id);
    }

    @Override
    public void addSeat(Seat seat) {
        templateSeatMapper.addSeat(seat);
    }

    @Override
    public void deleteSeat(int seat_id) {
        templateSeatMapper.deleteSeat(seat_id);
    }

    @Override
    public void modifyJourney(int seat_id, int journey) {
        templateSeatMapper.modifyJourney(seat_id, journey);
    }
}
