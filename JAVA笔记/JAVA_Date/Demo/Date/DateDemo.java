package day03;

import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个时间
 * 内部维护一个long值,该值为UTC时间.表示的是
 * 从1970年元旦那一刻到当前Date表示的时间之间
 * 所经过的毫秒.
 * 由于Date存在设计缺陷(千年虫,时区),所以大部分方法
 * 被声明为过时方法,不再建议使用了.
 * @author adminitartor
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		/*
		 * 默认创建就表示当前系统时间
		 */
		Date date = new Date();
		/*
		 * Date重写了toString方法
		 */
		System.out.println(date);
		/*
		 * long getTime()
		 * 获取当前Date对象内部维护的毫秒值
		 */
		long time = date.getTime();
		System.out.println(time);
		
		time += 1000*60*60*24;
		/*
		 * void setTime(long time)
		 * 设置一个long值,使当前Date表示该日期
		 */
		date.setTime(time);
		System.out.println(date);
	}
}









