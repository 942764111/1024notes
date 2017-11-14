package day10;
/**
 * �ػ��߳�
 * �ػ��߳��ֳ�Ϊ��̨�߳�
 * ����ͨ�̵߳�һ������Ҫ�������ڽ���ʵ��.
 * ��һ�����̽���ʱ,�������е��ػ��̶߳��ᱻǿ��
 * ����.
 * ��һ�������е�����ǰ̨(��ͨ)�߳̽���ʱ,���̾�
 * �����.
 * @author adminitartor
 *
 */
public class Thread_daemon {
	public static void main(String[] args) {
		/*
		 * ǰ̨�߳�:rose
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
				System.out.println("rose:��������AAAAAaaaaaa...");
				System.out.println("��Ч:��ͨ!");
			}
		};
		/*
		 * ��̨�߳�:jack
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
		 * ���ú�̨�̱߳�����start��������ǰִ��
		 */
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
	
	}
}








