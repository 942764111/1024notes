package day10;
/**
 * ʹ�������ڲ�����ʽ�����߳�
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("����˭��?");
				}
			}
		}.start();
		
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("���ǲ�ˮ���.");
				}
			}
		}).start();

	}
}
