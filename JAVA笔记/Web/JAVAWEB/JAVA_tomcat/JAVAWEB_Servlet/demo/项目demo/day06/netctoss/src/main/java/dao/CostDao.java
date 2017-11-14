package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cost;
import util.DBUtil;

public class CostDao implements Serializable {

	public List<Cost> findAll() {
		try {
			Connection conn = 
				DBUtil.getConnection();
			String sql = 
				"select * from cost_lhh "
				+ "order by cost_id";
			Statement smt = 
				conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = new Cost();
				c.setCostId(rs.getInt("cost_id"));
				c.setName(rs.getString("name"));
				c.setBaseDuration(rs.getInt("base_duration"));
				c.setBaseCost(rs.getDouble("base_cost"));
				c.setUnitCost(rs.getDouble("unit_cost"));
				c.setStatus(rs.getString("status"));
				c.setDescr(rs.getString("descr"));
				c.setCreatime(rs.getTimestamp("creatime"));
				c.setStartime(rs.getTimestamp("startime"));
				c.setCostType(rs.getString("cost_type"));
				list.add(c);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询资费失败",e);
		} finally {
			DBUtil.closeConnection();
		}
	}
	
	public static void main(String[] args) {
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		if(list != null) {
			for(Cost c : list) {
				System.out.println(
					c.getCostId() + "," +
					c.getName());
			}
		}
	}
	
}












