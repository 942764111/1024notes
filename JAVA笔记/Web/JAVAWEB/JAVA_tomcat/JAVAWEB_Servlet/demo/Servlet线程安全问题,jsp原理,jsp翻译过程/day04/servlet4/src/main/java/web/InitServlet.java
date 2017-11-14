package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 此Servlet不负责处理任何请求。
 * 它专门负责在tomcat启动时初始化数据的。
 * 在项目中往往会有1个甚至多个这样的类。
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		ctx.setAttribute("count", 0);
	}

}






