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
    public List<Passenger> getPassengerByUid(int uid) {
        return passengerMapper.getPassengerByUid(uid);
    }

    @Override
    public Passenger getPassengerByPid(int pid) {
        return passengerMapper.getPassengerByPid(pid);
    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengerMapper.addPassenger(passenger);
    }

    @Override
    public void deletePassenger(int pid) {
        passengerMapper.deletePassenger(pid);
    }

    @Override
    public void modifyPassenger(Passenger passenger) {
        passengerMapper.modifyPassenger(passenger);
    }
}
