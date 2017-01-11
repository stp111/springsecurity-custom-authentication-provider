package com.dcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/hello")
	public String hello(Model model) {
		logger.info("-- hello --");
		model.addAttribute("name", "Hero from Sky...");
		return "hello";
	}
	
}
