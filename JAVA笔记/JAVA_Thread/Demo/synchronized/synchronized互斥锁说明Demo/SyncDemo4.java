package day11;
/**
 * Synchronized也是互斥锁
 * 当修饰的是两端不同的代码,但是同步监视器对象是
 * 同一个的时候,那么就具有了互斥性.
 * @author adminitartor
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo boo = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				boo.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(t+":正在执行A方法");
			Thread.sleep(5000);
			System.out.println(t+":运行A方法完毕");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void methodB(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(t+":正在执行B方法");
			Thread.sleep(5000);
			System.out.println(t+":运行B方法完毕");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}






