- package web;

- import java.io.IOException;

- import javax.servlet.ServletConfig;
- import javax.servlet.ServletException;
- import javax.servlet.http.HttpServlet;
- import javax.servlet.http.HttpServletRequest;
- import javax.servlet.http.HttpServletResponse;

public class AbcServlet extends HttpServlet {

	public AbcServlet() {
		System.out.println("实例化AbcServlet");
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		super.init(arg0);
		System.out.println("初始化AbcServlet");
	}

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		System.out.println("调用AbcServlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁AbcServlet");
	}	
}

- <div class="bg-blue">tomcat启动时初始化会先调用HttpServlet的子类的无参构造