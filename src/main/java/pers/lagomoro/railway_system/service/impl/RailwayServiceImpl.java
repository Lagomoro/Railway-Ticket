package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import pers.lagomoro.railway_system.entity.Railway;
import pers.lagomoro.railway_system.mapper.PassengerMapper;
import pers.lagomoro.railway_system.mapper.RailwayMapper;
import pers.lagomoro.railway_system.service.RailwayService;

import javax.annotation.Resource;

@Service
@DS("train")
public class RailwayServiceImpl implements RailwayService {

    @Resource
    private RailwayMapper railwayMapper;

    @Override
    public Railway getRailway(int sid_prev, int sid_next) {
        return railwayMapper.getRailway(sid_prev, sid_next);
    }

}
