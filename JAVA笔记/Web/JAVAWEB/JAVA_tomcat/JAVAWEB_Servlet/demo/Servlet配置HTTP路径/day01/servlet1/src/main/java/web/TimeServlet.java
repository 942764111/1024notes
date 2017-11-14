package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) 
		throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		//告诉浏览器给它发送的是什么东西
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		//此处偷懒输出一个简化后的网页
		out.println("<p>"+now+"</p>");
		out.close();
	}
	
}














