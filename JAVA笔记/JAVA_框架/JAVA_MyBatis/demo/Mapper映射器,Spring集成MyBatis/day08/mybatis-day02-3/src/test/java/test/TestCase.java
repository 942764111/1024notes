package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Employee;

public class TestCase {
	private EmpDAO dao;
	@Before
	public void init(){
		//启动Spring容器
		String config = "applicationContext.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		//通过容器获得对象
		dao = 
			ac.getBean("eDAO",EmpDAO.class);
	}
	
	@Test
	public void test1(){
		Employee e = new Employee();
		e.setName("Tom");
		e.setAge(22);
		dao.save(e);
	}
	
	@Test
	public void test2(){
		List<Employee> employees = 
				dao.findAll();
		System.out.println(employees);
	}
}



