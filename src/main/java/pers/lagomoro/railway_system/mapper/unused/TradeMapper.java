package pers.lagomoro.railway_system.mapper.unused;

import pers.lagomoro.railway_system.entity.unused.Trade;

public interface TradeMapper {
    int insert(Trade record);

    int insertSelective(Trade record);
}