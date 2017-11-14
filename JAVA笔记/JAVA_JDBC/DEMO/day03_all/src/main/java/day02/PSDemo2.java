package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Statement适合执行静态SQL语句
 * 
 * PreparedStatement适合执行含有动态信息的SQL语句
 * 优点：
 * 1:不需要将动态信息拼接到SQL中，所以定义SQL语句时
 *   复杂度低。也不会因为拼接了SQL关键字等信息导致
 *   SQL拼接后的语义改变，避免SQL注入攻击。
 * 2:在批量执行相同SQL语句，但是数据不同时，PS的
 *   执行效率高于Statement。
 *   因为使用Statement执行一条SQL语句到数据库时，
 *   数据库首先会解析该条SQL语句并为其创建一个执行
 *   计划(开销很大)。相同的SQL语句会重用执行计划，
 *   但是只要内容有改变就一定创建新的执行计划。
 *   PS在执行语义相同，但是内容不同的SQL语句时，
 *   只会使用同一个执行计划，所以开销小。  
 * @author adminitartor
 *
 */
public class PSDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1 不同数据库，驱动名不同
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.227:1521:orcl",
				"openlab","open123"
		    );
			
			String sql = "INSERT INTO userinfo "
					   + "(id,username,password,email,nickname,account) "
					   + "VALUES "
					   + "(seq_userinfo_id.NEXTVAL,?,?,?,?,?)";
			
			PreparedStatement ps
				= conn.prepareStatement(sql);
			/*
			 * 批量执行语义相同的SQL语句时，PS会重用同一个
			 * 直接计划。
			 */
			for(int i=0;i<100;i++){
				ps.setString(1, "test"+i);
				ps.setString(2, "123456");
				ps.setString(3, "test"+i+"@qq.com");
				ps.setString(4, "测试用户"+i);
				ps.setInt(5, 5000);
				ps.executeUpdate();
				
			}
			System.out.println("插入完毕!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}







