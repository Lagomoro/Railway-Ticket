package pers.lagomoro.railway_system.service;

import pers.lagomoro.railway_system.entity.Passenger;
import pers.lagomoro.railway_system.entity.Railway;

import java.util.List;

public interface RailwayService {

    Railway getRailway(int sid_prev, int sid_next);

}
