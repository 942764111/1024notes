package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池有两个主要作用:
 * 1:控制线程数量
 * 2:重用线程
 * 
 * @author adminitartor
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+":正在执行任务");
					try {
						Thread.sleep(5000);
						System.out.println(t+"运行任务完毕!");
					} catch (InterruptedException e) {
						System.out.println("线程被中断了!");
					}
				}
			};
			threadPool.execute(runn);
		}
		/*
		 * shutdown() 当线程池所有任务执行完毕后停止
		 * shutdownNow() 立即中断所有正在运行的线程并停
		 *               止线程池
		 */
		threadPool.shutdownNow();
		System.out.println("停止线程池");
		
	}
}








