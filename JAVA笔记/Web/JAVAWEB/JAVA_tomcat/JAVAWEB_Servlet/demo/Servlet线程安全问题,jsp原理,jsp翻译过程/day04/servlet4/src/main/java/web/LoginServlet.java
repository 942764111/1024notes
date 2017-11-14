package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	//tomcat创建并初始化Servlet的逻辑是：
	//LoginServlet servlet = new LoginServlet();
	//ServletConfig cfg = new ServletConfig();
	//servlet.init(cfg);
	//注意，该方法无论是否重写，tomcat都会调用它。
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
	}

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取web.xml中的参数maxOnline
		ServletConfig cfg = getServletConfig();
		String maxOnline = 
			cfg.getInitParameter("maxOnline");
		System.out.println(maxOnline);
	}

}






