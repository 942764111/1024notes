package day04_1;

import java.util.ArrayList;
import java.util.List;

/**
 * List�ṩ�ķ�����:
 * @author adminitartor
 *
 */
public class List_Add_Remove {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		/*
		 * void add(int index,E e)
		 * ��ָ��λ�ò������Ԫ��.
		 * 
		 * [one,two,2,three,four]
		 */
		list.add(2, "2");
		System.out.println(list);
		
		/*
		 * E remove(int index)
		 * ɾ��������ָ��λ�ô���Ԫ��
		 */
		String old = list.remove(1);
		System.out.println(list);
		System.out.println("old:"+old);
	}
}





