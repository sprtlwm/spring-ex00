package org.zerock.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zerock.domain.project1.MemberVO;

/**
 * Servlet Filter implementation class ChecklogInFilter
 */
public class CheckLogInFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CheckLogInFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// session attribute loggedInMember 가 있으면 계속 진행
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("loggedInMember");

		if (vo == null) {
			// 없으면 /member/login 으로 redirect
			String location = req.getContextPath() + "/member/login";

			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(location);

		} else {
			// 있으면(로그인된 상태이면)
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
