package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 要求用户输入用户名，密码，邮箱，昵称
 * 然后将该用户插入到userinfo表中，其中ID用序列
 * 生成，账户金额5000
 * @author adminitartor
 *
 */
public class Test02 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名:");
			String username = scanner.nextLine();
			
			System.out.println("请输入密码:");
			String password = scanner.nextLine();
			
			System.out.println("请输入邮箱:");
			String email = scanner.nextLine();
			
			System.out.println("请输入昵称:");
			String nickName = scanner.nextLine();
			
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
			String sql = "INSERT INTO userinfo "
					   + "(id,username,password,email,nickname,account) "
					   + "VALUES "
					   + "(seq_userinfo_id.NEXTVAL,'"+username+"','"+password+"','"+email+"','"+nickName+"',5000)";
			
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
