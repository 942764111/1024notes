package day04_1;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供的方法二:
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
		 * 在指定位置插入给定元素.
		 * 
		 * [one,two,2,three,four]
		 */
		list.add(2, "2");
		System.out.println(list);
		
		/*
		 * E remove(int index)
		 * 删除并返回指定位置处的元素
		 */
		String old = list.remove(1);
		System.out.println(list);
		System.out.println("old:"+old);
	}
}





