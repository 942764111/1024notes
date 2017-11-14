package day11;
/**
 * ��̬������ʹ��synchronized��,�÷���һ������
 * ͬ��Ч��.
 * ʵ���������Ķ���Ϊ��ǰ����������������,��:
 * Class��һ��ʵ��.
 * Class���ÿһ��ʵ������������JVM���ص�һ����,
 * ��������JVM�ڲ�.
 * JVM�ڼ���һ����ʱ��ʵ����һ��Class,����,ÿ����
 * ����ֻ��һ��Classʵ����֮��Ӧ,�ڸ�Class�ڲ���¼
 * ����������Ϣ,��:����Щ����,���Ե�.
 * 
 * 
 * @author adminitartor
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(t+":����ִ��dosome����");
			Thread.sleep(5000);
			System.out.println(t+":ִ��dosome�������");
		} catch (Exception e) {
			
		}
	}
}







