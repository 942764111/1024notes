package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��˫�˶���ֻ����һ�˽����ӵķ���ʱ,���γ�
 * ��ջ�ṹ
 * ջ:��һ��Ԫ��,Ԫ����ѭ�Ƚ����ԭ��
 * ջһ��������"����"���ܵ�����.
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







