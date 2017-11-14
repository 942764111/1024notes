package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.接收请求中的数据
		String user = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] interests = 
			req.getParameterValues("interest");
		
		//采用第一种方案解决请求乱码问题
		//byte[] bs = user.getBytes("iso8859-1");
		//user = new String(bs, "utf-8");
		
		//2.利用这些数据处理业务
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests != null) {
			for(String interest : interests) {
				System.out.println(interest);
			}
		}
		//3.给浏览器返回响应信息
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<p>Congratulations,注册成功。</p>");
		out.close();
	}

}











