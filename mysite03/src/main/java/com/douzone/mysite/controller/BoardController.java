package com.douzone.mysite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.mysite.service.BoardService;
import com.douzone.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	 
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String index(@RequestParam("page") int page, 
						@RequestParam(value="kwd") String keyword, Model model) {
		Map<String, Object> map = boardService.getContentsList(page, keyword);
		
		model.addAttribute("map", map);
		// model.addAllAttributes(map);
		return "board/index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(BoardVo vo) {
		boardService.addContents(vo);
		return "redirect:/board";
	}
	
	@RequestMapping(value="/delete/{no}", method = RequestMethod.GET)
	public String delete(@RequestParam("no") Long no, @RequestParam("userNo") Long userNo) {
		boardService.deleteContents(no, userNo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/view/{no}", method = RequestMethod.GET)
	public String view(@RequestParam("no") Long no, Model model) {
		model.addAttribute("no",no);
		return "board/view";
	}
	
	@RequestMapping(value="/view/{no}", method = RequestMethod.POST)
	public String view(@RequestParam("no") Long no, @RequestParam("userNo") Long userNo) {
		boardService.getContents(no, userNo);
		return "board/write";
	}
	
}
