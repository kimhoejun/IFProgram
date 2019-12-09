package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
	
	@RequestMapping("/index")
	public static ModelAndView startPage() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		
		return view;
	}

}
