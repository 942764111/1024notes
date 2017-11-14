package cn.tedu.service;

import cn.tedu.util.Result;

public interface UserService {
	Result checkLogin(String name,
					String password);
}
