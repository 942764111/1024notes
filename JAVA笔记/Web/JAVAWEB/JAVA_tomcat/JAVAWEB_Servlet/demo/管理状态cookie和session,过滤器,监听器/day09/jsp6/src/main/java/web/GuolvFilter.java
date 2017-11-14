package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GuolvFilter implements Filter {

	public void destroy() {
		System.out.println("销毁GuolvFilter");
	}

	public void doFilter(
		ServletRequest arg0, 
		ServletResponse arg1, 
		FilterChain chain)
		throws IOException, ServletException {
		System.out.println("在前面过滤敏感词");
		chain.doFilter(arg0, arg1);
		System.out.println("在后面过滤敏感词");
	}

	String words;
	
	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("初始化GuolvFilter");
		words = cfg.getInitParameter("words");
		System.out.println(words);
	}

}





