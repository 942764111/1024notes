package day11;
/**
 * ���̲߳�����ȫ����
 * ������̲߳�������ͬһ��Դʱ,�����߳��л�ʱ����
 * ��ȷ���Ե���ִ��˳��������,����ִ���߼������
 * ���.
 * @author adminitartor
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					//ģ���̷߳����л�
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Table{
	private int beans = 20;
	/*
	 * ��һ����������synchronized���κ�,�÷���
	 * ��Ϊ:"ͬ������"
	 * ��:����̲߳���"ͬʱ"ִ�и÷���.ֻ�����Ⱥ�
	 *    ˳���ͬ��ִ��
	 *    
	 * �ڷ�����ʹ��synchronized��ô�����Ķ���
	 * ���ǵ�ǰ������������,��:this   
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("û�ж�����!");
		}
		Thread.yield();
		return beans--;
	}
	
}







