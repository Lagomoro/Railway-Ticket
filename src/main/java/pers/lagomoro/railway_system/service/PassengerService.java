package pers.lagomoro.railway_system.service;

import pers.lagomoro.railway_system.entity.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> getPassenger(String uid);

    int addPassenger(Passenger passenger);
}
