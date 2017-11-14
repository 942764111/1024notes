package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

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
		//1.使用request接收请求数据
		//1.1请求行
		System.out.println(
			"协议类型:"+req.getProtocol());
		System.out.println(
			"访问路径:"+req.getServletPath());
		System.out.println(
			"请求方式:"+req.getMethod());
		//1.2消息头(key-value)
		//Enumeration是比Iterator更早的迭代器
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = req.getHeader(key);
			System.out.println(
				key + ":" + value);
		}
		//1.3实体内容
		//本案例没传具体内容，所以实体内容为空
		//2.使用response发送响应数据
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














