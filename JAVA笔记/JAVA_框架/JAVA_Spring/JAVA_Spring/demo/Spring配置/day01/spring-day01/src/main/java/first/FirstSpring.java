package first;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		String config = 
				"applicationContext.xml";
		//启动Spring容器
		/*
		 * 注：
		 * a. ApplicationContext是接口。
		 * b. ClassPathXmlApplicationContext
		 * 是一个具体类，实现了上述接口。
		 * c. config是配置文件的位置及文件名。
		 */
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					config);
		//System.out.println(ac);
		
		//调用容器提供的getBean方法来获得对象
		/*
		 *  Student.class: Student类对应的class对象。
		 *  注： 
		 *  	类加载器负责读取.class文件的内容，
		 *  然后将这些内容存放到方法区对应的
		 *  一个class对象里面。
		 *  
		 */
		//Student stu = ac.getBean("stu1",
				//Student.class);
		//System.out.println(stu);
		
		
//		Date date1 = 
//				ac.getBean("date1",Date.class);
//		System.out.println(date1);
		
		
//		Calendar cal1 = 
//				ac.getBean("cal1",
//						Calendar.class);
//		System.out.println(cal1);
		
		Date time1 = 
				ac.getBean("time1",Date.class);
		System.out.println(time1);
		
	}

}
