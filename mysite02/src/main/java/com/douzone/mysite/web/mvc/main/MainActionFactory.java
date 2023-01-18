package com.douzone.mysite.web.mvc.main;

import com.douzone.mysite.web.mvc.main.MainAction;
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
//		if("join") {
//			return new JoinAction();  // 실제 구현은 action에 하기 
//		}
		return new MainAction();
	}

}
