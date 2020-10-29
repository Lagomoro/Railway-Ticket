package pers.lagomoro.railway_system.mapper.unused;

import pers.lagomoro.railway_system.entity.unused.Train;

public interface TrainMapper {
    int deleteByPrimaryKey(String tid);

    int insert(Train record);

    int insertSelective(Train record);

    Train selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);
}