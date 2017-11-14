#创建对象
##一、applicationContext.xml中配置
	<!-- 
		使用无参构造器来创建对象。
		id属性：是bean的名称，要求唯一。
		class属性：要写类的完整的名字
		(包名和类名都得写)
	 -->
	<bean id="stu1" class="first.Student">
	</bean>
	
	<bean id="date1" class="java.util.Date">
	</bean>
	
	<!-- 使用静态工厂方法创建对象 
		注:
			factory-method属性：指定一个静态方法。
		容器会调用该类的静态方法来创建对象。
	-->
	<bean id="cal1" class="java.util.Calendar"
		factory-method="getInstance">
	</bean>
	
	<!-- 
		使用实例工厂方法创建对象。
		注：
			factory-bean属性：值为一个bean的id。
			factory-method属性：要调用的实例方法。
			容器会调用该bean的实例方法来创建对象。
	 -->
	<bean id="time1" factory-bean="cal1" 
		factory-method="getTime">
	</bean>

##二、JAVA代码：
package first;

import java.util.Date;

import org.springframework.context.ApplicationContext;</br>
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

	一、使用无参构造器来创建对象。
		Student stu = ac.getBean("stu1",
				Student.class);
		System.out.println(stu);
		
		·
		Date date1 = 
				ac.getBean("date1",Date.class);
		System.out.println(date1);
		


	二、使用静态工厂方法创建对象 
		Calendar cal1 = 
				ac.getBean("cal1",
						Calendar.class);
		System.out.println(cal1);



	三、使用实例工厂方法创建对象。
		Date time1 = 
				ac.getBean("time1",Date.class);
		System.out.println(time1);
		
	}

}
