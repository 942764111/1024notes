package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day03.UserInfoDAO;

/**
 * 用户管理系统
 * @author adminitartor
 *
 */
public class UserInfoService {
	public static final int REG_USER = 1;
	public static final int LOGIN_USER = REG_USER+1;
	public static final int MODIFY_USER = LOGIN_USER+1;
	public static final int FIND_ALL_USER = MODIFY_USER+1;
	//登录用户的信息
	private UserInfo userinfo = null;
	
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	
	public void start(){
		/*
		 * 程序启动后，输出欢迎语:欢迎使用用户管理系统
		 * 要求用户输入操作编号:
		 * 1:注册
		 * 2:登入
		 * 3:修改个人信息
		 * 4:查看所有用户信息
		 * 5:转账
		 * 6:登出
		 */
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("欢迎使用用户管理系统");
			System.out.println("1:注册");
			System.out.println("2:登入");
			System.out.println("3:修改个人信息");
			System.out.println("4:查看所有用户信息");
			System.out.println("5:转账");
			System.out.println("6:登出");
			System.out.println("请输入操作序号:");
			int index = Integer.parseInt(scanner.nextLine());		
			switch(index){
				case REG_USER:
					reg();
					break;
					
				case LOGIN_USER:
					login();
					break;
			}
		}
	}
	/**
	 * 注册方法
	 */
	public void reg(){
		System.out.println("欢迎注册");
		Connection conn = null;
		try{
			Scanner scanner = new Scanner(System.in);
			String username = null;
			while(true){
				System.out.println("请输入用户名:");		
				username = scanner.nextLine();
				if(userInfoDAO.findByUsername(username)!=null){
					System.out.println("该用户名已存在!");
					continue;
				}
				break;
			}
			System.out.println("请输入密码:");
			String password = scanner.nextLine();
			
			System.out.println("请输入邮箱:");
			String email = scanner.nextLine();
			
			System.out.println("请输入昵称:");
			String nickName = scanner.nextLine();
			
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(username);
			userInfo.setPassword(password);
			userInfo.setEmail(email);
			userInfo.setNickname(nickName);
			userInfo.setAccount(5000);
			
			userInfoDAO.save(userInfo);
			
			if(userInfo.getId()>0){
				System.out.println("注册成功！您的ID是:"+userInfo.getId());
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
		
	private void login(){
		System.out.println("欢迎登录");
		Connection conn = null;
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名:");
			String username = scanner.nextLine();
			
			System.out.println("请输入密码:");
			String password = scanner.nextLine();
	
			UserInfo userinfo 
				= userInfoDAO.findByUsername(username);
			if(userinfo!=null&&userinfo.getPassword().equals(password)){
				this.userinfo = userinfo;
				System.out.println("欢迎您！"+userinfo.getNickname());
			}else{
				System.out.println("用户名或密码不正确!");
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
	
	public static void main(String[] args) {
		UserInfoService service = new UserInfoService();
		service.start();
			
	}
}








