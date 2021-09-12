package cn.edu.uibe.dao;

import java.util.List;

import cn.edu.uibe.domain.Forbid;

public interface ForbidMapper {
    int deleteByPrimaryKey(Long forbidid);

    int insert(Forbid record);

    int insertSelective(Forbid record);

    Forbid selectByPrimaryKey(Long forbidid);

    int updateByPrimaryKeySelective(Forbid record);

    int updateByPrimaryKey(Forbid record);
    
    List<Forbid> selectBycollectId(Long collectId);	
}