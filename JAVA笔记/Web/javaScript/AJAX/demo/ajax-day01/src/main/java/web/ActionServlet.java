package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{

	@Override
	public void service(
				HttpServletRequest req, 
				HttpServletResponse res) 
			throws ServletException, 
			IOException {
		System.out.println("service()");
		
		req.setCharacterEncoding("utf-8");
		
		res.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				res.getWriter();
		//分析请求资源路径
		String uri = 
				req.getRequestURI();
		System.out.println("uri:" + uri);
		String action = 
				uri.substring(
				uri.lastIndexOf("/"), 
				uri.lastIndexOf("."));
		System.out.println("action:" + action);
		//依据分析结果，调用不同的分支来处理
		if("/check".equals(action)){
			//检查帐号是否可用
			String adminCode = 
				req.getParameter("adminCode");
			System.out.println("adminCode:"
				+ adminCode);
			if("Tom".equals(adminCode)){
				out.println("帐号已经存在");
			}else{
				out.println("可用");
			}
		}else if("/getScore".equals(action)){
			//获得分数
			Random r = new Random();
			int score = r.nextInt(100);
			System.out.println("score:" + score);
			out.println(score);
		}
	}
	
}





