package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类,是一个抽象类,规定了操作日期的相关方法.
 * 常用的实现类为:格里高利历 GregorianCalendar,
 * 即:阳历
 * 实例化可以使用Calendar提供的静态方法getInstance()
 * 方法返回一个当前系统所在地区适用的实现类,大部分地区
 * 返回的都是阳历实现类.
 * 
 * @author adminitartor
 *
 */
public class Calendar_GetInstance {
	public static void main(String[] args) {
		/*
		 * 默认创建出来的Calendar实现类实例是表示
		 * 当前系统时间.
		 */
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar);
		
		/*
		 * Calendar->Date
		 * 
		 * Date getTime()
		 * Calendar提供了方法getTime,该方法可以将
		 * 当前Calendar表示的日期以一个Date类型实例
		 * 返回.
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		/*
		 * Date->Calendar
		 * 
		 * void setTime(Date date)
		 * Calendar提供的方法setTime允许传入一个
		 * Date对象,使得当前Calendar表示给定的Date
		 * 所表示的日期.
		 */
		calendar.setTime(date);
		
		
	}
}










