package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列
 * java.util.Deque
 * 两端都可以进出队的队列
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






