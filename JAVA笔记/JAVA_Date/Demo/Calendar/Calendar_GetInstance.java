package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * ������,��һ��������,�涨�˲������ڵ���ط���.
 * ���õ�ʵ����Ϊ:��������� GregorianCalendar,
 * ��:����
 * ʵ��������ʹ��Calendar�ṩ�ľ�̬����getInstance()
 * ��������һ����ǰϵͳ���ڵ������õ�ʵ����,�󲿷ֵ���
 * ���صĶ�������ʵ����.
 * 
 * @author adminitartor
 *
 */
public class Calendar_GetInstance {
	public static void main(String[] args) {
		/*
		 * Ĭ�ϴ���������Calendarʵ����ʵ���Ǳ�ʾ
		 * ��ǰϵͳʱ��.
		 */
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar);
		
		/*
		 * Calendar->Date
		 * 
		 * Date getTime()
		 * Calendar�ṩ�˷���getTime,�÷������Խ�
		 * ��ǰCalendar��ʾ��������һ��Date����ʵ��
		 * ����.
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		/*
		 * Date->Calendar
		 * 
		 * void setTime(Date date)
		 * Calendar�ṩ�ķ���setTime������һ��
		 * Date����,ʹ�õ�ǰCalendar��ʾ������Date
		 * ����ʾ������.
		 */
		calendar.setTime(date);
		
		
	}
}










