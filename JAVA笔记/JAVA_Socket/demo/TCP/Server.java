package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 * @author adminitartor
 *
 */
public class Server {
	/*
	 * java.net.ServerSocket
	 * 运行在服务端的ServerSocket主要有两个
	 * 工作:
	 * 1:向系统申请服务端口,客户端就是通过该端口
	 *   与服务端程序建立连接的.
	 * 2:监听服务端口,一旦客户端建立连接,就会
	 *   创建一个Socket与该客户端通讯.  
	 */
	private ServerSocket server;
	/*
	 * 该集合用来存储所有客户端的输出流
	 */
	private List<PrintWriter> allOut;
	
	public Server() throws IOException{
		/*
		 * 实例化时需要指定服务端口
		 * 若当前操作系统的其他程序已经使用该端口了
		 * 那么这里会抛出异常
		 */
		server = new ServerSocket(8088);
		
		allOut = new ArrayList<PrintWriter>();
	}
	/**
	 * 将给定的消息转发给所有客户端
	 * @param message
	 */
	public void sendMessage(String message){
		synchronized (allOut) {
			for(PrintWriter pw : allOut){
				pw.println(message);
			}
		}
	}
	
	
	public void start(){
		try {
			/*
			 * Socket accept()
			 * 该方法是一个阻塞方法,作用是监听
			 * 申请的服务端口,等待客户端的连接,
			 * 一旦客户端通过该端口连接,那么
			 * accept方法会返回一个Socket,使用
			 * 该Socket就可以与建立连接的客户端
			 * 进行通讯了
			 */
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				
				//启动线程来完成与该客户端的交互
				ClientHandler handler
					= new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务端启动失败!");
		}
	}
	
	/**
	 * 该线程是用来处于与指定客户端交互的工作
	 * @author adminitartor
	 *
	 */
	private class ClientHandler 
						implements Runnable{
		/*
		 * 当前线程要处理的客户端Socket
		 */
		private Socket socket;
		/*
		 * 客户端地址信息
		 */
		private String host;
		/*
		 * 该客户端的昵称 
		 */
		private String nickName;
		
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			/*
			 * 通过Socket获取远端计算机地址信息
			 * 对于服务端而言,远端计算机就是客户端
			 * 的计算机
			 */
			InetAddress address
				= socket.getInetAddress();
			//获取IP地址的字符串形式
			host = address.getHostAddress();
			
		}
		
		public void run(){
			PrintWriter pw = null;
			try {				
				InputStream in
					= socket.getInputStream();
				InputStreamReader isr
					= new InputStreamReader(in,"UTF-8");
				BufferedReader br
					= new BufferedReader(isr);	
				
				//读取客户端发送过来的第一条消息就是昵称
				nickName = br.readLine();
				
				String message = null;		
				
				OutputStream out 
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(out,"UTF-8");
				pw  = new PrintWriter(osw,true);
				
				//将该客户端的输出流存入共享集合
				synchronized (allOut) {
					allOut.add(pw);
				}
				
				sendMessage("["+nickName+"]上线了!当前在线:"+allOut.size()+"人");
				
				
				
				
				/*
				 * 在读取客户端消息时,由于客户端断开连接,
				 * 不同的系统在这里导致的结果不同.
				 * 当linux的客户端断开连接后:这里br.readLine
				 * 会返回null.
				 * 当windows的客户端断开连接后,这里br.readLine
				 * 会抛出异常.
				 */
				while((message = br.readLine())!=null){
//					System.out.println(host+"说:"+message);
//					pw.println(host+"说:"+message);
					sendMessage(nickName+"说:"+message);

				}		
			} catch (Exception e) {
				
			} finally{
				//在这里处理客户端断开后的操作
				
				//将该客户端的输出流从共享集合中删除
				synchronized (allOut) {
					allOut.remove(pw);
				}
				
				sendMessage("["+nickName+"]下线了!当前在线:"+allOut.size()+"人");
				
				
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}







