package cn.edu.uibe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.edu.uibe.domain.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Long projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Long projectid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    @Select("select * from project")
	List<Project> getAllProject();


}