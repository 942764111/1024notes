package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * ������Ը���һ�����������ڸ�ʽ��String��Date
 * ֮���໥ת��.
 * @author adminitartor
 *
 */
public class SimpleDateFormat_Format {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		/*
		 * 2017-01-23 10:21:22
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy��MM��dd�� HH:mm:ss"	
			);
		/*
		 * String format(Date date)
		 * ��������Date��ʾ��ʱ�䰴�յ�ǰ
		 * SimpleDateFormatָ���ĸ�ʽת��
		 * Ϊ�ַ���
		 */
		String str = sdf.format(date);
		System.out.println(str);
		
	}
}








