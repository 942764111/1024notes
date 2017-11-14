package day04_1;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * List接口继承自Collection.
 * List是可重复集,并且有序.
 * List提供了一系列支持使用下标操作元素的方法
 * 常用实现类:
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
		 * 获取第二个元素
		 * 
		 * E get(int index)
		 * 获取指定下标处的元素
		 * 
		 */
		String str = list.get(1);
		System.out.println(str);
		
		//传统循环遍历List集合
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * E set(int index,E e)
		 * 将给定元素设置到指定位置处,返回值原位置
		 * 元素.
		 */
		//[one,two,three,four]
		str = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+str);//two
	}
}








