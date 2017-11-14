package day10;
/**
 * 线程提供的join方法允许使线程间同步运行
 * 
 * 同步:有先后顺序的执行
 * 异步:各执行各的
 * @author adminitartor
 *
 */
public class Thread_join {
	//图片是否下载完毕
	public static boolean isFinish = false;
	
	public static void main(String[] args) {
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i=1;i<=100;i++){
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down:图片下载完毕!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:开始显示图片...");
				
				//等待下载线程将图片下载完毕
				try{
					download.join();
				}catch(InterruptedException e){
					
				}
				
				if(!isFinish){
					throw new RuntimeException("图片加载失败!");
				}
				System.out.println("show:显示图片完毕!");
			}
		};
		
		download.start();
		show.start();
	}
}









