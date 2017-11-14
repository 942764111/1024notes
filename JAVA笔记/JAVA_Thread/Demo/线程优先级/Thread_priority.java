package day10;
/**
 * 线程优先级
 * 线程的优先级有10个等级,对应10个整数,分别是1-10
 * 其中1为最低优先级,10为最高优先级,5为默认优先级
 * 有3个常量对应:
 * MIN_PRIORITY,MAX_PRIORITY;NORM_PRIORITY
 * 
 * 理论上线程优先级越高的线程获取CPU时间片的次数
 * 越多.
 * @author adminitartor
 *
 */
public class Thread_priority {
	public static void main(String[] args) {
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread nor = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("nor");
				}
			}
		};		
		min.setPriority(1);
		max.setPriority(10);		
		min.start();
		nor.start();
		max.start();
	}
}








