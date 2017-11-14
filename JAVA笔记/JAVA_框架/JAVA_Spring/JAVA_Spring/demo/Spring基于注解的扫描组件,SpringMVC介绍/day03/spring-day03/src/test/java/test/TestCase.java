package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotations.Computer;
import annotations.Leader;
import annotations.Manager;
import annotations.Restaurant;
import annotations.Student;

public class TestCase {
	@Test
	//测试　组件扫描
	public void test1(){
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Student stu =
				ac.getBean("stu1",
						Student.class);
		System.out.println(stu);
	}
	
	@Test
	//测试　作用域
	public void test2(){
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Student stu =
				ac.getBean("stu1",
						Student.class);
		Student stu2 =
				ac.getBean("stu1",
						Student.class);
		System.out.println(stu == stu2);
	}
	
	@Test
	//测试　生命周期
	public void test3(){
		String config = "applicationContext.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		ac.close();
	}
	
	@Test
	//测试　@Autowired
	public void test4(){
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Restaurant rest = 
				ac.getBean("rest",
						Restaurant.class);
		System.out.println(rest);
		
		Leader ld = 
				ac.getBean("ld",Leader.class);
		System.out.println(ld);
	}
	
	@Test
	//测试　@Resource
	public void test5(){
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Manager mg = 
				ac.getBean("mg",Manager.class);
		System.out.println(mg);
	}
	
	
	@Test
	//测试　@Value
	public void test6(){
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Computer cp = 
				ac.getBean("cp",Computer.class);
		System.out.println(cp);
	}
	
	
	
}









