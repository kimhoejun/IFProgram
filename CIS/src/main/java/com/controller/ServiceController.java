package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
	
	@RequestMapping("/RuleCallService")
	public static ModelAndView startService() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("RuleCallService");
		
		return view;
	}

}
