package day10;
/**
 * �߳����ȼ�
 * �̵߳����ȼ���10���ȼ�,��Ӧ10������,�ֱ���1-10
 * ����1Ϊ������ȼ�,10Ϊ������ȼ�,5ΪĬ�����ȼ�
 * ��3��������Ӧ:
 * MIN_PRIORITY,MAX_PRIORITY;NORM_PRIORITY
 * 
 * �������߳����ȼ�Խ�ߵ��̻߳�ȡCPUʱ��Ƭ�Ĵ���
 * Խ��.
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








