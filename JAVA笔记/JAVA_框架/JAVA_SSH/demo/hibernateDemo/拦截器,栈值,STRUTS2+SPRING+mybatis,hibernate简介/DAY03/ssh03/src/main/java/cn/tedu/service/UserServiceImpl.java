package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.UserPwd;
import cn.tedu.dao.UserDao;
import cn.tedu.util.Result;

@Service("userService")
public class UserServiceImpl 
				implements UserService{
	@Resource
	private UserDao userDao; //注入dao
	
	public Result checkLogin(String name, String password) {
		Result result=new Result();
		
		UserPwd user=userDao.findByName(name);
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在！");
			return result;
		}
		result.setStatus(0);
		result.setMsg("登录成功!");
		result.setData(user);
		return result;
	}



}
