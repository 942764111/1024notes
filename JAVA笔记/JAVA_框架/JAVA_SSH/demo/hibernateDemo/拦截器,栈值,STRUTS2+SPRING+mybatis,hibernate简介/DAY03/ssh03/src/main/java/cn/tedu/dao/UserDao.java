package cn.tedu.dao;

import cn.tedu.User;
import cn.tedu.UserPwd;

public interface UserDao {
	void save(User user);
	UserPwd findByName(String name);
}
