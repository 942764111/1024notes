package day04_1;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * List�ӿڼ̳���Collection.
 * List�ǿ��ظ���,��������.
 * List�ṩ��һϵ��֧��ʹ���±����Ԫ�صķ���
 * ����ʵ����:
 * java.util.ArrayList
 * java.util.LinkedList
 * @author adminitartor
 *
 */
public class List_Get_Set {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println(list);
		
		/*
		 * ��ȡ�ڶ���Ԫ��
		 * 
		 * E get(int index)
		 * ��ȡָ���±괦��Ԫ��
		 * 
		 */
		String str = list.get(1);
		System.out.println(str);
		
		//��ͳѭ������List����
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * E set(int index,E e)
		 * ������Ԫ�����õ�ָ��λ�ô�,����ֵԭλ��
		 * Ԫ��.
		 */
		//[one,two,three,four]
		str = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+str);//two
	}
}








