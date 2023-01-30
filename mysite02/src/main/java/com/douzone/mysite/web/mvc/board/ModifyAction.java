package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.utils.MvcUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no = Long.parseLong( request.getParameter("no"));
		
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		
		BoardVo vo = new BoardVo();
		
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContents(contents);
		
		new BoardDao().modify(vo);
		
//		BoardVo boardVo = new BoardDao().findByNo(no);
//		request.setAttribute("boardVo", boardVo);
		MvcUtil.redirect(request.getContextPath()+"/board?a=view&no="+no, request, response);
	}

}
