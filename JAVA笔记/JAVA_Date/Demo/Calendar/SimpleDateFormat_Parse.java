package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat�ṩ����:
 * 
 * Date parse(String str)
 * ���ַ������ո��������ڸ�ʽ����Ϊ�ַ���
 * 
 * @author adminitartor
 *
 */
public class SimpleDateFormat_Parse {
	public static void main(String[] args) throws ParseException {
		String str = "2008-08-08 20:08:08";
		
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"	
			);
		
		Date date = sdf.parse(str);
		
		System.out.println(date);
	}
}








