package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Manager;
import basic.MessageBean;
import basic.ScopeBean;
import ioc.A;
import ioc.Restaurant;

public class TestCase {
	@Test
	//测试 生命周期
	public void test1(){
		String config = "basic.xml";
		//启动spring容器
		/*
		 * ApplicationContext接口没有提供close
		 * 方法,AbstractApplicationContext
		 * 是一个抽象类，实现了ApplicationContext
		 * 接口,并且提供了close方法。
		 */
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
					config);
		//调用容器提供的getBean方法获得对象
		MessageBean mb1 = 
				ac.getBean("mb1",
						MessageBean.class);
		mb1.sendMsg();
		//关闭容器
		ac.close();
	}
	
	@Test
	//测试 作用域
	public void test2(){
		String config = "basic.xml";
		//启动spring容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
					config);
		//调用容器提供的getBean方法获得对象
		ScopeBean sb1  = 
				ac.getBean("sb1",ScopeBean.class);
		ScopeBean sb2  = 
				ac.getBean("sb1",ScopeBean.class);
		System.out.println(sb1 == sb2);
	}
	
	
	@Test
	//测试 延迟加载
	public void test3(){
		String config = "basic.xml";
		//启动spring容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
					config);
	}
	
	@Test
	//测试 set方法注入
	public void test4(){
		String config = "ioc.xml";
		//启动spring容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
					config);
		A a1 = 
				ac.getBean("a1",A.class);
		a1.execute();
	}
	
	@Test
	public void test5(){
		String config = "ioc.xml";
		//启动spring容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
					config);
		Restaurant rest1 = 
			ac.getBean("rest1",Restaurant.class);
		System.out.println(rest1);
	}
	
	@Test
	//测试 自动装配
	public void test6(){
		String config = "autowire.xml";
		//启动spring容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
					config);
		Manager mg = 
				ac.getBean("mg",Manager.class);
		System.out.println(mg);
	}
	
}





