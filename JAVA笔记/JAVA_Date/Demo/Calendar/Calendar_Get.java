package day03;

import java.util.Calendar;

/**
 * Calendar�ṩ��һ������:
 * int get(int field)
 * ���Ի�ȡ������ʱ���������Ӧ��ֵ
 * 
 * ʱ�������һ��intֵ,�����ס����ȡֵ,ʹ��Calendar
 * �ṩ�Ĵ�����������.
 * @author adminitartor
 *
 */
public class Calendar_Get {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		
		//��ȡ��?
		int year = calendar.get(Calendar.YEAR);
		/*
		 * �µ�ֵ��0��ʼ,0��ʾ1��.
		 * Ҳ����ʹ�ó�����Ӧ
		 */
		int month = calendar.get(Calendar.MONTH)+1;
		/*
		 * ���Ӧ�ĳ���:
		 * DATE:���е���,�׳�:����
		 * DAY_OF_MONTH:���е���,��DATEһ��
		 * DAY_OF_WEEK:���е���,���ڼ�
		 * DAY_OF_YEAR:���е���
		 */
		int day = calendar.get(Calendar.DATE);
		
		System.out.println(year+"-"+month+"-"+day);
		
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		
		int m = calendar.get(Calendar.MINUTE);
		
		int s = calendar.get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
		
		//�����ǽ���ĵڼ���?
		int doy = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("�����ǽ���ĵ�:"+doy+"��");
		
		//�������ܼ�?
		int dow = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] data = {"��","һ","��","��","��","��","��"};
		System.out.println("��"+data[dow]);
		
		/*
		 * ��ȡָ��ʱ���������������ֵ
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


	






