package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public User login(String username, String password) {
		User someone
				=userDao.findByName(username);
		if((someone!=null)
			&&someone.getPassword().equals(password)){
			System.out.println(someone);
			return someone;
		}
		return null;
	}



}
