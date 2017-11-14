package day10;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 该方法会让运行该方法的线程进入阻塞状态指定毫秒
 * 当超时后线程会自动回到runnable状态,等待再次运行.
 * 
 * 通常使用sleep做间隔时间等操作.
 * @author adminitartor
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		/*
		 * 电子表,每秒输出当前系统时间
		 * 如:
		 * 	15:20:12
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat("HH:mm:ss");
		while(true){
			System.out.println(
				sdf.format(new Date())	
			);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}







