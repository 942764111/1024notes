package day11;
/**
 * ʹ��ͬ����
 * ��Ч����Сͬ����Χ�����ڱ�֤��ȫ��ǰ�������
 * ����ִ��Ч��
 * @author adminitartor
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Shop{
	public void buy(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(t+":������ѡ�·�...");
			Thread.sleep(5000);
			/*
			 * ʹ��ͬ������Ը���ȷ�Ŀ�����Ҫͬ��ִ��
			 * �Ĵ���Ƭ��,��Ч��Сͬ����Χ,����߶��߳�
			 * ����ִ��Ч��
			 * ͬ������Ҫ����ָ��"ͬ��������",��:������
			 * ����,ֻҪ��֤��Ҫ�Ŷ�ִ�еĶ���߳̿�����
			 * ��ͬһ�����󼴿�!
			 */
			synchronized(this){
				System.out.println(t+":�������·�...");
				Thread.sleep(5000);
			}
			System.out.println(t+":�����뿪");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}















