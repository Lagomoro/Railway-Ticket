package pers.lagomoro.railway_system.service;

import org.apache.ibatis.annotations.Select;
import pers.lagomoro.railway_system.entity.Carriage;
import pers.lagomoro.railway_system.entity.Link;
import pers.lagomoro.railway_system.entity.SchedulePlus;

import java.util.List;

public interface ScheduleService {

    List<SchedulePlus> getAllSchedule();

    List<SchedulePlus> getTrainSchedule(String tid);

    List<Link> getTrainLink(String tid);

    List<Carriage> getCarriage();

}
