package pers.lagomoro.railway_system.service;

import pers.lagomoro.railway_system.entity.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> getPassengerByUid(int uid);

    Passenger getPassengerByPid(int pid);

    void addPassenger(Passenger passenger);

    void deletePassenger(int pid);

    void modifyPassenger(Passenger passenger);
}
