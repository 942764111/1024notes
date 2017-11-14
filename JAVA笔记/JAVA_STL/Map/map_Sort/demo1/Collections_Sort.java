package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序含有自定义元素的集合
 * @author adminitartor
 *
 */
public class Collections_Sort {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(5,6));
		list.add(new Point(4,2));
		list.add(new Point(3,5));
		list.add(new Point(6,9));
		list.add(new Point(8,1));
		
		System.out.println(list);
		/*
		 * Collections.sort方法要求集合元素必须
		 * 实现Comparable接口.
		 * 
		 * 该方法在排序自定义元素时,对我们的程序
		 * 有侵入性
		 * 侵入性:当我们使用一个功能时,该功能要求我们
		 * 为其修改的代码越多,侵入性越强.
		 * 高侵入性不利于程序扩展.应尽量避免.
		 * 
		 */
		Collections.sort(list);
		
		System.out.println(list);
	}
}








