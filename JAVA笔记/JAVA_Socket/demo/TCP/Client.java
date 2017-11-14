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
 * �����ҿͻ���
 * @author adminitartor
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * ��װ��TcpͨѶЭ��.ʹ�ø�����ɻ���TCP
	 * ͨѶ�Ĳ���
	 */
	private Socket socket;
	/**
	 * ���췽��,������ʼ���ͻ���
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client() throws UnknownHostException, IOException{
		/*
		 * ʵ����Socket��Ҫ������������
		 * 1:����˵�IP��ַ
		 * 2:����˵Ķ˿ں�
		 * �˿ں����������ӷ���˼�����ϵķ����
		 * Ӧ�ó���. 
		 * 
		 * ʵ����Socket�Ĺ��̾������ӵĹ���,����
		 * �������û����Ӧ������׳��쳣.
		 */
		System.out.println("�������ӷ����...");
		socket = new Socket("localhost",8088);
		System.out.println("�����ӷ����!");
	}
	/**
	 * �ͻ��˿�ʼ�����ķ���
	 */
	public void start(){
		try {
			Scanner scanner = new Scanner(System.in);
			
			/*
			 * ����Ҫ���û�����һ���ǳ�
			 * �ǳ�����һ���ַ�(�����ǿհ�)
			 */
			String nickName = "";
			while(true){
				System.out.println("�������ǳ�:");
				nickName = scanner.nextLine();
				if(nickName.trim().length()>0){
					break;
				}
				System.out.println("����������һ���ַ�");
			}
			
			
			OutputStream out 
				= socket.getOutputStream();
			OutputStreamWriter osw
				= new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			//�ȵ���������˷���һ����Ϣ,�����ǳ�
			pw.println(nickName);
			
			
			/*
			 * ����������ȡ�������Ϣ���߳�
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
			System.out.println("�ͻ�������ʧ��!");
		}
	}
	/**
	 * ���߳��������շ���˷��͹�����ÿ����Ϣ��
	 * ���������̨.
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
				 * ѭ����ȡ����˷��͹�����ÿ����Ϣ
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












