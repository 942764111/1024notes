package day03;

import java.util.Calendar;

/**
 * Calendar提供的方法:
 * 
 * void set(int field,int value)
 * 对当前Calendar指定时间分量设定给定的值.设定后
 * 其他时间分量尽量不变,有些会跟着改变.比如,设置
 * 了不同的日期后,星期会有所变化等.
 * 
 * @author adminitartor
 *
 */
public class Calendar_Set {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		/*
		 * Calendar表示 2008-08-08 20:08:08
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










