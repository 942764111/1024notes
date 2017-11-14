package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpServlet extends HttpServlet {

	private double salary = 3000.0;

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		synchronized (this) {
			salary += 100.0;
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			res.setContentType(
					"text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<p>"+salary+"</p>");
			out.close();
		}
	}
	
}









