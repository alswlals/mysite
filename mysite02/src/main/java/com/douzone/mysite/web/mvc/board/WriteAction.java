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

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderNo = 0;
		int depth = 0;
//		UserVo uservo = new UserVo();
//		request.getSession(true).setAttribute("uservo", UserVo);
		
		HttpSession session = request.getSession(true);
		UserVo uservo = (UserVo) session.getAttribute("authUser");
		
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		Long userno = uservo.getNo();
		
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setHit(0);
		vo.setGroupNo(new BoardDao().findMax()+1);
		vo.setOrderNo(orderNo);
		vo.setDepth(depth);
		vo.setUserNo(userno);
		
		new BoardDao().insert(vo);
		
		MvcUtil.redirect(request.getContextPath()+"/board", request, response);
		
	}

}
