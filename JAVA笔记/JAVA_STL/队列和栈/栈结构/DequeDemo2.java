package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 当双端队列只调用一端进出队的方法时,就形成
 * 了栈结构
 * 栈:存一组元素,元素遵循先进后出原则
 * 栈一般解决诸如"后退"功能的需求.
 * @author adminitartor
 *
 */
public class DequeDemo2 {
	public static void main(String[] args) {
		Deque<String> stack
			= new LinkedList<String>();
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		
		System.out.println(stack);
		
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack);
		
		
		
		
	}
}







