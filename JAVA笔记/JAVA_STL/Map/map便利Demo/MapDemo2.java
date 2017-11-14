package day05;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ����Map
 * ����Map�����ַ�ʽ:
 * 1:�������е�key
 * 2:����ÿһ���ֵ��Entry
 * 3:�������е�value
 * @author adminitartor
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new LinkedHashMap<String,Integer>(100);		
		map.put("����", 99);		
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 99);
		System.out.println(map);
		
		/*
		 * �������е�key
		 * 
		 * Set<K> keySet()
		 * ����ǰMap�����е�key���뵽һ��Set����
		 * �󷵻�.
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * ����ÿһ���ֵ��
		 * Set<Entry> entrySet()
		 * 
		 * Entry��Map���ڲ���,��ÿһ��ʵ�����ڱ�ʾ
		 * Map�е�һ���ֵ��
		 */
		Set<Entry<String,Integer>> entrySet 
								= map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * ��������value
		 * Collection values()
		 * ����ǰMap������value����һ�����Ϻ󷵻�
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
		}
		
	}
}








