package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tedu.entity.Teacher;

public class TestTeacher {
	@Test
	public void test(){
		//获取session对象
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory
						=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//保存数据到teacher表
		Teacher teacher
				=new Teacher("苍#null");
		Transaction t =session.beginTransaction();
		t.begin(); //开启事务
		session.save(teacher);
		System.out.println(teacher);
		t.commit();//提交事务
		session.close();	
	}

}






