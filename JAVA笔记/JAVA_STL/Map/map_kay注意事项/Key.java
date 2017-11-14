package day05;
/**
 * ��ΪMap��key��Ԫ��,equals������hashcode����
 * ����д׼��
 * java�ṩ���಻��Ҫ����,ֻ���Զ�����������дʱ
 * ��Ҫע��.
 * 
 * ��������дһ�����equals����ʱ��Ӧ����ͬ��д
 * hashcode����.������������Ӧ����:
 * 1:һ����,��:����������equals�Ƚ�Ϊtrue,��ô
 *   hashcodeֵӦ�����.��֮��Ȼ.
 *   ��Ϊ����������hashcodeֵ���,����equals�Ƚ�
 *   Ϊfalse,��ô��HashMap�л��������,Ӱ���ѯ
 *   ����.
 * 2:�ɶ���д,����дequals��Ӧ����дhashcode  
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







