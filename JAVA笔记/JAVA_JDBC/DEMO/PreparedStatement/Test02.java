package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 使用DBUtil维护数据库连接
 * 要求用户输入用户名，查询该用户信息，并输出
 * 到控制台，格式:
 * id,username,password,email,nickname,account
 * 
 * 若没有此人，则显示:查无此人
 * 
 * @author adminitartor
 *
 */
public class Test02 {
	public static void main(String[] args) {
		try {
			System.out.println("请输入用户名:");
			Scanner scanner = new Scanner(System.in);
			String username = scanner.nextLine();
			
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT id,username,password,email,nickname,account "
					   + "FROM userinfo "
					   + "WHERE username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("username");
				String pwd = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				int account = rs.getInt("account");
				System.out.println(id+","+name+","+pwd+","+email+","+nickname+","+account); 
			}else{
				System.out.println("查无此人");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
	}
}





