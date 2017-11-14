package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * ����,������һ��Ԫ��,���Ǵ�ȡ������ѭ�Ƚ��ȳ�ԭ��
 * ����Ҳ�Ǽ��ϵ�һ��������.����Collection�����
 * ������Ҳ�߱�.
 * @author adminitartor
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue 
			= new LinkedList<String>();
		/*
		 * boolean offer(E e)
		 * ��Ӳ���,���β׷��Ԫ��
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue);
		
		/*
		 * E poll()
		 * ���Ӳ���,��ȡ����Ԫ��,������Ԫ�شӶ���
		 * ��ɾ��.
		 */
		String str = queue.poll();
		System.out.println(str);//one
		System.out.println(queue);
		
		/*
		 * E peek()
		 * ���ö���Ԫ��,��ȡ���Ԫ�ػ��ڶ�����
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * ����QueueҲ�Ǽ���,���Կ���ʹ�õ�����
		 * ��������Ԫ��
		 */
		for(String s : queue){
			System.out.println(s);
		}
		System.out.println(queue);
		
		System.out.println("��ʼ����..");
		while(queue.size()>0){
			str = queue.poll();
			System.out.println(str);
		}
		System.out.println("�������!");
		System.out.println(queue);
	}
}





