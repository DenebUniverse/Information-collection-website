package cn.edu.uibe.service;

import java.util.List;

import cn.edu.uibe.domain.Project;
import cn.edu.uibe.domain.Taskplan;
import cn.edu.uibe.domain.Taskreal;
import cn.edu.uibe.myClass.MyTable;

public interface ProjectService {
	List<Project> getAllProject();

	String check_project_insert(String colLen, String rowLen, String colList, String rowList, String ddl);

	boolean add_project(String projectName, String details, String colLen, String rowLen, String colList,
			String rowList, String ddl, String manager);

	List<Taskreal> getTaskrealByProjectId(String projectId);

	Project selectProjectById(String projectId);

	MyTable<String> SumTaskById(String projectId);

	MyTable<String> SumPlanById(String projectId);

	List<Taskplan> getTaskplanByProjectId(String projectId);

	boolean add_plan(String projectid, String taskname, String details, String tasknumber, String startedtime,
			String period, String quota, String cost, String submitter);

	boolean delete_plan(String planid);

	boolean add_task(String projectid, String taskname, String details, String tasknumber, String startedtime,
			String period, String quota, String cost, String submitter);

	boolean delete_task(String taskid);

	



}
