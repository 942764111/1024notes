package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDogServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//读取web.xml中的共用参数size
		ServletContext ctx = getServletContext();
		String size = ctx.getInitParameter("size");
		System.out.println(size);
		//流量+1
		Integer count = (Integer)
			ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}

}





