package cn.tedu.service;

import cn.tedu.entity.User;

public interface UserService {
	User login(String username,String password);
}
