package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindCostServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取session,并从中取值
		HttpSession session = req.getSession();
		String user = (String)
			session.getAttribute("user");
		//输出给浏览器
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(user);
		out.close();
	}

}






