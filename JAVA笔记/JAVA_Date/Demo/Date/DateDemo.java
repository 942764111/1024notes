package day03;

import java.util.Date;

/**
 * java.util.Date
 * Date��ÿһ��ʵ�����ڱ�ʾһ��ʱ��
 * �ڲ�ά��һ��longֵ,��ֵΪUTCʱ��.��ʾ����
 * ��1970��Ԫ����һ�̵���ǰDate��ʾ��ʱ��֮��
 * �������ĺ���.
 * ����Date�������ȱ��(ǧ���,ʱ��),���Դ󲿷ַ���
 * ������Ϊ��ʱ����,���ٽ���ʹ����.
 * @author adminitartor
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		/*
		 * Ĭ�ϴ����ͱ�ʾ��ǰϵͳʱ��
		 */
		Date date = new Date();
		/*
		 * Date��д��toString����
		 */
		System.out.println(date);
		/*
		 * long getTime()
		 * ��ȡ��ǰDate�����ڲ�ά���ĺ���ֵ
		 */
		long time = date.getTime();
		System.out.println(time);
		
		time += 1000*60*60*24;
		/*
		 * void setTime(long time)
		 * ����һ��longֵ,ʹ��ǰDate��ʾ������
		 */
		date.setTime(time);
		System.out.println(date);
	}
}









