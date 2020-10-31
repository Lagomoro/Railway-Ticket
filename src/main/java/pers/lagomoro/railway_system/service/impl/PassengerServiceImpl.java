package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import pers.lagomoro.railway_system.entity.Passenger;
import pers.lagomoro.railway_system.mapper.PassengerMapper;
import pers.lagomoro.railway_system.mapper.ScheduleMapper;
import pers.lagomoro.railway_system.service.PassengerService;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("user")
public class PassengerServiceImpl implements PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    @Override
    public List<Passenger> getPassenger(String uid) {
        return passengerMapper.getPassenger(uid);
    }

    @Override
    public int addPassenger(Passenger passenger) {
        return passengerMapper.addPassenger(passenger);
    }
}
