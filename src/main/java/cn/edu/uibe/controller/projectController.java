package cn.edu.uibe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.uibe.domain.Project;
import cn.edu.uibe.domain.Taskplan;
import cn.edu.uibe.domain.Taskreal;
import cn.edu.uibe.myClass.MyTable;
import cn.edu.uibe.service.ProjectService;

@RestController
public class projectController {
	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/project")
	public ModelAndView project(){
		List<Project> projectList=projectService.getAllProject();
		return new ModelAndView("project", "projects", projectList);
	}

	@RequestMapping("/add_project")
	public ModelAndView add_collect(@RequestParam(defaultValue="") String projectName,
			@RequestParam(defaultValue="") String details,
			@RequestParam(defaultValue="") String colLen,
			@RequestParam(defaultValue="") String rowLen,
			@RequestParam(defaultValue="") String colList,
			@RequestParam(defaultValue="") String rowList,
			@RequestParam(defaultValue="") String ddl,
			@RequestParam(defaultValue="") String manager
			){
		String message=projectService.check_project_insert(colLen,rowLen,colList,rowList,ddl);
		boolean success = projectService.add_project(projectName,details,colLen,rowLen,colList,rowList,ddl,manager);
		if(success) {
			return new ModelAndView("do_project","projectName",projectName);
		}else {
			return new ModelAndView("error","message","提交失败 "+message);
		}
	}

	@RequestMapping("/task")//项目任务
	public ModelAndView task(@RequestParam(defaultValue="") String projectId){
		Project project=projectService.selectProjectById(projectId);
		List<Taskplan> planList =projectService.getTaskplanByProjectId(projectId);
		MyTable<String> planTable=projectService.SumPlanById(projectId);
		List<Taskreal> taskList =projectService.getTaskrealByProjectId(projectId);
		MyTable<String> taskTable=projectService.SumTaskById(projectId);
		Map<String,Object> model = new HashMap<>();
		model.put("project", project);
		model.put("plans", planList);
		model.put("planTable", planTable);
		model.put("tasks",taskList);
		model.put("taskTable",taskTable);
		return new ModelAndView("task",model);
	}

	@RequestMapping("/add_plan")
	public ModelAndView add_plan(@RequestParam(defaultValue="") String projectid,
			@RequestParam(defaultValue="") String tasknumber,
			@RequestParam(defaultValue="") String taskname,
			@RequestParam(defaultValue="") String details,
			@RequestParam(defaultValue="") String startedtime,
			@RequestParam(defaultValue="") String period,
			@RequestParam(defaultValue="") String quota,
			@RequestParam(defaultValue="") String cost,
			@RequestParam(defaultValue="") String submitter
			){
		boolean success = projectService.add_plan(projectid,taskname,details,tasknumber,startedtime,period,quota,cost,submitter);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("projectid",projectid);
			model.put("returnPage", "task");
			return new ModelAndView("do_add",model);
		}else {
			return new ModelAndView("error","message","提交失败");
		}
	}
	
	@RequestMapping("/delete_plan")
	public ModelAndView delete_plan(@RequestParam(defaultValue="") String planid,
									  @RequestParam(defaultValue="") String projectid){
		boolean success = projectService.delete_plan(planid);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("projectid",projectid);
			model.put("returnPage", "task");
			return new ModelAndView("do_delete2",model);
		}else {
			return new ModelAndView("error","message","删除失败");
		}
	}
	@RequestMapping("/add_task")
	public ModelAndView add_task(@RequestParam(defaultValue="") String projectid,
			@RequestParam(defaultValue="") String tasknumber,
			@RequestParam(defaultValue="") String taskname,
			@RequestParam(defaultValue="") String details,
			@RequestParam(defaultValue="") String startedtime,
			@RequestParam(defaultValue="") String period,
			@RequestParam(defaultValue="") String quota,
			@RequestParam(defaultValue="") String cost,
			@RequestParam(defaultValue="") String submitter
			){
		boolean success = projectService.add_task(projectid,taskname,details,tasknumber,startedtime,period,quota,cost,submitter);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("projectid",projectid);
			model.put("returnPage", "task");
			return new ModelAndView("do_add2",model);
		}else {
			return new ModelAndView("error","message","提交失败");
		}
	}
	
	@RequestMapping("/delete_task")
	public ModelAndView delete_task(@RequestParam(defaultValue="") String taskid,
									  @RequestParam(defaultValue="") String projectid){
		boolean success = projectService.delete_task(taskid);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("projectid",projectid);
			model.put("returnPage", "task");
			return new ModelAndView("do_delete2",model);
		}else {
			return new ModelAndView("error","message","删除失败");
		}
	}
}
