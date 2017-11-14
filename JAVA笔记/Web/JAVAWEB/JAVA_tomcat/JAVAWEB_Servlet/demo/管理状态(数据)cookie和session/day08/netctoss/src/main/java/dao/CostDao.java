package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public void save(Cost c) {
		try {
			Connection conn = 
				DBUtil.getConnection();
			String sql = 
				"insert into cost_lhh values("
				+ "cost_seq_lhh.nextval,"
				+ "?,?,?,?,'1',?,sysdate,null,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			//给数字类型赋值不能为null，
			//实际业务中该字段允许为null，
			//数据库也支持存null。
			//这种情况下将它们当做对象处理即可。
			ps.setObject(2, c.getBaseDuration());
			ps.setObject(3, c.getBaseCost());
			ps.setObject(4, c.getUnitCost());
			ps.setString(5, c.getDescr());
			ps.setString(6, c.getCostType());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"找不到驱动类", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"增加资费失败", e);
		} finally {
			DBUtil.closeConnection();
		}
	}
	
	public static void main(String[] args) {
		CostDao dao = new CostDao();
		Cost c = new Cost();
		c.setName("达内包月");
		//c.setBaseDuration(600);
		c.setBaseCost(800.0);
		//c.setUnitCost(0.6);
		c.setDescr("达内包月很爽");
		c.setCostType("1");
		dao.save(c);
	}
	
}












