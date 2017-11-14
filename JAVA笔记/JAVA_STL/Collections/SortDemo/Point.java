package day05;
/**
 * 该类作为集合元素测试集合对自定义元素的排序
 * @author adminitartor
 *
 */
public class Point implements Comparable<Point>{
	 private int x;
	 private int y;
	 
	 public Point(){
		 
	 }

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	/**
	 * 实现了Comparable接口后,要求重写compareTo
	 * 方法,该方法的作用是定义当前对象与参数对象
	 * 之间比较大小的规则.
	 * 返回值关注取值范围,当:
	 * 返回值>0:当前对象(this)大于参数对象o
	 * 返回值<0:this<o
	 * 返回值=0:this==o
	 */
	public int compareTo(Point o) {
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}

}






