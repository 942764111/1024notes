package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳�
 * �̳߳���������Ҫ����:
 * 1:�����߳�����
 * 2:�����߳�
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
					System.out.println(t+":����ִ������");
					try {
						Thread.sleep(5000);
						System.out.println(t+"�����������!");
					} catch (InterruptedException e) {
						System.out.println("�̱߳��ж���!");
					}
				}
			};
			threadPool.execute(runn);
		}
		/*
		 * shutdown() ���̳߳���������ִ����Ϻ�ֹͣ
		 * shutdownNow() �����ж������������е��̲߳�ͣ
		 *               ֹ�̳߳�
		 */
		threadPool.shutdownNow();
		System.out.println("ֹͣ�̳߳�");
		
	}
}








