package pers.lagomoro.railway_system.service;

import pers.lagomoro.railway_system.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> getOrderByUid(int uid);

    Order getOrderByOid(int oid);

    Order getOrderByInfo(int uid, String time);

    void addOrder(Order order);

    void deleteOrder(int oid);

}
