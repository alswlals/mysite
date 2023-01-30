package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.utils.MvcUtil;

public class ReplyAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession(true);	 
		// "USER"로 바인딩된 객체를 돌려준다. ("USER"로 바인딩된 객체가 없다면 null)
		UserVo uservo = (UserVo) httpSession.getAttribute("authUser");

		if(uservo == null) {
			MvcUtil.redirect(request.getContextPath(), request, response);
			return;
		}
		
		Long no = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String contents = request.getParameter("content");

		
		BoardVo vo = new BoardDao().findByNo(no);

//		BoardVo newvo = new BoardVo();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setHit(0);
		vo.setGroupNo(vo.getGroupNo());
		vo.setOrderNo(vo.getOrderNo() + 1);
		vo.setDepth(vo.getDepth() + 1);
		vo.setUserNo(uservo.getNo());

		new BoardDao().update(vo);
		new BoardDao().insert(vo);
		MvcUtil.redirect(request.getContextPath() + "/board", request, response);
	}
}
