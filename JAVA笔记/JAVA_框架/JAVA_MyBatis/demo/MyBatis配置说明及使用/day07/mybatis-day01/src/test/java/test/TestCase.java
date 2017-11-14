package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Employee;
import entity.Employee2;

public class TestCase {
	private SqlSession session;
	@Before
	public void init(){
		/*
		 * step1. 先获得SqlSession对象
		 * 注:SqlSession用来执行sql语句。
		 */
		SqlSessionFactoryBuilder ssfb = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = 
				ssfb.build(
				TestCase.class.getClassLoader()
				.getResourceAsStream(
						"SqlMapConfig.xml"));
		 session = 
				ssf.openSession();
	}
	
	@Test
	public void test1(){
		/*
		 * step2. 调用SqlSession对象提供的方法
		 * 来访问数据库
		 */
		Employee e = new Employee();
		e.setName("Sally");
		e.setAge(30);
		session.insert("test.save", e);
		/*
		 * step3. 涉及数据的变化（添加，修改，删除）
		 * 需要提交事务。
		 */
		session.commit();
		/*
		 * step4. 关闭资源
		 */
		session.close();
	}
	
	
	@Test
	public void test2(){
		List<Employee> employees = 
			session.selectList("test.findAll");
		System.out.println(employees);
		session.close();
	}
	
	@Test
	public void test3(){
		Employee e = 
				session.selectOne(
						"test.findById", 21);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test4(){
		Employee e = 
				session.selectOne(
						"test.findById", 21);
		e.setAge(e.getAge() + 10);
		session.update("test.modify", e);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		session.delete("test.delete", 21);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Map data = 
				session.selectOne(
						"test.findById2", 22);
		//注意，oracle数据库中字段名是大写
		//形式。
		System.out.println(data.get("NAME"));
		session.close();
	}
	
	@Test
	public void test7(){
		Employee2 e2 = 
				session.selectOne(
						"test.findById3", 22);
		System.out.println(e2);
		session.close();
	}
	
	
	
	
	
	
}









