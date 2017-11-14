package day10;
/**
 * 使用匿名内部类形式创建线程
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你是谁啊?");
				}
			}
		}.start();
		
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("我是查水表的.");
				}
			}
		}).start();

	}
}
