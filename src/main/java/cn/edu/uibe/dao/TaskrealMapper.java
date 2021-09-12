package cn.edu.uibe.dao;

import java.util.List;

import cn.edu.uibe.domain.Taskreal;

public interface TaskrealMapper {
    int deleteByPrimaryKey(Long taskid);

    int insert(Taskreal record);

    int insertSelective(Taskreal record);

    Taskreal selectByPrimaryKey(Long taskid);

    int updateByPrimaryKeySelective(Taskreal record);

    int updateByPrimaryKey(Taskreal record);

	List<Taskreal> selectByProjectId(long projectid);

}