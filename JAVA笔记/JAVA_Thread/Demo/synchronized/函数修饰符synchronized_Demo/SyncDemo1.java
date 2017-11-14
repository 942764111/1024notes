package day11;
/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一资源时,由于线程切换时机的
 * 不确定性导致执行顺序发生混乱,出现执行逻辑错误的
 * 情况.
 * @author adminitartor
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					//模拟线程发生切换
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Table{
	private int beans = 20;
	/*
	 * 当一个方法是用synchronized修饰后,该方法
	 * 称为:"同步方法"
	 * 即:多个线程不能"同时"执行该方法.只能有先后
	 *    顺序的同步执行
	 *    
	 * 在方法上使用synchronized那么上锁的对象
	 * 就是当前方法所属对象,即:this   
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了!");
		}
		Thread.yield();
		return beans--;
	}
	
}







