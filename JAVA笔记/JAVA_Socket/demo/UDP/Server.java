package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.MulticastChannel;

import javax.print.attribute.standard.Severity;

/*
 * 一、UDP简介
 * 用户数据报协议(UDP) 是网络信息传输的一种形式, 
 * 基于UDP的通讯和基于TCP的通讯不同,
 * 基于UDP的信息传递更快,但不提供可靠的保证。
 * 
 * 使用UDP传递数据时,
 * 1、用户无法知道数据能否正确地达到主机,
 * 2、也不能确定达到目的的顺序是否和发送的顺序相同
 * 
 * 虽然UDP是一种不可靠的协议,但如果需要较快地传输信息,并能容忍小的错误,可以考虑使用UDP。
 * 
 * 
 * 二、基于UDP通信的基本模式如下：
 * 1、将数据打包(称为数据包),然后将数据包发往目的地。
 * 2、接受别人发来的数据包,然后查看数据包。
 * 
 * 三、下面是总结的UDP程序的步騶
 * 1、发送数据包
 * 1.1：
 * 	DatagramSocket()创建一个数据包套接字
 * 1.2：
 * 	DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
 *  创建要发送的数据包
 * 1.3：
 *  使用DatagramSocket类的sead()方法发送数据包.
 * 
 * 2、接收数据包
 * 2.1：
 * 		DatagramSocket(int port) 
        创建数据报套接字并将其绑定到本地主机上的指定端口。
 * 
 * 2.2:
 *  	使用DatagramPacket(byte[] buf, int length) 
 *  	创建字节数组来接收数据包
 *  
 * 2.3:
 * 		使用DatagramSocket类的 receive()方法接收UDP包
 * 
 * 	注意： DatagramSocket类的 receive()方法接收数据时,如果还没有可以接收的数据,
 * 	在正常情况下receive()方法将阻塞,一直等到网络上有数据传来,
 *  receive()方法接收该数据并返回.
 *  
 *  如果网络上没有数据发送过来,receive()方法没也有阻塞,肯定是程序问题,
 *  大多数是使用了一个被其他程序占用的端口号。
 * 	
 *  四、DatagramPacket类 和 DatagramSocket类
 *  构造函数：
 *  	1、DatagramPacket(byte[] buf, int length)
 *  	创建了 DatagramPacket对象
	InetAddress指定了数据包的 内存空间 和 大小
 *  
 *  	2、DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 *  	在发送数据时,必须指定接收放的Socket地址和端口,因此使用此构造函数可以创建 发送数据 的DatagramPacket对象
 *  
 *  五、TCP 于 UDP
 *  TCP：传输控制协议
 *  TCP：用户数据报协议
 *  
 *  TCP：协议是一种以固态连线为基础的协议,它提供俩台计算机间可靠的数据传送,
 *  	 TCP可以保证从一端数据送至链接的另一端时,数据能够确实送达。
 *  UDP：是无链接通信协议,不保证可靠数据传输,但能够向若干个目标发送数据,
 *  	 接收发自若干个源的数据,UDP是以独立发送数据包的方式进行.
 *  	 UDP协议适用于一些对数据准确性要求不高的场合,如网络聊天室,在线影院等
 *  	 这是由于TCP协议在认证上存在额外耗费,可能使传输速度减慢,
 *  	 而UDP协议可能会适合这些对传输速度和时效要求非常高的网站,
 *  	 即使有一小部分数据包遗失或传送顺序有所不同,也不会严重危害该项通信。
 *  
 *   注意：
 *		  一些防火墙和路由器会设置成不允许UDP数据包传输,因此,若遇到UDP链接方面的问题,
 *		  因先确定所在网络是否允许UDP协议。	
 *
 *   注意：
 *   	  使用命令 netstat-an 来查看该程序所使用的端口。	
 * */
public class Server extends Thread{
	/**
	 * 广播数据
	 */
	String weather = "节目预报：八点有大型晚会,请收听";
	/**
	 * 端口
	 */
	int port = 9898;
	 InetAddress iaAddress = null;
	 /**
	  * 声明多点广播套接字
	  */
	 MulticastSocket socket = null;
	 public Server() {
		 try {
			iaAddress = InetAddress.getByName("224.255.10.0");
			socket = new MulticastSocket(port);
			/**
			 * 指定发送范围是本地网络
			 */
			socket.setTimeToLive(1);
			socket.joinGroup(iaAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 @Override
	public void run() {
		 while(true){
			 DatagramPacket packet = null;
			 byte data[] = weather.getBytes();
			 //将数据打包
			 packet = new DatagramPacket(data, data.length,iaAddress,port);
			 System.out.println(new String(data));
			 
			 try {
				 //发送数据
				socket.send(packet);
				sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}
