package day03;

import java.util.Calendar;

/**
 * Calendar提供了一个方法:
 * int get(int field)
 * 可以获取给定的时间分量所对应的值
 * 
 * 时间分量是一个int值,无需记住具体取值,使用Calendar
 * 提供的大量常量即可.
 * @author adminitartor
 *
 */
public class Calendar_Get {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		
		//获取年?
		int year = calendar.get(Calendar.YEAR);
		/*
		 * 月的值从0开始,0表示1月.
		 * 也可以使用常量对应
		 */
		int month = calendar.get(Calendar.MONTH)+1;
		/*
		 * 天对应的常量:
		 * DATE:月中的天,俗称:几号
		 * DAY_OF_MONTH:月中的天,与DATE一致
		 * DAY_OF_WEEK:周中的天,星期几
		 * DAY_OF_YEAR:年中的天
		 */
		int day = calendar.get(Calendar.DATE);
		
		System.out.println(year+"-"+month+"-"+day);
		
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		
		int m = calendar.get(Calendar.MINUTE);
		
		int s = calendar.get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
		
		//今天是今年的第几天?
		int doy = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("今天是今年的第:"+doy+"天");
		
		//今天是周几?
		int dow = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] data = {"日","一","二","三","四","五","六"};
		System.out.println("周"+data[dow]);
		
		/*
		 * 获取指定时间分量所允许的最大值
		 */
		int days = calendar.getActualMaximum(
			Calendar.DAY_OF_MONTH
		);
		System.out.println(days);
		
		days = calendar.getActualMaximum(
			Calendar.DAY_OF_YEAR
		);
		System.out.println(days);
		
	}
}


	






