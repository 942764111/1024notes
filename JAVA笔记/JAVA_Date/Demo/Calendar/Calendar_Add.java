package day03;

import java.util.Calendar;

/**
 * void add(int field,int value)
 * ��ָ��ʱ��������ϸ�����ֵ,��������ֵ�Ǹ���
 * ���Ǽ�ȥ.
 * @author adminitartor
 *
 */
public class Calendar_Add {
	public static void main(String[] args) {
		/*
		 * �鿴3��2������15���Ժ����ܵ���һ������?
		 */
		Calendar calendar 
			= Calendar.getInstance();
		
		calendar.add(Calendar.YEAR, 3);
		
		calendar.add(Calendar.MONTH,2);
		
		calendar.add(Calendar.DAY_OF_YEAR, 15);
		
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		System.out.println(calendar.getTime());
		
	}
}







