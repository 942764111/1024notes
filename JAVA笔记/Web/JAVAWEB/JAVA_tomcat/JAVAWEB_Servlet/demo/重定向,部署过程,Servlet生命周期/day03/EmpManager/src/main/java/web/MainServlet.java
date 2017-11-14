package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/**
 * 路径规范：
 *	查询员工: /findEmp.do
 *	增加员工: /addEmp.do
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取请求路径
		String path = req.getServletPath();
		//根据规范处理路径
		if("/findEmp.do".equals(path)) {
			findEmp(req,res);
		} else if("/addEmp.do".equals(path)) {
			addEmp(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
	}
	
	protected void findEmp(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//查询所有的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//给浏览器发送响应
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//当前:/EmpManager/findEmp.do
		//目标:/EmpManager/add_emp.html
		out.println("<a href='add_emp.html'>增加</a>");
		out.println("<table border='1' cellspacing='0' width='40%'>");
		out.println("	<tr>");
		out.println("		<td>编号</td>");
		out.println("		<td>姓名</td>");
		out.println("		<td>职位</td>");
		out.println("		<td>工资</td>");
		out.println("	</tr>");
		if(list != null) {
			for(Emp e : list) {
				out.println("<tr>");
				out.println("	<td>"+e.getEmpno()+"</td>");
				out.println("	<td>"+e.getEname()+"</td>");
				out.println("	<td>"+e.getJob()+"</td>");
				out.println("	<td>"+e.getSal()+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.close();
	}	
	
	protected void addEmp(
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
//			res.setContentType(
//				"text/html;charset=utf-8");
//			PrintWriter out = res.getWriter();
//			out.println("<p>保存成功</p>");
//			out.close();
		//重定向到查询功能:
		//即建议浏览器自己去访问查询功能。
		//当前:/EmpManager/addEmp.do
		//目标:/EmpManager/findEmp.do
		res.sendRedirect("findEmp.do");
	}	

}












