package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import value.SpelBean;
import value.ValueBean;

public class TestCase {
	@Test
	//测试  注入基本类型的值
	public void test1(){
		String config = 
				"applicationContext.xml";
		//启动容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		//通过容器获得一个对象
		ValueBean vb = 
				ac.getBean("vb1",
						ValueBean.class);
		System.out.println(vb);
		
	}
	
	@Test
	// 以引用的方式注入集合类型的值
	public void test2(){
		String config = 
				"applicationContext.xml";
		//启动容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		//通过容器获得一个对象
		ValueBean vb = 
				ac.getBean("vb2",
						ValueBean.class);
		System.out.println(vb);
	}
	
	
	@Test
	// 读取properties文件
	public void test3(){
		String config = 
				"applicationContext.xml";
		//启动容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Properties props = 
				ac.getBean("config",
						Properties.class);
		System.out.println(props);
	}
	
	
	@Test
	// 测试 spring表达式
	public void test4(){
		String config = 
				"applicationContext.xml";
		//启动容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		SpelBean sb1 = 
				ac.getBean("sb1",SpelBean.class);
		System.out.println(sb1);
	}
}





