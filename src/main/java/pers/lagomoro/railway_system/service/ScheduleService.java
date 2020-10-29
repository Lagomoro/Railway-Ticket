package pers.lagomoro.railway_system.service;

import pers.lagomoro.railway_system.entity.SchedulePlus;

import java.util.List;

public interface ScheduleService {

    List<SchedulePlus> getAllSchedule();

    List<SchedulePlus> getTrainSchedule(String tid);

}
