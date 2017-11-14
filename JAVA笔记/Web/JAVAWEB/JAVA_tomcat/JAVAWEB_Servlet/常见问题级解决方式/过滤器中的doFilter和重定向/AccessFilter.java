package cn.tedu.note.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.note.entity.User;

/**
 * Servlet Filter implementation class AccessFilter
 */
public class AccessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AccessFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res =  (HttpServletResponse)response;
		
		//1.获取登录用户信息
		String path = req.getRequestURI();
		System.out.println(path);
		/**
		 * doFilter：服务器向客户端发送完请求后为了避免错误加return
		 */
		if(path.endsWith("log_in.html")||path.contains("/alert/")){
			//设置HTTP协议头，避免浏览器缓存html页面
			res.addHeader("Cache-Control", "no-cache");
			chain.doFilter(request, response);
			return;
		}
		User user = (User) req.getSession().getAttribute("loginUser");
		if(user==null){
			/*
			 * 重定向采用绝对路径重定向！避免错误
			 * */
			String url=req.getContextPath()+"/log_in.html";
			/**
			 * sendRedirect和doFilter俩者不能同时执行只能调用其中一个
			 */
			res.sendRedirect(url);
			return;
		}
		/**
		 * 设置Http协议头 不带缓存网页
		 */
		res.addHeader("Cache-Control","no-cache");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
