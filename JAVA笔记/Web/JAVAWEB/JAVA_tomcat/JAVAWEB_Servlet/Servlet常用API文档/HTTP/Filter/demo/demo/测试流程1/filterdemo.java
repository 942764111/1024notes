package filterdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class filterdemo implements Filter {
	private FilterConfig config;
	public filterdemo() {
		System.out.println("CommentFilter1's filterdemo...");
	}

	public void destroy() {
		System.out.println("CommentFilter1's destroy...");

	}
	 /*
	      	容器会调用doFilter方法来处理请求(相当于servlet的service方法)。
	     	容器会将request对象(arg0)和response对象(arg1)作为参数传给doFilter方法。
	     	如果调用了FilterChain(arg2)的doFilter(request,response)方法，
			则容器会调用后续的过滤器或者servlet，否则请求处理完毕。
      */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
	     HttpServletRequest request = (HttpServletRequest)arg0;
         HttpServletResponse response =(HttpServletResponse)arg1;
         
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
         
         PrintWriter out = response.getWriter();
         
         String content = request.getParameter("content");
         String illegalStr = config.getInitParameter("illegalStr");
         
         if(content.indexOf(illegalStr) != -1){
             //有敏感字
        	 System.out.println("没有敏感词");
         }else{
             //没有敏感字
        	 System.out.println("有敏感词");
             // 执行FilterChain的doFilter会调用后续的过滤器或者servlet。
             arg2.doFilter(arg0, arg1);
         }
         System.out.println("Filter1's doFilter end.");

	}
	
	  /*
      	FilterConfig对象可以用来访问过滤器的初始化参数。
      	init方法只会执行一次。
     */
	public void init(FilterConfig arg0) throws ServletException {
        System.out.println("CommentFilter1's init...");
        config = arg0;
	}

}
