package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map ���ұ�
 * ����ʵ����:HashMap  ɢ�б�,��ϣ��
 * Map�洢Ԫ������"��ֵ��"����ʽ�洢.
 * ����key�������ظ�(equals�Ƚ�).
 * 
 * @author adminitartor
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new HashMap<String,Integer>();		
		/*
		 * V put(K k,V v)
		 * ��������key-value�Դ��뵽Map��
		 * ����ֵΪ���滻��value.
		 * ����Map���������ظ���key,�����������
		 * key�Ѿ�������Map��,�����滻value����
		 * ����ֵ���Ǳ��滻��value.�������key��
		 * Map�в�����,�򷵻�ֵΪNULL
		 */
		map.put("����", 99);		
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 99);
		System.out.println(map);
		
		/*
		 * ��ͬ��key���滻value
		 * Map�ڽ���put�����ķ���ֵʱҪע��,��
		 * value�ǻ������Ͷ�Ӧ�İ�װ������ʱ,
		 * Ӧ���ð�װ���������,�����Զ�����,
		 * ����������ֵΪNULL�Զ������������ָ��
		 */
		Integer value = map.put("��ѧ", 88);
		System.out.println(map);
		System.out.println("old:"+value);
		
		
		/*
		 * V get(K k)
		 * ���ݸ�����key��ȡ��Ӧ��value
		 */
		value = map.get("����");
		System.out.println("����:"+value);
		
		value = map.get("����");
		System.out.println("����:"+value);
		
		/*
		 * V remove(K k)
		 * ���ݸ�����keyɾ�������ֵ��
		 * ����ֵΪ�����ֵ���е�value
		 * ��û��,�򷵻�ֵΪnull
		 */
		Integer old = map.remove("����");
		System.out.println(map);
		System.out.println("old:"+old);
	}
}








