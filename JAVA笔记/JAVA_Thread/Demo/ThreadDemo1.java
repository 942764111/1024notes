package day10;
/**
 * �߳�
 * ��������ִ�ж������
 * 
 * �߳������ִ�����ʽ
 * ��ʽһ:
 * �̳�Thread����дrun����.
 * @author adminitartor
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * �����߳�Ҫִ��start������ֱ�ӵ���run
		 * ����.
		 * ��start����������Ϻ�,���߳����뵽�߳�
		 * ����,�ȴ�����cpuʱ��,һ���������߳�
		 * ��run�������Զ������ÿ�ʼִ������.
		 * 
		 * �̶߳��̵߳��ȵĹ����ǲ��ɿص�
		 * ʱ��Ƭ���̲��ɿ�,������ĸ��߳�Ҳ���ɿ�
		 * �̵߳��Ȼᾡ���ܾ��ȵĽ�ʱ��Ƭ��������
		 * ����ͬ���߳�,��������֤һ���߳�һ������
		 * ���л���ʽ.�߳�Ҳû������������ȡCPU
		 * ��ʱ��Ƭ.
		 * 
		 */
		t1.start();
		t2.start();
	}
}
/**
 * ��һ�ִ����̵߳ķ�ʽ����������ϵĲ���:
 * 1:����java�ǵ��̳е�,��͵���һ�������̳���
 *   �߳̾Ͳ��ܼ̳�������,��ʵ�ʿ����л����
 *   �̳г�ͻ����.
 * 2:������д��run�����������߳�Ҫִ�е�����,
 *   �͵����߳�����ִ�е�������һ��ǿ��Ϲ�ϵ
 *   �������߳�����.  
 * @author adminitartor
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<10000;i++){
			System.out.println("����˭��?");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<10000;i++){
			System.out.println("���ǲ�ˮ���!");
		}	
	}
}










