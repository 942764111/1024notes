package web;

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

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(
		ServletRequest request, 
		ServletResponse response, 
		FilterChain chain)
		throws IOException, ServletException {
		//将参数强转为子类型
		HttpServletRequest req = 
			(HttpServletRequest) request;
		HttpServletResponse res = 
			(HttpServletResponse) response;
		//有3个请求不需要判断,将他们排除掉
		String[] paths = new String[]{
			"/toLogin.do","/login.do","/createImg.do"
		};
		String p = req.getServletPath();
		for(String path : paths) {
			if(p.equals(path)) {
				//若当前路径是三者之一
				//则请求继续,不必执行后续判断
				chain.doFilter(req, res);
				return;
			}
		}
		//从session中尝试获取账号 
		HttpSession session = req.getSession();
		String user = (String)
			session.getAttribute("user");
		//判断用户是否登录
		if(user == null) {
			//未登录,重定向到登录页面
			res.sendRedirect(
				req.getContextPath() + "/toLogin.do");
		} else {
			//已登录,请求继续执行
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
