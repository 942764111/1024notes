package day10;
/**
 * 守护线程
 * 守护线程又称为后台线程
 * 与普通线程的一个最主要区别在于结束实际.
 * 当一个进程结束时,所有运行的守护线程都会被强制
 * 结束.
 * 当一个进程中的所有前台(普通)线程结束时,进程就
 * 会结束.
 * @author adminitartor
 *
 */
public class Thread_daemon {
	public static void main(String[] args) {
		/*
		 * 前台线程:rose
		 */
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:啊啊啊啊AAAAAaaaaaa...");
				System.out.println("音效:噗通!");
			}
		};
		/*
		 * 后台线程:jack
		 */
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		/*
		 * 设置后台线程必须在start方法调用前执行
		 */
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
	
	}
}








