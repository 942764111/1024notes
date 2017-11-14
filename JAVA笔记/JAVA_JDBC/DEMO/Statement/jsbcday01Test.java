package day01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class jsbcday01Test {
	/**
	 * 注册
	 */
	final static int ZHUCE = 1;
	/**
	 * 登录
	 */
	final static int DENGLU = ZHUCE+1;
	final String[] strkeys= {"username","password","emmail"};
	public jsbcday01Test() {
		// TODO Auto-generated constructor stub
	}
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
	void Start(){
		Scanner scanner = new Scanner(System.in);
		int index = Integer.parseInt(scanner.nextLine());
		switch(index){
			case ZHUCE:

				break;
			case DENGLU:
				
				break;
		}
	}
	void zhuce(){
		Map<String,String> map = new HashMap<String,String>();
		for (String string : strkeys) {
			map.put(string, string);
		}
		boolean on_off = false;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("输入username");
			map.put("username", scanner.nextLine());
			System.out.println("输入password");
			map.put("password", scanner.nextLine());
			System.out.println("输入emmail");
			map.put("emmail", scanner.nextLine());
			
		} while (!on_off);

	}
	void denglu(){
		
	}

	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 正则表达试
	 * @author soft01
	 *
	 */
	private static class ZZ_Marage{ 
		/**
		 * 判断数字
		 * @return
		 */
		static boolean a(String str){
			return str.matches("\\d{5,8}+");
		}
		/**
		 * 判断邮箱
		 * @param str
		 * @return
		 */
		static boolean b(String str){
			return str.matches("\\d{5,8}+");
		}
		/**
		 * 
		 * @param str
		 * @return
		 */
		static boolean c(String str){
			return str.matches("\\d{5,8}+");
		}
	}
}
