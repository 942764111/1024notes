package day10;
/**
 * �ڶ��ִ����̵߳ķ�ʽ
 * 
 * ���������߳�����:ʵ��Runnable�ӿ�
 * @author adminitartor
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class MyRunnable1 implements Runnable{
	public void run() {
		for(int i=0;i<10000;i++){
			System.out.println("����˭��?");
		}		
	}
}
class MyRunnable2 implements Runnable{
	public void run() {
		for(int i=0;i<10000;i++){
			System.out.println("���ǲ�ˮ���!");
		}		
	}
}






