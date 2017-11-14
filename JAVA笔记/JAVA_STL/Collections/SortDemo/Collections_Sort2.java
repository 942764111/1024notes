package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections�ṩ��һ�����ص�sort����
 * 
 * static void sort(List list,Compartor c)
 * �÷�������ݸ����ıȽ����ж���ıȽϹ���Լ���
 * Ԫ�رȽϴ�С������.
 * �÷��������������:
 * 1:�����ṩ�˶���Ƚ���,����Ҫ��Ԫ�ر���ʵ��
 *   Comparable�ӿ�,����������
 * 2:��ʹ��Ԫ������ȽϹ���,���Կ��Ա�������Ԫ��
 *   �ȽϹ�������ʵ�������������������.  
 * @author adminitartor
 *
 */
public class Collections_Sort2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		
		list.add("��������ʦ");
		list.add("����ʦ");
		list.add("С����ʦ");
		
		System.out.println(list);
//		Collections.sort(list);
		
		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}			
		});
		
		
		System.out.println(list);
	}
}











