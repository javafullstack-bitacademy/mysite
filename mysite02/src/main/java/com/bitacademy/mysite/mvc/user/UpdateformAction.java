package com.bitacademy.mysite.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitacademy.mysite.repository.UserRepository;
import com.bitacademy.mysite.vo.UserVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;

public class UpdateformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		// 접근제어
		if(authUser == null) {
			WebUtil.redirect(request, response, request.getContextPath());
			return;
		}
		
		UserVo userVo = new UserRepository().findByNo(authUser.getNo());
		request.setAttribute("vo", userVo);
		
		WebUtil.forward(request, response, "/WEB-INF/views/user/updateform.jsp");
	}

}
