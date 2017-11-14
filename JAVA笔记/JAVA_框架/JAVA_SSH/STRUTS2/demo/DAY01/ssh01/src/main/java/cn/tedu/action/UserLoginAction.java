package cn.tedu.action;

import cn.tedu.entity.User;

public class UserLoginAction {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute(){
		System.out.println(user);
		return "success";
	}
}







