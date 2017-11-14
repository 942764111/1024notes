package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	模拟MainServlet.toIndex()
 */
public class IndexServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取cookie
		Cookie[] cookies = req.getCookies();
		//将cookie输出给浏览器
		if(cookies != null) {
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			for(Cookie c : cookies) {
				String value = URLDecoder
					.decode(c.getValue(), "utf-8");
				out.println(
					c.getName()+":"+value);
			}
			out.close();
		}
	}
	
}







