package com.douzone.mysite.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.service.FileuploadService;
import com.douzone.mysite.service.SiteService;
import com.douzone.mysite.vo.SiteVo;

@Auth(role="ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping("")
	public String main(Model model) {
		SiteVo vo = siteService.getSite();
		model.addAttribute("siteVo", vo);
		return "admin/main";
	}
	
	@Auth(role = "ADMIN")
	@RequestMapping("/main/update")
	public String update(SiteVo vo, @RequestParam("file") MultipartFile file) {
		
		//vo에 업데이트 하는 정보가 있을 텐데 이 vo를 가져다가 
//		servletContext.setAttribute("siteVo", vo);
//		vo.setProfile(fileuploadService.restore(file));
//		siteService.updateSite(vo);
		// 요 안에서 파일 업로드 구현
//		vo.setProfile(fileuploadService.restore(file)); 
		
		
		String profile = fileuploadService.restore(file);
		if(profile != null ) {
			vo.setProfile(profile);
		}
		
		servletContext.setAttribute("siteVo", vo);
		vo.setProfile(profile);
		siteService.updateSite(vo);
		
		return "redirect:/admin";
	}
	
	
	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
}
