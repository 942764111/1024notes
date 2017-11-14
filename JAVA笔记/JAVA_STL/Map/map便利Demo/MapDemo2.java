package day05;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历Map
 * 遍历Map有三种方式:
 * 1:遍历所有的key
 * 2:遍历每一组键值对Entry
 * 3:遍历所有的value
 * @author adminitartor
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new LinkedHashMap<String,Integer>(100);		
		map.put("语文", 99);		
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		System.out.println(map);
		
		/*
		 * 遍历所有的key
		 * 
		 * Set<K> keySet()
		 * 将当前Map中所有的key存入到一个Set集合
		 * 后返回.
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * 遍历每一组键值对
		 * Set<Entry> entrySet()
		 * 
		 * Entry是Map的内部类,其每一个实例用于表示
		 * Map中的一组键值对
		 */
		Set<Entry<String,Integer>> entrySet 
								= map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * 遍历所有value
		 * Collection values()
		 * 将当前Map中所有value存入一个集合后返回
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
		}
		
	}
}








