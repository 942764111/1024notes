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
 * �����ҷ����
 * @author adminitartor
 *
 */
public class Server {
	/*
	 * java.net.ServerSocket
	 * �����ڷ���˵�ServerSocket��Ҫ������
	 * ����:
	 * 1:��ϵͳ�������˿�,�ͻ��˾���ͨ���ö˿�
	 *   �����˳��������ӵ�.
	 * 2:��������˿�,һ���ͻ��˽�������,�ͻ�
	 *   ����һ��Socket��ÿͻ���ͨѶ.  
	 */
	private ServerSocket server;
	/*
	 * �ü��������洢���пͻ��˵������
	 */
	private List<PrintWriter> allOut;
	
	public Server() throws IOException{
		/*
		 * ʵ����ʱ��Ҫָ������˿�
		 * ����ǰ����ϵͳ�����������Ѿ�ʹ�øö˿���
		 * ��ô������׳��쳣
		 */
		server = new ServerSocket(8088);
		
		allOut = new ArrayList<PrintWriter>();
	}
	/**
	 * ����������Ϣת�������пͻ���
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
			 * �÷�����һ����������,�����Ǽ���
			 * ����ķ���˿�,�ȴ��ͻ��˵�����,
			 * һ���ͻ���ͨ���ö˿�����,��ô
			 * accept�����᷵��һ��Socket,ʹ��
			 * ��Socket�Ϳ����뽨�����ӵĿͻ���
			 * ����ͨѶ��
			 */
			while(true){
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();
				System.out.println("һ���ͻ���������!");
				
				//�����߳��������ÿͻ��˵Ľ���
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
			System.out.println("���������ʧ��!");
		}
	}
	
	/**
	 * ���߳�������������ָ���ͻ��˽����Ĺ���
	 * @author adminitartor
	 *
	 */
	private class ClientHandler 
						implements Runnable{
		/*
		 * ��ǰ�߳�Ҫ����Ŀͻ���Socket
		 */
		private Socket socket;
		/*
		 * �ͻ��˵�ַ��Ϣ
		 */
		private String host;
		/*
		 * �ÿͻ��˵��ǳ� 
		 */
		private String nickName;
		
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			/*
			 * ͨ��Socket��ȡԶ�˼������ַ��Ϣ
			 * ���ڷ���˶���,Զ�˼�������ǿͻ���
			 * �ļ����
			 */
			InetAddress address
				= socket.getInetAddress();
			//��ȡIP��ַ���ַ�����ʽ
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
				
				//��ȡ�ͻ��˷��͹����ĵ�һ����Ϣ�����ǳ�
				nickName = br.readLine();
				
				String message = null;		
				
				OutputStream out 
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(out,"UTF-8");
				pw  = new PrintWriter(osw,true);
				
				//���ÿͻ��˵���������빲����
				synchronized (allOut) {
					allOut.add(pw);
				}
				
				sendMessage("["+nickName+"]������!��ǰ����:"+allOut.size()+"��");
				
				
				
				
				/*
				 * �ڶ�ȡ�ͻ�����Ϣʱ,���ڿͻ��˶Ͽ�����,
				 * ��ͬ��ϵͳ�����ﵼ�µĽ����ͬ.
				 * ��linux�Ŀͻ��˶Ͽ����Ӻ�:����br.readLine
				 * �᷵��null.
				 * ��windows�Ŀͻ��˶Ͽ����Ӻ�,����br.readLine
				 * ���׳��쳣.
				 */
				while((message = br.readLine())!=null){
//					System.out.println(host+"˵:"+message);
//					pw.println(host+"˵:"+message);
					sendMessage(nickName+"˵:"+message);

				}		
			} catch (Exception e) {
				
			} finally{
				//�����ﴦ��ͻ��˶Ͽ���Ĳ���
				
				//���ÿͻ��˵�������ӹ�������ɾ��
				synchronized (allOut) {
					allOut.remove(pw);
				}
				
				sendMessage("["+nickName+"]������!��ǰ����:"+allOut.size()+"��");
				
				
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}







