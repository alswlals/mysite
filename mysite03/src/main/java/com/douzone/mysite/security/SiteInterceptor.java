package com.douzone.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.douzone.mysite.service.SiteService;
import com.douzone.mysite.vo.SiteVo;

public class SiteInterceptor implements HandlerInterceptor {
	@Autowired
	private SiteService siteService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		String title = request.getParameter("title");
//		String welcome = request.getParameter("welcome");
//		String profile = request.getParameter("profile");
//		String description = request.getParameter("description");
//		
//		SiteVo vo = new SiteVo();
//		vo.setTitle(title);
//		vo.setWelcome(welcome);
//		vo.setProfile(profile);
//		vo.setDescription(description);
//		
//		SiteVo 
//		
//		SiteVo sitevo = (SiteVo) request.getServletContext().getAttribute("site");
//		if (sitevo == null) {
//			sitevo = siteService.getSite();
//			request.getServletContext().setAttribute("siteVo", sitevo);
//		}
//	
//		return true;
//	}
	
			SiteVo site = (SiteVo)request.getServletContext().getAttribute("site");
			if(site == null) {
				site = siteService.getSite();
				request.getServletContext().setAttribute("site", site);
			}
			
			return true;
		}
}