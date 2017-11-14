package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 指定DML语句
 * @author adminitartor
 *
 */
public class JDBCDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.227:1521:orcl",
				"openlab","open123"
		    );
			Statement state = conn.createStatement();
			/*
			 * INSERT INTO userinfo_xxxx
			 * (id,username,password,email,nickname,account)
			 * VALUES
			 * (seq_userinfo_id_xxxx.NEXTVAL,'jack','123456','jack@qq.com','jack',5000)
			 */
			String sql = "INSERT INTO userinfo_xxxx "
					   + "(id,username,password,email,nickname,account) "
					   + "VALUES "
					   + "(seq_userinfo_id_xxxx.NEXTVAL,'jack','123456','jack@qq.com','jack',5000)";
			
			int d = state.executeUpdate(sql);
			if(d>0){
				System.out.println("插入完毕!");
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



