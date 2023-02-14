package com.douzone.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.douzone.mysite.vo.UserVo;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1. handler 종류 확인
		if(!(handler instanceof HandlerMethod)) {
			// DefaultServletHandler가 처리하는 경우(정적 자원, /assets/**)
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. handler Method의 @Auth 가져오기
		Auth auth=handlerMethod.getMethodAnnotation(Auth.class);
		
		//4. Handler Method에 @Auth가 없으면 Type(Class)에 붙어있는지 확인한다.
		//method에 서 들고오는데 method에 없는 경우 찾ㅈ아서 넣어야 한다. 
		if(auth == null) {
			auth = handlerMethod.getBeanType().getAnnotation(Auth.class);
		}
		//강사님 답
//		if(auth == null) {
//			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
//		}
		// 5. Type이나 Method에 @Auth가 없는 경우
		if(auth == null) {
			return true;
		}

		//6. @Auth가 붙어있기 때문에 인증 (Authenfication) 여부 확인 작업
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		//7. 권한(Authorization) 체크를 위해 @Auth의 role 가져오기("ADMIN", "USER")
		String role = auth.role();
		String authUserRole = authUser.getRole();
		
		/**
		 * 8. @Auth의 role이 "USER"인 경우, authUser의 role은 상관없다.
		 * 
		 * if ("USER".equals(role)){
		 * 		return true;
		 * } 
		 * 
		 * 9. @Auth의 role이 "ADMIN"인 경우, authUser의 role은 반드시 "ADMIN"이어야 한다.
		 * 
		 * if(!"ADMIN".equals(authUser.getRole())){
		 * 		response.sendRedirect(request.getContextPath());
		 * 		return false;
		 * }
		 */
		
		if("ADMIN".equals(role)) {
			if(authUserRole.equals(role)) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}
		
		//6. 인증 확인
		// @Auth의 role: "ADMIN"
		// @authUSer의 role: "ADMIN"
		return true;
	}

}
