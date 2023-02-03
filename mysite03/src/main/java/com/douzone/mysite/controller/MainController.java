package com.douzone.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.mysite.vo.UserVo;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping("/msg01")
	public String message01() {
		return "Hello world";
	}
	
	@ResponseBody
	@RequestMapping("/msg02")
	public String message02() {
		return "한글로 쓰면 깨지기 마련인디 값이 안 들어오는 건 아님";
	}
	
	@ResponseBody
	@RequestMapping("/msg03")
	public Object message03() {
		UserVo vo = new UserVo();
		vo.setNo(1L);
		vo.setName("둘리");
		vo.setEmail("dooly@test.com");
		
		return vo;
	}
	
	
}
