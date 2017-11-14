package dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import entity.Employee;
import entity.Employee2;

@Repository("eDAO")
public class EmpDAOMyBatisImpl implements 
EmpDAO{
	
	@Resource(name="sst")
	private SqlSessionTemplate sst;
	
	/**
	 * SqlSessionTemplate已经帮我们接管了
	 * SqlSession。我们不再需要提交事务，关闭
	 * SqlSession。
	 */
	public void save(Employee e) {
		sst.insert("dao.EmpDAO.save", e);
	}

	public List<Employee> findAll() {
		return sst.selectList(
				"dao.EmpDAO.findAll");
	}

	public Employee findById(int id) {
		return sst.selectOne(
				"dao.EmpDAO.findById", id);
	}

	public void modify(Employee e) {
		sst.update("dao.EmpDAO.modify",
				e);
	}

	public void delete(int id) {
		sst.delete("dao.EmpDAO.delete", id);
	}

	public Map findById2(int id) {
		return sst.selectOne(
				"dao.EmpDAO.findById2", id);
	}

	public Employee2 findById3(int id) {
		return sst.selectOne(
				"dao.EmpDAO.findById3", id);
	}
	

}
