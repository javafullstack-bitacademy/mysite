package com.bitacademy.mysite.mvc.board;

import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("write".equals(actionName)) {		
		
		} else {
			action = new ListAction();
		}
		
		return action;
	}

}
