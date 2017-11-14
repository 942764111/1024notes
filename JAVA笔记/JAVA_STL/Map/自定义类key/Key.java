package day05;
/**
 如果自定义类做为map中的key应当重写 hashCode和equals

 * 作为Map中key的元素,equals方法与hashcode方法
 * 的重写准则
 * java提供的类不需要考虑,只有自定义类型在重写时
 * 需要注意.
 * 
 * 当我们重写一个类的equals方法时就应当连同重写
 * hashcode方法.并且两个方法应满足:
 * 1:一致性,即:当两个对象equals比较为true,那么
 *   hashcode值应当相等.反之亦然.
 *   因为当两个对象hashcode值相等,但是equals比较
 *   为false,那么在HashMap中会产生链表,影响查询
 *   性能.
 * 2:成对重写,即重写equals就应当重写hashcode  
 * 
 * @author adminitartor
 *
 */
public class Key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}







