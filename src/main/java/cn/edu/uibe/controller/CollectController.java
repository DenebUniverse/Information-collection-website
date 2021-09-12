package cn.edu.uibe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.uibe.domain.Collect;
import cn.edu.uibe.domain.Forbid;
import cn.edu.uibe.domain.Submit;
import cn.edu.uibe.myClass.MyTable;
import cn.edu.uibe.service.CollectService;

@RestController
public class CollectController {
	@Autowired
	CollectService collectService;
	
	@RequestMapping("/collect")
	public ModelAndView collect(){
		List<Collect> collectList=collectService.getAllInfo();
		return new ModelAndView("collect", "collects", collectList);
	}
	
	@RequestMapping("/add_collect")
	public ModelAndView add_collect(@RequestParam(defaultValue="") String collectName,
			@RequestParam(defaultValue="") String details,
			@RequestParam(defaultValue="") String colLen,
			@RequestParam(defaultValue="") String rowLen,
			@RequestParam(defaultValue="") String colList,
			@RequestParam(defaultValue="") String rowList,
			@RequestParam(defaultValue="") String ddl,
			@RequestParam(defaultValue="") String collecter,
			@RequestParam(defaultValue="") String uniqueflag,
			@RequestParam(defaultValue="") String forbidflag
			){
		String message=collectService.check_collect_insert(colLen,rowLen,colList,rowList,ddl);
		boolean success = collectService.add_collect(collectName,details,colLen,rowLen,colList,rowList,ddl,collecter,uniqueflag,forbidflag);
		if(success) {
			return new ModelAndView("do_collect","collectName",collectName);
		}else {
			return new ModelAndView("error","message","提交失败 "+message);
		}
	}
	
	@RequestMapping("/delect_collect")
	public ModelAndView delect_collect(@RequestParam(defaultValue="") String collectId){
		boolean success = collectService.delect_collect(collectId);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("collectid",collectId);
			model.put("returnPage", "collect");
			return new ModelAndView("do_delete",model);
		}else {
			return new ModelAndView("error","message","删除失败");
		}
	}

	@RequestMapping("/submit")
	public ModelAndView submit(@RequestParam(defaultValue="") String collectId){
		List<Submit>submitList =collectService.getSubmitByCollectID(collectId);
		Collect collect=collectService.selectCollectById(collectId);
		MyTable<Integer> submitTable=collectService.SumCollectById(collectId);
		MyTable<String> forbidTable=collectService.SumForbidByCollectId(collectId);
		Map<String,Object> model = new HashMap<>();
		model.put("collect", collect);
		model.put("submits", submitList);
		model.put("submitTable", submitTable);
		model.put("forbidTable", forbidTable);
		return new ModelAndView("submit",model);
	}
	
	@RequestMapping("/add_submit")
	public ModelAndView add_submit(@RequestParam(defaultValue="") String collectid,
			@RequestParam(defaultValue="") String details,
			@RequestParam(defaultValue="") String col,
			@RequestParam(defaultValue="") String row,
			@RequestParam(defaultValue="") String submitter
			){
		boolean success = collectService.add_submit(collectid,details,col,row,submitter);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("collectid",collectid);
			model.put("returnPage", "submit");
			return new ModelAndView("do_add",model);
		}else {
			return new ModelAndView("error","message","提交失败");
		}
	}
	
	@RequestMapping("/delete_submit")
	public ModelAndView delete_submit(@RequestParam(defaultValue="") String submitId,
									  @RequestParam(defaultValue="") String collectId){
		boolean success = collectService.delete_submit(submitId);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("collectid",collectId);
			model.put("returnPage", "submit");
			return new ModelAndView("do_delete",model);
		}else {
			return new ModelAndView("error","message","删除失败");
		}
	}
	
	@RequestMapping("/forbid")
	public ModelAndView forbid(@RequestParam(defaultValue="") String collectId){
		List<Forbid> forbidList =collectService.getForbidByCollectID(collectId);
		Collect collect=collectService.selectCollectById(collectId);
		MyTable<String> mytable=collectService.SumForbidByCollectId(collectId);
		Map<String,Object> model = new HashMap<>();
		model.put("collect", collect);
		model.put("forbids", forbidList);
		model.put("mytable", mytable);
		return new ModelAndView("forbid",model);
	}
	@RequestMapping("/add_forbid")
	public ModelAndView add_forbid(@RequestParam(defaultValue="") String collectid,
			@RequestParam(defaultValue="") String row,
			@RequestParam(defaultValue="") String col,
			@RequestParam(defaultValue="") String details
			){
		boolean success = collectService.add_forbid(collectid,details,col,row);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("collectid",collectid);
			model.put("returnPage", "forbid");
			return new ModelAndView("do_add",model);
		}else {
			return new ModelAndView("error","message","提交失败");
		}
	}
	
	@RequestMapping("/delete_forbid")
	public ModelAndView delete_forbid(@RequestParam(defaultValue="") String forbidId,
									  @RequestParam(defaultValue="") String collectId){
		boolean success = collectService.delete_forbid(forbidId);
		if(success) {
			Map<String,Object> model = new HashMap<>();
			model.put("collectid",collectId);
			model.put("returnPage", "forbid");
			return new ModelAndView("do_delete",model);
		}else {
			return new ModelAndView("error","message","删除失败");
		}
	}

}
