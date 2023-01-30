package com.douzone.mysite.controller;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "/WEB-INF/views/main/index.jsp";
	}
}
