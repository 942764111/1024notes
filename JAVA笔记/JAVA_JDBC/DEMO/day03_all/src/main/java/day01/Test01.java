package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 创建序列 seq_userinfo_id_xxxx
 * 从1开始，步长为1
 * @author adminitartor
 *
 */
public class Test01 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.227:1521:orcl",
				"openlab","open123"
		    );
			Statement state = conn.createStatement();
			String sql = "CREATE SEQUENCE seq_userinfo_id "+
						 " START WITH 1 "+
			             " INCREMENT BY 1 ";
			System.out.println(sql);
			state.execute(sql);
			System.out.println("执行SQL完毕！");
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
