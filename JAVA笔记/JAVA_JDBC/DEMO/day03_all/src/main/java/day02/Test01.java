package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 要求用户输入用户名，账户金额。
 * 根据用户输入的用户名，修改该用户
 * 输入的金额。
 * 使用PreparedStatement实现
 * 
 * UPDATE userinfo
 * SET account=? 
 * WHERE username=?
 * 
 * @author adminitartor
 *
 */
public class Test01 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名:");
			String username = scanner.nextLine();
			
			System.out.println("请输入要修改的金额:");
			int account = Integer.parseInt(scanner.nextLine());
			
			Connection conn = DBUtil.getConnection();
			
			String sql = "UPDATE userinfo "
					   + "SET account=? "
					   + "WHERE username=? ";
			
			PreparedStatement ps
				= conn.prepareStatement(sql);
			ps.setInt(1, account);
			ps.setString(2, username);
			int d = ps.executeUpdate();
			if(d>0){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
	}
}
