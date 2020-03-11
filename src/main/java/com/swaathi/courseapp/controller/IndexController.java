package com.swaathi.courseapp.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
	public String index() {
		Logger.info("this is a info message");
		Logger.warn("this is a warn message");
		Logger.debug("this is a debug message");
		Logger.error("this is a error message");
		return "CourseEnrollment.jsp";
	}

}
//