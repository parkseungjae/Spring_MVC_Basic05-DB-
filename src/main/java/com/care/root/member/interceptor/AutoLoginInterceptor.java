package com.care.root.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.common.MemberSessionName;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter implements MemberSessionName {

	@Autowired
	MemberService ms;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 이름만 알고있다면 해당 쿠키 값을 가져올 수 있다.
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		System.out.println(loginCookie);
		if (loginCookie != null) {
			MemberDTO dto = ms.getUserSessionId(loginCookie.getValue());
			if (dto != null) {
				request.getSession().setAttribute(LOGIN, dto.getId());
			}
		}
		return true;
	}
}
