package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �������Զ���Ԫ�صļ���
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
		 * Collections.sort����Ҫ�󼯺�Ԫ�ر���
		 * ʵ��Comparable�ӿ�.
		 * 
		 * �÷����������Զ���Ԫ��ʱ,�����ǵĳ���
		 * ��������
		 * ������:������ʹ��һ������ʱ,�ù���Ҫ������
		 * Ϊ���޸ĵĴ���Խ��,������Խǿ.
		 * �������Բ����ڳ�����չ.Ӧ��������.
		 * 
		 */
		Collections.sort(list);
		
		System.out.println(list);
	}
}








