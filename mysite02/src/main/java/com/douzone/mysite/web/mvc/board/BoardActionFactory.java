package com.douzone.mysite.web.mvc.board;

import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else if("modify".equals(actionName)) {
			action = new ModifyAction();
		}  else if("view".equals(actionName)) {
			action = new ViewAction();
		} else if("reply".equals(actionName)){
			action = new ReplyAction();
		} else if("replyadd".equals(actionName)){
			action = new ReplyAddAction();
		} else if ("kwd".equals(actionName)) {
			action = new SearchAction();
		}  else {
			action = new ListAction();
		}
		
		return action;
	}

}
