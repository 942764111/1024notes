package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmpDAO;
import entity.Employee;

public class TestCase {
	private SqlSession session;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb = 
				new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = 
				ssfb.build(
				TestCase.class.getClassLoader()
				.getResourceAsStream(
						"SqlMapConfig.xml"));
		session = ssf.openSession();
	}
	
	@Test
	public void test1(){
		/*
		 * getMapper方法会返回一个符合接口要求的
		 * 对象。
		 */
		EmpDAO dao = 
				session.getMapper(EmpDAO.class);
		Employee e = new Employee();
		e.setName("Jack");
		e.setAge(22);
		dao.save(e);
		//仍然需要提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		EmpDAO dao = 
				session.getMapper(EmpDAO.class);
		 List<Employee> employees = 
				 dao.findAll();
		 System.out.println(employees);
		 session.close();
	}
	
	@Test
	public void test3(){
		EmpDAO dao = 
				session.getMapper(EmpDAO.class);
		Employee e = 
				dao.findById(41);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test4(){
		EmpDAO dao = 
				session.getMapper(EmpDAO.class);
		Employee e = 
				dao.findById(41);
		e.setAge(e.getAge() + 20);
		dao.modify(e);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		EmpDAO dao = 
				session.getMapper(EmpDAO.class);
		dao.delete(41);
		session.commit();
		session.close();
	}
	
	
}













