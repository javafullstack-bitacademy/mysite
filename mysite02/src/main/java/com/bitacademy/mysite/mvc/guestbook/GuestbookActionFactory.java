package com.bitacademy.mysite.mvc.guestbook;

import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.mvc.ActionFactory;

public class GuestbookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("insert".equals(actionName)) {
			action = new InsertAction();
		} else if("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else {
			action = new ListAction();
		}
		
		return action;

	}

}
