package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import pers.lagomoro.railway_system.entity.Order;
import pers.lagomoro.railway_system.mapper.OrderMapper;
import pers.lagomoro.railway_system.mapper.PassengerMapper;
import pers.lagomoro.railway_system.service.OrderService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@DS("user")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrderByUid(int uid) {
        return orderMapper.getOrderByUid(uid);
    }

    @Override
    public Order getOrderByOid(int oid) {
        return orderMapper.getOrderByOid(oid);
    }

    @Override
    public Order getOrderByInfo(int uid, String time) {
        return orderMapper.getOrderByInfo(uid, time);
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void deleteOrder(int oid) {
        orderMapper.deleteOrder(oid);
    }
}
