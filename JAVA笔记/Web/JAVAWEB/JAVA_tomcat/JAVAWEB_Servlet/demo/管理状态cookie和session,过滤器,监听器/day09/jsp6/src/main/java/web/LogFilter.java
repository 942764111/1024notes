package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	public void destroy() {
		System.out.println("销毁LogFilter");
	}

	public void doFilter(
		ServletRequest arg0, 
		ServletResponse arg1, 
		FilterChain chain)
		throws IOException, ServletException {
		System.out.println("在前面记日志");
		//让请求继续执行
		chain.doFilter(arg0, arg1);
		System.out.println("在后面记日志");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化LogFilter");
	}

}





