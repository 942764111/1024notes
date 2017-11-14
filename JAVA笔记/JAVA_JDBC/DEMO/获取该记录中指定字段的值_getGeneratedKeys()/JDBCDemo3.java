package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day02.DBUtil;

/**
 * 自动返回主键
 * @author adminitartor
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		/*
		 * 向部门表插入一条记录的同时为该部门分配
		 * 一个员工插入到emp表中
		 * 问题:部门表的部门号是主键，值由序列生成
		 * 那么再向员工表中插入数据时，对应的部门号
		 * 字段的值如何获取到？
		 */
		try {
			Connection conn = DBUtil.getConnection();
			
			String sql = "INSERT INTO dept_wh "
					   + "(deptno,dname,loc) "
					   + "VALUES "
					   + "(seq_dept_id.NEXTVAL,?,?)";
			/*
			 * 创建PS时，第二个参数是一个数组，作用是
			 * 指定当插入数据后，自动返回该条记录中指定
			 * 字段的值。
			 */
			PreparedStatement ps
				= conn.prepareStatement(sql, new String[]{"deptno"});
			
			ps.setString(1, "IT");
			ps.setString(2, "BEIJING");
			//执行插入操作
			ps.executeUpdate();
			//插入完毕后，获取该记录中指定字段的值
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int deptno = rs.getInt(1);
			
			ps.close();
			
			sql = "INSERT INTO emp_wh "
				+ "(empno,ename,job,sal,deptno) "
				+ "VALUES "
				+ "(seq_emp_id.NEXTVAL,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "FCQ");
			ps.setString(2, "CLERK");
			ps.setInt(3, 5000);
			ps.setInt(4, deptno);
			ps.executeUpdate();
			
			System.out.println("插入完毕!");
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
		
		
		
	}
}





