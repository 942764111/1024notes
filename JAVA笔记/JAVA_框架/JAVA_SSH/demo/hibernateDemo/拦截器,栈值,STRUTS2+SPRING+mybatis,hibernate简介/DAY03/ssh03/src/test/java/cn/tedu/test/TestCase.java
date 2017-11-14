package cn.tedu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.User;
import cn.tedu.UserPwd;
import cn.tedu.dao.UserDao;

public class TestCase {
	//@Test
	public void testSave(){
		ClassPathXmlApplicationContext ctx
			=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserDao dao=ctx.getBean("userDao", UserDao.class);
		
		User user=new User();
		user.setId(2);
		user.setName("Peter");
		
		dao.save(user);
	}
	@Test
	public void testFind(){
		ClassPathXmlApplicationContext ctx
			=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserDao dao=ctx.getBean("userDao", UserDao.class);
		
		UserPwd u=dao.findByName("zhangsan");
		
		System.out.println(u);
	}

}






