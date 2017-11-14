package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列,用来存一组元素,但是存取必须遵循先进先出原则
 * 队列也是集合的一个子类型.所以Collection的相关
 * 方法它也具备.
 * @author adminitartor
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue 
			= new LinkedList<String>();
		/*
		 * boolean offer(E e)
		 * 入队操作,向队尾追加元素
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue);
		
		/*
		 * E poll()
		 * 出队操作,获取队首元素,并将该元素从队列
		 * 中删除.
		 */
		String str = queue.poll();
		System.out.println(str);//one
		System.out.println(queue);
		
		/*
		 * E peek()
		 * 引用队首元素,获取后该元素还在队列中
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * 由于Queue也是集合,所以可以使用迭代器
		 * 遍历集合元素
		 */
		for(String s : queue){
			System.out.println(s);
		}
		System.out.println(queue);
		
		System.out.println("开始遍历..");
		while(queue.size()>0){
			str = queue.poll();
			System.out.println(str);
		}
		System.out.println("遍历完毕!");
		System.out.println(queue);
	}
}





