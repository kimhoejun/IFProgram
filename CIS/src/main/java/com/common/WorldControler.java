package com.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorldControler {

	@RequestMapping("/world")
	public String word() {
		
		return "/world";
	}

}
