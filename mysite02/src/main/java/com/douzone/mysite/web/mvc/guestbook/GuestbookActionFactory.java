package com.douzone.mysite.web.mvc.guestbook;

import com.douzone.web2.mvc.Action;
import com.douzone.web2.mvc.ActionFactory;

public class GuestbookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("deleteform".equals(actionName)) {
			action = new deleteFormAction();
		} else if ("delete".equals(actionName)) {
			action = new deleteAction();
		} else if ("add".equals(actionName)) {
			action = new addAction();
		} else {
			action = new listAction();
		}

		return action;
	}

}
