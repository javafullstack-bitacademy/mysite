package com.bitacademy.mysite.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.repository.GuestbookRepository;
import com.bitacademy.mysite.vo.GuestbookVo;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.util.WebUtil;


public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter( "name" );
		String password = request.getParameter( "pass" );
		String content = request.getParameter( "content" );
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName( name );
		vo.setPassword( password );
		vo.setMessage( content );
		
		new GuestbookRepository().insert( vo );

		WebUtil.redirect( request, response, request.getContextPath()+"/guestbook" );
	}
}
