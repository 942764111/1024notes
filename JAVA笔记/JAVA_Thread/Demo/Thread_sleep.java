package day10;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �߳��ṩ��һ����̬����:
 * static void sleep(long ms)
 * �÷����������и÷������߳̽�������״ָ̬������
 * ����ʱ���̻߳��Զ��ص�runnable״̬,�ȴ��ٴ�����.
 * 
 * ͨ��ʹ��sleep�����ʱ��Ȳ���.
 * @author adminitartor
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		/*
		 * ���ӱ�,ÿ�������ǰϵͳʱ��
		 * ��:
		 * 	15:20:12
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat("HH:mm:ss");
		while(true){
			System.out.println(
				sdf.format(new Date())	
			);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}







