package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ˫�˶���
 * java.util.Deque
 * ���˶����Խ����ӵĶ���
 * 
 * @author adminitartor
 *
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque
			= new LinkedList<String>();
		
		deque.offer("one");
		deque.offerLast("two");
		deque.offerFirst("three");
		deque.offerLast("four");
		
		System.out.println(deque);
		
		String str = deque.poll();
		System.out.println(str);
		System.out.println(deque);
		
		str = deque.pollLast();
		System.out.println(str);
		System.out.println(deque);
		
		str = deque.pollFirst();
		System.out.println(str);
		System.out.println(deque);
		
	}
}






