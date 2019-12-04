package com.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorldControler {

	@RequestMapping("/world")
	public ModelAndView word() {
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("world");
		
		return view;
//		return "/world";
	}

}
