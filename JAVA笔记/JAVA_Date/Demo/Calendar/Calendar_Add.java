package day03;

import java.util.Calendar;

/**
 * void add(int field,int value)
 * 对指定时间分量加上给定的值,若给定的值是负数
 * 则是减去.
 * @author adminitartor
 *
 */
public class Calendar_Add {
	public static void main(String[] args) {
		/*
		 * 查看3年2个月零15天以后那周的周一是哪天?
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







