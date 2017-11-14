package cn.tedu.dao;

import java.util.List;

import cn.tedu.entity.User;

public interface UserDao {
	void save(User user);
	void update(User user);
	void delete(User user);
	User findByName(String name);
	User findById(String id);
	List<User> findAll();
}







