package cn.tedu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.User;
import cn.tedu.service.UserService;

@Controller
@Scope("prototype")
public class LoginAction {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Resource
	private UserService userService;
	
	public String execute(){
		User user
			=userService.login(username, password);
		if(user!=null){
			return "success";
		}
		return "error";
	}

}








