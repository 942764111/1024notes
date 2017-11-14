package day11;
/**
 * SynchronizedҲ�ǻ�����
 * �����ε������˲�ͬ�Ĵ���,����ͬ��������������
 * ͬһ����ʱ��,��ô�;����˻�����.
 * @author adminitartor
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo boo = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				boo.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(t+":����ִ��A����");
			Thread.sleep(5000);
			System.out.println(t+":����A�������");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void methodB(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(t+":����ִ��B����");
			Thread.sleep(5000);
			System.out.println(t+":����B�������");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}






