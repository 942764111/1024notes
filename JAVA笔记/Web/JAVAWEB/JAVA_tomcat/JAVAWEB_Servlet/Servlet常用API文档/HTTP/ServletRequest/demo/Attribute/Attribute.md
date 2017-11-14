#JAVA
- package web;

- import java.io.IOException;
- import java.util.List;

- import javax.servlet.ServletException;
- import javax.servlet.http.HttpServlet;
- import javax.servlet.http.HttpServletRequest;
- import javax.servlet.http.HttpServletResponse;

- import dao.EmpDao;
- import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//查询所有的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//将请求转发给JSP
		//将数据存入request
- <div class="bg-blue">例：
		<p>req.setAttribute("emps", list);</p>
		//当前：/jsp2/findEmp</p>
		//目标：/jsp2/emp_list.jsp</p>
		req.getRequestDispatcher(
			"emp_list.jsp").forward(req, res);</div>
	}

}


#JSP
- <div class="bg-blue">例：
			"${Request.emps}" </div>

