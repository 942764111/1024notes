package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day02.DBUtil;

/**
 * 批量执行SQL语句时，会影响SQL语句执行效率的原因
 * 有很多，其中常见的：
 * 1:执行计划的产生
 * 2:事务的次数
 * 3:客户端向服务端发送SQL语句的次数
 * @author adminitartor
 *
 */
public class JDBCDemo2 {
	public static void main(String[] args) {
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO userinfo "
					   + "(id,username,password) "
					   + "VALUES "
					   + "(?,?,?)";
			/*
			 *  使用PS可以重用同一个执行计划		
			 */
			PreparedStatement ps = conn.prepareStatement(sql);
			long start = System.currentTimeMillis();
			/*
			 * 事务越多数据库写磁盘次数越多，速度
			 * 越慢
			 */
			DBUtil.TransBegin();
			for(int i=1;i<100000;i++){
				ps.setInt(1, i);
				ps.setString(2, "test"+i);
				ps.setString(3, "123456");
				/*
				 * 添加批操作，可以减少批量更新时的
				 * 网络传输次数
				 */
				ps.addBatch();
				if(i%10000==0){
					ps.executeBatch();
				}
			}
			DBUtil.commit();
			long end = System.currentTimeMillis();
			System.out.println("插入完毕,耗时:"+(end-start)+"ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				DBUtil.TransEnd();
				DBUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}






