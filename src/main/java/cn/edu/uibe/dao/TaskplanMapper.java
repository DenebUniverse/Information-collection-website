package cn.edu.uibe.dao;

import java.util.List;

import cn.edu.uibe.domain.Taskplan;

public interface TaskplanMapper {
    int deleteByPrimaryKey(Long planid);

    int insert(Taskplan record);

    int insertSelective(Taskplan record);

    Taskplan selectByPrimaryKey(Long planid);

    int updateByPrimaryKeySelective(Taskplan record);

    int updateByPrimaryKey(Taskplan record);

	List<Taskplan> selectByProjectId(long projectid);

}