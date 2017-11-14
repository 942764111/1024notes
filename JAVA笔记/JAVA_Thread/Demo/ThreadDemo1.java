package day10;
/**
 * 线程
 * 用来并发执行多个任务
 * 
 * 线程有两种创建方式
 * 方式一:
 * 继承Thread并重写run方法.
 * @author adminitartor
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程要执行start而不是直接调用run
		 * 方法.
		 * 当start方法调用完毕后,该线程纳入到线程
		 * 调度,等待分配cpu时间,一旦分配后该线程
		 * 的run方法会自动被调用开始执行任务.
		 * 
		 * 线程对线程调度的工作是不可控的
		 * 时间片长短不可控,分配给哪个线程也不可控
		 * 线程调度会尽可能均匀的将时间片次数分配
		 * 给不同的线程,但绝不保证一个线程一次这样
		 * 的切换方式.线程也没有能力主动获取CPU
		 * 的时间片.
		 * 
		 */
		t1.start();
		t2.start();
	}
}
/**
 * 第一种创建线程的方式有两个设计上的不足:
 * 1:由于java是单继承的,这就导致一个类若继承了
 *   线程就不能继承其他类,在实际开发中会出现
 *   继承冲突问题.
 * 2:由于重写了run方法定义了线程要执行的任务,
 *   就导致线程与其执行的任务有一个强耦合关系
 *   不利于线程重用.  
 * @author adminitartor
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<10000;i++){
			System.out.println("你是谁啊?");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<10000;i++){
			System.out.println("我是查水表的!");
		}	
	}
}










