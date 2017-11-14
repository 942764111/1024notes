package UDP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Client extends JFrame implements Runnable,ActionListener {
	int port;
	InetAddress group = null;
	MulticastSocket socket = null;
	JButton ince = new JButton("开始接收");
	JButton stop = new JButton("停止接收");
	
	//显示接收广播的文本域
	JTextArea inceAr = new JTextArea(10,10);
	JTextArea inced = new JTextArea(10,10);
	Thread thread;
	boolean b = false;
	
	public Client() {
		super("广播数据表");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		thread = new Thread(this);
		ince.addActionListener(this);
		stop.addActionListener(this);
		inceAr.setForeground(Color.blue);
		JPanel north = new JPanel();
		north.add(ince);
		north.add(stop);
		add(north,BorderLayout.NORTH);
		
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,2));
		center.add(inceAr);
		center.add(inced);
		add(center,BorderLayout.CENTER);
		
		validate();
		port = 9898;
		try {
			group = InetAddress.getByName("224.255.10.0");
			socket = new MulticastSocket(port);
			//加入广播组
			socket.joinGroup(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100,50,360,380);
		this.setSize(460,200);
		setVisible(true);

	}
	public static void main(String[] args) {
			Client client = new Client();
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ince){
			ince.setBackground(Color.red);
			stop.setBackground(Color.yellow);

			//判断线程是否处于新建状态
			if(!(thread.isAlive())){
				System.out.println("开始接收按钮响应");
				thread = new Thread(this);
				thread.start();
			}
			b = false;
		}
		if(e.getSource()==stop){
			ince.setBackground(Color.yellow);
			stop.setBackground(Color.red);
			System.out.println("停止接收按钮响应");
			b = true;
			thread = new Thread(this);
		}
	}
	@Override
	public void run() {
		while(true){
			byte data[] = new byte[1024];
			DatagramPacket packet = null;
			//待接收的数据包
			packet = new DatagramPacket(data,data.length,group,port);
			try {
				//接收数据包
				socket.receive(packet);
				//获取数据包内容
				String message = new String(packet.getData(),0,packet.getLength());
				
				inceAr.setText("正在接收内容：\n"+ message);
				inced.append(message+"\n");
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			if(b){
				break;
			}
		}
		
	}
}
