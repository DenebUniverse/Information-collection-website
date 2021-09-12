package cn.edu.uibe.dao;

import java.util.List;

import cn.edu.uibe.domain.Submit;

public interface SubmitMapper {
    int deleteByPrimaryKey(Long submitid);

	int insert(Submit record);

	int insertSelective(Submit record);

	Submit selectByPrimaryKey(Long submitid);

	int updateByPrimaryKeySelective(Submit record);

	int updateByPrimaryKey(Submit record);
	
	List<Submit> selectBycollectId(Long collectId);
}