package cn.tedu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.UserService;

public class TestCase {
	ApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
				"spring-context.xml");
	}
	//@Test
	public void testFinByName(){
		UserDao dao
				=ctx.getBean(
				"userDao", UserDao.class);
		User user=dao.findByName("JackSon");
		System.out.println(user);
	}
	@Test
	public void testLogin(){
		String username="JackSon";
		String password="123456";
		UserService userService
			=ctx.getBean(
					"userService",UserService.class);
		User user=userService.login(username, password);
		System.out.println(user);
	}

}









