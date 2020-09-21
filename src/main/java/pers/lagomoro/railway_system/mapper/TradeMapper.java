package pers.lagomoro.railway_system.mapper;

import pers.lagomoro.railway_system.entity.Trade;

public interface TradeMapper {
    int insert(Trade record);

    int insertSelective(Trade record);
}