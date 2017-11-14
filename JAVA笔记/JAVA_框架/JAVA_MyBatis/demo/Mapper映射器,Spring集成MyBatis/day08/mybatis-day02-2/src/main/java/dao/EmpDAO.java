package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import annotations.MyBatisRepository;
import entity.Employee;
import entity.Employee2;

/**
 * Mapper映射器
 *
 */
@Repository("eDAO")
@MyBatisRepository
public interface EmpDAO {
	public void save(Employee e);
	public List<Employee> findAll();
	public Employee findById(int id);
	public void modify(Employee e);
	public void delete(int id);
	public Map findById2(int id);
	public Employee2 findById3(int id);
}










