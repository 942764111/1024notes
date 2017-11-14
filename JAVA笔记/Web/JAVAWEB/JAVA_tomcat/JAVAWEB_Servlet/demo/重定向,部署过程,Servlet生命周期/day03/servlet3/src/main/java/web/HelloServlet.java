package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取请求路径
		System.out.println(req.getContextPath());
		System.out.println(req.getServletPath());
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
		//若不写print，则服务器也会自动向浏览器
		//发送响应，但内容为空，浏览器看到一片空白
	}

}






