package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Employee;

@Repository("employeeDAO")
public class EmployeeDAO {
	@Resource(name="jt")
	private JdbcTemplate jt;
	
	/**
	 * SpringJdbc会将底层的jdbc异常转换成
	 * 相应的RuntimeException，然后抛出。
	 */
	public void save(Employee e){
		String sql = 
			"INSERT INTO emp "
			+ "VALUES(emp_seq.nextval,?,?)";
		Object[] args = {e.getName(),e.getAge()};
		jt.update(sql, args);
	}
	
	public List<Employee> findAll(){
		List<Employee> employees = 
				new ArrayList<Employee>();
		String sql = "SELECT * FROM emp";
		employees = 
				jt.query(sql, new EmpRowMapper());
		return employees;
	}
	
	public Employee findById(int id){
		String sql = "SELECT * FROM emp "
				+ "WHERE id=?";
		Object[] args = {id};
		return jt.queryForObject(sql,args, 
				new EmpRowMapper());
	}
	
	public void modify(Employee e){
		String sql = "UPDATE emp SET "
				+ "name=?,age=? WHERE id=?";
		Object[] args = {e.getName(),
				e.getAge(),e.getId()};
		jt.update(sql, args);
	}
	
	public void delete(int id){
		String sql = "DELETE FROM emp "
				+ "WHERE id=?";
		Object[] args = {id};
		jt.update(sql, args);
	}
	
	
	/*
	 * 告诉SpringJdbc，如何将记录转换成
	 * 对应的实体对象。
	 */
	class EmpRowMapper 
		implements RowMapper<Employee>{

		//index:正在被处理的记录的下标
		public Employee mapRow(
				ResultSet rst, int index) 
						throws SQLException {
			Employee e = new Employee();
			e.setId(rst.getInt("id"));
			e.setName(rst.getString("name"));
			e.setAge(rst.getInt("age"));
			return e;
		}
		
	}
	
}




