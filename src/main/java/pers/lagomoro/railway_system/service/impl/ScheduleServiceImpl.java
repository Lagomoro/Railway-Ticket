package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import pers.lagomoro.railway_system.entity.SchedulePlus;
import pers.lagomoro.railway_system.mapper.ScheduleMapper;
import pers.lagomoro.railway_system.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("train")
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public List<SchedulePlus> getAllSchedule() { return scheduleMapper.getAllSchedule(); }

    @Override
    public List<SchedulePlus> getTrainSchedule(String tid) { return scheduleMapper.getTrainSchedule(tid); }

}
