package day10;
/**
 * ��ȡ�߳���Ϣ����ط���
 * @author adminitartor
 *
 */
public class Thread_info {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		
		long id = main.getId();
		System.out.println("id:"+id);
		
		String name = main.getName();
		System.out.println("name:"+name);
		//��ȡ�߳����ȼ�
		int priority = main.getPriority();
		System.out.println("���ȼ�:"+priority);
		//��ȡ�߳��Ƿ��ڻ״̬
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		//�鿴��ʾ�Ƿ�Ϊ�ػ��߳�
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemmon:"+isDaemon);
		//�鿴�߳��Ƿ��Ǳ��жϵ�
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
	}
}




