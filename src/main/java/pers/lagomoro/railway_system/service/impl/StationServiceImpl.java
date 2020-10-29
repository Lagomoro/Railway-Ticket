package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import pers.lagomoro.railway_system.entity.Station;
import pers.lagomoro.railway_system.mapper.StationMapper;
import pers.lagomoro.railway_system.service.StationService;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("train")
public class StationServiceImpl implements StationService {

    @Resource
    private StationMapper stationMapper;

    @Override
    public List<Station> getAllStation() {
        return stationMapper.getAllStation();
    }

}
