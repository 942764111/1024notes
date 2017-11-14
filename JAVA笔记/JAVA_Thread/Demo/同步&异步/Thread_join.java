package day10;
/**
 * �߳��ṩ��join��������ʹ�̼߳�ͬ������
 * 
 * ͬ��:���Ⱥ�˳���ִ��
 * �첽:��ִ�и���
 * @author adminitartor
 *
 */
public class Thread_join {
	//ͼƬ�Ƿ��������
	public static boolean isFinish = false;
	
	public static void main(String[] args) {
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:��ʼ����ͼƬ...");
				for(int i=1;i<=100;i++){
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down:ͼƬ�������!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:��ʼ��ʾͼƬ...");
				
				//�ȴ������߳̽�ͼƬ�������
				try{
					download.join();
				}catch(InterruptedException e){
					
				}
				
				if(!isFinish){
					throw new RuntimeException("ͼƬ����ʧ��!");
				}
				System.out.println("show:��ʾͼƬ���!");
			}
		};
		
		download.start();
		show.start();
	}
}









