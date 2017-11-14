package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections提供了一个重载的sort方法
 * 
 * static void sort(List list,Compartor c)
 * 该方法会根据给定的比较器中定义的比较规则对集合
 * 元素比较大小后排序.
 * 该方法解决两个问题:
 * 1:由于提供了额外比较器,不再要求元素必须实现
 *   Comparable接口,较少侵入性
 * 2:不使用元素自身比较规则,所以可以避免由于元素
 *   比较规则不满足实际排序需求带来的问题.  
 * @author adminitartor
 *
 */
public class Collections_Sort2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		
		list.add("刘苍松老师");
		list.add("范老师");
		list.add("小泽老师");
		
		System.out.println(list);
//		Collections.sort(list);
		
		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}			
		});
		
		
		System.out.println(list);
	}
}











