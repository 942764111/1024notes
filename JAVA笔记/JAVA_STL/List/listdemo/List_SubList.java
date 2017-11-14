package day04_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 截取子集
 * @author adminitartor
 *
 */
public class List_SubList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		
		/*
		 * List subList(int start,int end)
		 * 截取当前集合中指定范围内的子集
		 * 
		 * 取3-7
		 */
		List<Integer> subList 
			= list.subList(3, 8);
		
		System.out.println(subList);
		
		/*
		 * 将子集中每个元素扩大10倍
		 * [30,40,50,60,70]
		 */
		for(int i=0;i<subList.size();i++){
			subList.set(i, subList.get(i) * 10);
		}
		System.out.println(subList);
		/*
		 * 对子集的操作就是对原集合中对应元素的操作
		 */
		System.out.println(list);
		
		
		/*
		 * 删除2-8
		 */
		list.subList(2, 9).clear();
		System.out.println(list);
	}
}




