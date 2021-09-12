package cn.edu.uibe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.edu.uibe.domain.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(Long collectid);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Long collectid);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    
    @Select("select * from collect")
    List<Collect> getAllCollect();
}