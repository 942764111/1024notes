package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 聊天室客户端
 * @author adminitartor
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * 封装了Tcp通讯协议.使用该类完成基于TCP
	 * 通讯的操作
	 */
	private Socket socket;
	/**
	 * 构造方法,用来初始化客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client() throws UnknownHostException, IOException{
		/*
		 * 实例化Socket需要传入两个参数
		 * 1:服务端的IP地址
		 * 2:服务端的端口号
		 * 端口号是用来连接服务端计算机上的服务端
		 * 应用程序. 
		 * 
		 * 实例化Socket的过程就是连接的过程,所以
		 * 若服务端没有响应这里会抛出异常.
		 */
		System.out.println("正在连接服务端...");
		socket = new Socket("localhost",8088);
		System.out.println("已连接服务端!");
	}
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		try {
			Scanner scanner = new Scanner(System.in);
			
			/*
			 * 首先要求用户输入一个昵称
			 * 昵称至少一个字符(不能是空白)
			 */
			String nickName = "";
			while(true){
				System.out.println("请输入昵称:");
				nickName = scanner.nextLine();
				if(nickName.trim().length()>0){
					break;
				}
				System.out.println("请至少输入一个字符");
			}
			
			
			OutputStream out 
				= socket.getOutputStream();
			OutputStreamWriter osw
				= new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			//先单独给服务端发送一个消息,就是昵称
			pw.println(nickName);
			
			
			/*
			 * 启动用来读取服务端消息的线程
			 */
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			String message = null;
			
			while(true){
				message = scanner.nextLine();
				pw.println(message);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端启动失败!");
		}
	}
	/**
	 * 该线程用来接收服务端发送过来的每条消息并
	 * 输出到控制台.
	 * @author adminitartor
	 *
	 */
	private class ServerHandler 
						implements Runnable{
		public void run(){
			try {
				BufferedReader br = new BufferedReader(
					new InputStreamReader(
						socket.getInputStream(),"UTF-8"	
					)	
				);
				/*
				 * 循环读取服务端发送过来的每条消息
				 */
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				
			}
		}
	}
}












