package cn.edu.uibe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomepageController {
	
	
	@RequestMapping("/homepage")
	public ModelAndView homepage(@RequestParam(defaultValue="") String name){
		return new ModelAndView("homepage", "name", name);	
	}


}
