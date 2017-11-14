package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//接收表单数据
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String job = req.getParameter("job");
		String salary = req.getParameter("salary");
		//增加一个员工
		Emp e = new Emp();
		e.setEname(name);
		e.setJob(job);
		if(salary != null 
			&& !salary.equals("")) {
			e.setSal(new Double(salary));
		}
		new EmpDao().save(e);
		//返回增加结果
//		res.setContentType(
//			"text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<p>保存成功</p>");
//		out.close();
		//重定向到查询功能:
		//即建议浏览器自己去访问查询功能。
		//当前:/EmpManager/addEmp
		//目标:/EmpManager/findEmp
		res.sendRedirect("findEmp");
	}

}











