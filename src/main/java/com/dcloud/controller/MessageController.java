package com.dcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dcloud.model.Message;

@Controller
public class MessageController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/message/{id}")
	public String getMessage(@PathVariable("id") int id, Model model) {
		logger.info("get message {}",id);
		
		Message message = new Message();
		message.setId(id);
		message.setContent("content in message");
		message.setSender("sender king");
		
		model.addAttribute("message", message);
		return "message";
	}
}
