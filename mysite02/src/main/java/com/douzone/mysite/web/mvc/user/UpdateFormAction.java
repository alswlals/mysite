package com.douzone.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.dao.UserDao;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.utils.MvcUtil;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Access Control(접근제어) */
		HttpSession session = request.getSession();
		if (session == null) {
			MvcUtil.redirect(request.getContextPath(), request, response);
			return;
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			MvcUtil.redirect(request.getContextPath(), request, response);
			return;
		}

		////////////////////////////

//		UserVo vo = new UserDao().FindByNo(authUser.getNo(), authUser.getName(), authUser.getPassword(), authUser.getGender());

		Long no = authUser.getNo();
		UserVo userVo = new UserDao().FindByNo(no);
		
		request.setAttribute("userVo", userVo);
		MvcUtil.forward("user/updateform", request, response);
	}

}
