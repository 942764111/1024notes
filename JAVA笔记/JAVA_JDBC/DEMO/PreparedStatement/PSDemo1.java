package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement
 * 执行预编译SQL语句。
 * 使用PS可以避免SQL注入攻击。
 * @author adminitartor
 *
 */
public class PSDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1 不同数据库，驱动名不同
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.227:1521:orcl",
				"openlab","open123"
		    );
			
			/*
			 * SELECT id,username,password,email,nickname,account
			 * FROM userinfo
			 * WHERE username=? AND password=?
			 */
			
			String sql = "SELECT id,username,password,email,nickname,account "
					   + "FROM userinfo "
					   + "WHERE username=? AND password=?";
			
			PreparedStatement ps 
				= conn.prepareStatement(sql);
			
			ps.setString(1,"sdasd");
			ps.setString(2, "asda' OR '1'='1");
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("登录成功!");
			}else{
				System.out.println("登录失败!");
			}
			
			
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







