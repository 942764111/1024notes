package day03;

import java.util.Calendar;

/**
 * Calendar�ṩ�ķ���:
 * 
 * void set(int field,int value)
 * �Ե�ǰCalendarָ��ʱ������趨������ֵ.�趨��
 * ����ʱ�������������,��Щ����Ÿı�.����,����
 * �˲�ͬ�����ں�,���ڻ������仯��.
 * 
 * @author adminitartor
 *
 */
public class Calendar_Set {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		/*
		 * Calendar��ʾ 2008-08-08 20:08:08
		 */
		calendar.set(Calendar.YEAR, 2008);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.MONTH,Calendar.AUGUST);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH,8);
		
		calendar.set(Calendar.HOUR_OF_DAY,20);
		
		calendar.set(Calendar.MINUTE,8);
		
		calendar.set(Calendar.SECOND, 6);
		
		System.out.println(calendar.getTime());
		
		
		
	}
}










