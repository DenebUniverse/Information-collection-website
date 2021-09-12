package cn.edu.uibe.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.uibe.dao.ProjectMapper;
import cn.edu.uibe.dao.TaskplanMapper;
import cn.edu.uibe.dao.TaskrealMapper;
import cn.edu.uibe.domain.Project;
import cn.edu.uibe.domain.Taskplan;
import cn.edu.uibe.domain.Taskreal;
import cn.edu.uibe.myClass.MyTable;
import cn.edu.uibe.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

		@Autowired
		ProjectMapper projectMapper;

		@Autowired
		TaskrealMapper taskrealMapper;
		
		@Autowired
		TaskplanMapper taskplanMapper;

		@Override
		public Project selectProjectById(String projectId) {//查询项目
			long pid = Long.parseLong(StringUtils.trimToEmpty(projectId));
			Project project=projectMapper.selectByPrimaryKey(pid);
			return project;
		}
		
		@Override
		public List<Project> getAllProject() {//查询所有项目
			List<Project> projectList=projectMapper.getAllProject();
			return projectList;
		}

		@Override
		public String check_project_insert(String colLen, String rowLen, String colList, String rowList, String ddl) {//检验添加项目的数据
			String message ="";
			int col_int= Integer. parseInt(StringUtils.trimToEmpty(colLen));
			int row_int= Integer. parseInt(StringUtils.trimToEmpty(rowLen));	
			String[] ColList2=colList.split(",");
			int col_int2=ColList2.length;
			String[] RowList2=rowList.split(",");
			int row_int2=RowList2.length;
			if(col_int2!=col_int||row_int2!=row_int) {
				message=message+"行列名称与行列数不符";
			}
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date date=formatter.parse(ddl);
			} catch (ParseException e) {
				message=message+"日期格式错误";
				return message;
			}
			return message;
		}

		@Override
		public boolean add_project(String projectName, String details, String colLen, String rowLen, String colList,
				String rowList, String ddl, String manager) {//增加项目
			int col_int= Integer. parseInt(StringUtils.trimToEmpty(colLen));
			int row_int= Integer. parseInt(StringUtils.trimToEmpty(rowLen));
			Project project=new Project();
			project.setProjectname(projectName);
			project.setDetails(details);
			project.setCollen(col_int);
			project.setRowlen(row_int);
			project.setCollist(colList);
			project.setRowlist(rowList);
			project.setCreatedtime(new Date());
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				project.setDdl(formatter.parse(ddl));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			project.setManager(manager);

		    int count = projectMapper.insert(project);
		    return count==1;//true表示成功
		}

		@Override
		public List<Taskreal> getTaskrealByProjectId(String projectId) {//查询实际进度
			long pid = Long.parseLong(StringUtils.trimToEmpty(projectId));
			List<Taskreal> taskList =taskrealMapper.selectByProjectId(pid);	
			return taskList;
		}

		@Override
		public MyTable<String> SumTaskById(String projectId) {//表格化实际进度
			List<Taskreal> taskList =getTaskrealByProjectId(projectId);
			Project project=selectProjectById(projectId);
			
			MyTable<String> mytable = new MyTable<String>();
			mytable.setTableName(project.getProjectname());
			String ColName=project.getCollist();
			String[] ColList=ColName.split(",");
			String RowName=project.getRowlist();
			String[] RowList=RowName.split(",");
			mytable.setColNames(ColList);
			mytable.setRowNames(RowList);
			int ColLen=ColList.length;
			int RowLen=RowList.length;
			mytable.setColLen(ColLen);
			mytable.setRowLen(RowLen);
			
			String[][] matrix= new String[RowLen][ColLen];
			for (String[] row: matrix)
			    Arrays.fill(row, "");
			
			for (int i = 0; i < taskList.size(); i++) {
				Taskreal task=taskList.get(i);
				String str="工作量:"+String.valueOf(task.getQuota())+"  成本:"+String.valueOf(task.getCost());
				for(int j = 0; j < task.getPeriod(); j++)
					matrix[task.getTasknumber()-1][task.getStartedtime()-1+j]=str;
			}
			
			mytable.setMatrix(matrix);
			return mytable;
		}
		
		@Override
		public List<Taskplan> getTaskplanByProjectId(String projectId) {//查询计划进度
			long pid = Long.parseLong(StringUtils.trimToEmpty(projectId));
			List<Taskplan> planList =taskplanMapper.selectByProjectId(pid);	
			return planList;
		}

		@Override
		public MyTable<String> SumPlanById(String projectId) {//表格化计划进度
			List<Taskplan> planList =getTaskplanByProjectId(projectId);
			Project project=selectProjectById(projectId);
			
			MyTable<String> mytable = new MyTable<String>();
			mytable.setTableName(project.getProjectname());
			String ColName=project.getCollist();
			String[] ColList=ColName.split(",");
			String RowName=project.getRowlist();
			String[] RowList=RowName.split(",");
			mytable.setColNames(ColList);
			mytable.setRowNames(RowList);
			int ColLen=ColList.length;
			int RowLen=RowList.length;	
			mytable.setColLen(ColLen);
			mytable.setRowLen(RowLen);
			String[][] matrix= new String[RowLen][ColLen];
			
			for (String[] row: matrix)
			    Arrays.fill(row, "");
			
			for (int i = 0; i < planList.size(); i++) {
				Taskplan plan=planList.get(i);
				String str="工作量:"+String.valueOf(plan.getQuota())+"  成本:"+String.valueOf(plan.getCost());
				for(int j = 0; j < plan.getPeriod(); j++)
					matrix[plan.getTasknumber()-1][plan.getStartedtime()-1+j]=str;
			}
			mytable.setMatrix(matrix);
			return mytable;
		}
		
		
		@Override
		@Transactional
		public boolean add_plan(String projectid, String taskname, String details, String tasknumber,
				String startedtime, String period, String quota, String cost, String submitter) {	
			
			List<Taskplan> planlist=getTaskplanByProjectId(projectid);
			
			int tasknumber_int= Integer. parseInt(StringUtils.trimToEmpty(tasknumber));
			for(Taskplan p:planlist) {
				if(p.getTasknumber()==tasknumber_int) {
					delete_plan(String.valueOf(p.getPlanid()));
				}
			}
			
			long pid = Long.parseLong(StringUtils.trimToEmpty(projectid));
			int startedtime_int= Integer. parseInt(StringUtils.trimToEmpty(startedtime));
			int period_int= Integer. parseInt(StringUtils.trimToEmpty(period));
			float quota_float=Float.parseFloat(StringUtils.trimToEmpty(quota));
			float cost_float=Float.parseFloat(StringUtils.trimToEmpty(cost));
			
			Taskplan plan=new Taskplan();
			plan.setProjectid(pid);
			plan.setCost(cost_float);
			plan.setDetails(details);
			plan.setPeriod(period_int);
			plan.setQuota(quota_float);
			plan.setStartedtime(startedtime_int);
			plan.setSubmitter(submitter);
			plan.setTaskname(taskname);
			plan.setTasknumber(tasknumber_int);

		    int count = taskplanMapper.insert(plan);
		    return count==1;
		}

		@Override
		@Transactional
		public boolean delete_plan(String planid) {
			long pid = Long.parseLong(StringUtils.trimToEmpty(planid));
		    int count = taskplanMapper.deleteByPrimaryKey(pid);
		    return count==1;//true表示成功
		}

		@Override
		@Transactional
		public boolean add_task(String projectid, String taskname, String details, String tasknumber,
				String startedtime, String period, String quota, String cost, String submitter) {//先查，删除，再插入
			List<Taskreal> tasklist=getTaskrealByProjectId(projectid);
			int tasknumber_int= Integer. parseInt(StringUtils.trimToEmpty(tasknumber));
			for(Taskreal t:tasklist) {
				if(t.getTasknumber()==tasknumber_int) {
					delete_task(String.valueOf(t.getTaskid()));
				}
			}
			long pid = Long.parseLong(StringUtils.trimToEmpty(projectid));
			int startedtime_int= Integer. parseInt(StringUtils.trimToEmpty(startedtime));
			int period_int= Integer. parseInt(StringUtils.trimToEmpty(period));
			float quota_float=Float.parseFloat(StringUtils.trimToEmpty(quota));
			float cost_float=Float.parseFloat(StringUtils.trimToEmpty(cost));
			
			Taskreal task=new Taskreal();
			task.setProjectid(pid);
			task.setCost(cost_float);
			task.setDetails(details);
			task.setPeriod(period_int);
			task.setQuota(quota_float);
			task.setStartedtime(startedtime_int);
			task.setSubmitter(submitter);
			task.setTaskname(taskname);
			task.setTasknumber(tasknumber_int);

		    int count = taskrealMapper.insert(task);
		    return count==1;
		}

		@Override
		@Transactional
		public boolean delete_task(String taskid) {
			long tid = Long.parseLong(StringUtils.trimToEmpty(taskid));
		    int count = taskrealMapper.deleteByPrimaryKey(tid);
		    return count==1;//true表示成功
		}


		
}
