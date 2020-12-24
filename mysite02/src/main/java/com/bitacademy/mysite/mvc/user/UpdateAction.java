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

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");

		// 접근제어
		if(authUser == null) {
			WebUtil.redirect(request, response, request.getContextPath());
			return;
		}
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setNo(authUser.getNo());
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);
		
		boolean result = new UserRepository().update(vo);
		if(result) {
			authUser.setName(name);
		}
		
		WebUtil.redirect(request, response, request.getContextPath()+ "/user?a=updateform" );
	}
}
