package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	模拟MainServlet.login()
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//接收参数
		String code = req.getParameter("code");
		//存入cookie
		//每个cookie对象内只能保存一个数据,
		//并且只能存字符串.
		Cookie c1 = new Cookie("user",code);
		//修改cookie的生效路径
		c1.setPath("/jsp4");
		//将cookie存入response
		res.addCookie(c1);
		//再创建一个cookie,并声明生存时间
		Cookie c2 = new Cookie("email","zs@qq.com");
		c2.setMaxAge(600000);
		res.addCookie(c2);
		//再创建一个cookie,并保存中文
		Cookie c3 = new Cookie("city",
			URLEncoder.encode("北京", "utf-8"));
		res.addCookie(c3);
		//响应时服务器会自动将response内的
		//cookie发送给浏览器.
	}

}










