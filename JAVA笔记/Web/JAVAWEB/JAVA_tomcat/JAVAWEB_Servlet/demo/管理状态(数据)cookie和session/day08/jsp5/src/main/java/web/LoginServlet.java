package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//接收参数
		String code = req.getParameter("code");
		//存入session
		//session可以保存任意类型的数据,
		//大小不受限制.
		HttpSession session = req.getSession();
		session.setAttribute("user", code);
		//响应时服务器自动做出如下处理:
		//Cookie c = new Cookie(
		//	"JSESSIONID", session.getId());
		//c.setPath(req.getContextPath());
		//res.addCookie(c);
	}

}





