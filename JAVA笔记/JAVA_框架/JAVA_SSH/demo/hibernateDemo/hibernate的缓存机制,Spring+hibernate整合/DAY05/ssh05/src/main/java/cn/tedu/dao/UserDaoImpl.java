package cn.tedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.entity.User;
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void save(User user) {
		hibernateTemplate.save(user);	
	}

	public void update(User user) {
		hibernateTemplate.update(user);
	}

	public void delete(User user) {
		hibernateTemplate.delete(user);	
	}

	public User findByName(String name) {
		String hql="from User where name=:name";
		List list
				=hibernateTemplate.findByNamedParam(hql, "name", name);
		if(list.isEmpty()){
			return null;
		}
		return (User) list.get(0);
	}

	public User findById(String id) {
		String hql="from User where id=?";
		List list=hibernateTemplate.find(hql, id);
		if(list.size()==0){
			return null;
		}
		return (User) list.get(0);
	}

	public List<User> findAll() {
		String hql="from User";
		List<User> list=hibernateTemplate.find(hql);
		return list;
	}



}
