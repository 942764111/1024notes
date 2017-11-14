package cn.tedu.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tedu.entity.Student;
import cn.tedu.entity.Tbook;
import cn.tedu.entity.Tuser;

public class TestStudent {
	public static Session openSession(){
		//获取session对象
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory
					=cfg.buildSessionFactory();
		Session session=factory.openSession();
		return session;
	}
	//@Test
	public void test(){
		//获取session对象
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory
				=cfg.buildSessionFactory();
		Session session=factory.openSession();
		//保存对象到数据库
		Student s=new Student("李老师");
		
		Transaction t=session.beginTransaction();
		t.begin();
		System.out.println(s);
		session.save(s);
		System.out.println(s);
		t.commit();
		session.close();
	}
	//@Test
	public void testUpdate(){
		//获取session对象
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory
					=cfg.buildSessionFactory();
		Session s=factory.openSession();
		//开启事务
		Transaction t=s.beginTransaction();
		t.begin();
		//获取持久化对象
		Student stu
				=(Student)s.get(
				  Student.class, 1);
		System.out.println(stu);
		//更新属性数据自动改变列值
		stu.setName("Robin");
		System.out.println(stu);
		t.commit();
		s.close();
	}
	//@Test
	public void testDelete(){
		Session s=openSession();
		Transaction t=s.beginTransaction();
		t.begin();
		Student stu
				=(Student) s.get(Student.class, 2);
		System.out.println(stu);
		s.delete(stu);
		t.commit();
		s.close();
	}
	//@Test
	public void testObject(){
		Session s=openSession();
		Transaction t=s.beginTransaction();
		t.begin();
		Student stu
			=(Student) s.get(Student.class, 1);
		System.out.println(stu);
		s.evict(stu);// 缓存中清除stu对象
		stu.setName("Andy");
		System.out.println(stu);
		t.commit();
		s.close();
	}
	//@Test
	public void testObjectUpdate(){
		Session s=openSession();
		Transaction t=s.beginTransaction();
		t.begin();
		Student stu  //获取持久化对象
				=(Student) s.get(Student.class, 1);
		s.evict(stu);//使stu变成游离状态
		stu.setName("Nemo");
		System.out.println(stu);
		s.update(stu);//stu被再次放到缓存中
		t.commit();
		s.close();
	}
	//@Test
	public void testSelect(){
		//步骤一：获取session对象
		Session s=openSession();
		//步骤二：编写HQL语句
		String hql="from Student";
		//步骤三：创建查询对象
		Query query=s.createQuery(hql);
		//步骤四：执行查询，返回结果
		List<Student> list
						= query.list();
		//输出查询结果
		for(Student stu:list){
			System.out.println(stu);
		}
		//步骤五：关闭session
		s.close();	
	}
	//@Test
	public void testWhere(){
		Session s=openSession();
		String hql="from Student where name=:name";
		Query query=s.createQuery(hql);
		query.setString("name", "Nemo");
		List<Student> list
					  =query.list();
		for(Student stu:list){
			System.out.println(stu);
		}
		s.close();
	}
	//@Test
	public void testOrder(){
		Session s=openSession();
		String hql="from Student order by id desc";
		Query query=s.createQuery(hql);
		List<Student> list
						=query.list();
		for(Student stu:list){
			System.out.println(stu);
		}
		s.close();
	}
	@Test
	public void testOne2Many(){
		Session s=openSession();
		//获取用户及关联书籍数据
		Tuser user
				=(Tuser) s.get(Tuser.class,1);
		System.out.println(user.getId());
		System.out.println(user.getName());
		//获取关联书籍数据
		Set<Tbook> books
					=user.getBooks();
		System.out.println(books.size());
		for(Tbook b:books){
			System.out.println(b);
		}
		s.close();
	}
}






