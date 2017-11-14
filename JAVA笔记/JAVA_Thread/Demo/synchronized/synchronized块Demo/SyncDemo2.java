package day11;
/**
 * 使用同步块
 * 有效的缩小同步范围可以在保证安全的前提下提高
 * 并发执行效率
 * @author adminitartor
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Shop{
	public void buy(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(t+":正在挑选衣服...");
			Thread.sleep(5000);
			/*
			 * 使用同步块可以更精确的控制需要同步执行
			 * 的代码片段,有效缩小同步范围,来提高多线程
			 * 并发执行效率
			 * 同步块需要自行指定"同步监视器",即:上锁的
			 * 对象,只要保证需要排队执行的多个线程看到的
			 * 是同一个对象即可!
			 */
			synchronized(this){
				System.out.println(t+":正在试衣服...");
				Thread.sleep(5000);
			}
			System.out.println(t+":结账离开");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}















