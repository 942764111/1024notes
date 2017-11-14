package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import entity.Cost;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) 
		throws ServletException, IOException {
		//获取并判断访问路径
		String path = req.getServletPath();
		if("/findCost.do".equals(path)) {
			findCost(req,res);
		} else {
			throw new RuntimeException("查无此页");
		}
	}
	
	//查询资费
	protected void findCost(
		HttpServletRequest req, 
		HttpServletResponse res) 
		throws ServletException, IOException {
		//查询所有资费
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//转发至jsp
		req.setAttribute("costs", list);
		//当前:/netctoss/findCost.do
		//目标:/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher
			("WEB-INF/cost/find.jsp").forward(req, res);
	}

}

















