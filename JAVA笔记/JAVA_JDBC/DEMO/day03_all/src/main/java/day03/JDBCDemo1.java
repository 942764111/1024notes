package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import day02.DBUtil;

/**
 * JDBC对事务的操作
 * JDBC对事务进行了简单的封装，事务本身依赖的还是
 * 数据库的事务机制。
 * JDBC默认是自动提交事务的，即:
 * 每当执行一次DML操作后都会提交事务。
 * 
 * 可以通过Connection提供的方法自行管理事务。
 * 
 * 
 * @author adminitartor
 *
 */
public class JDBCDemo1 {
	public static void main(String[] args) {
		/*
		 * 实现转账操作
		 * 要求用户输入转入账户的用户名，以及转出
		 * 账户的用户名，以及金额。
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入转出账号用户名:");
		String out = scanner.nextLine();
		
		System.out.println("请输入转入账号用户名:");
		String in = scanner.nextLine();
		
		System.out.println("请输入转账金额:");
		int m = Integer.parseInt(scanner.nextLine());
	
		try {
			Connection conn = DBUtil.getConnection();
//			//关闭自动提交事务
//			conn.setAutoCommit(false);
			DBUtil.TransBegin();
			
			String outSql = "UPDATE userinfo "
					      + "SET account=account-? "
					      + "WHERE username=? ";
			
			String inSql = "UPDATE userinfo "
					     + "SET account=account+? "
					     + "WHERE username=? ";
			PreparedStatement outPs = conn.prepareStatement(outSql);
			PreparedStatement inPs = conn.prepareStatement(inSql);
			
			outPs.setInt(1, m);
			outPs.setString(2, out);
			int d = outPs.executeUpdate();
			if(d==0){
				System.out.println("转出账号有误!");
				DBUtil.rollback();
				return;
			}
			
			inPs.setInt(1, m);
			inPs.setString(2, in);
			d = inPs.executeUpdate();
			if(d==0){
				System.out.println("转入账号有误！");
				DBUtil.rollback();
				return;
			}
			System.out.println("转账完毕!");
			DBUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				DBUtil.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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






