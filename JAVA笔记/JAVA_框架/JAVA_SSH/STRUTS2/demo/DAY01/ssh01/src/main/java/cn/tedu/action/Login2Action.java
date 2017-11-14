package cn.tedu.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import cn.tedu.entity.User;

public class Login2Action 
		implements SessionAware{
	private User user;
	private String message;
	private Map<String,Object>session;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute(){
//通过工厂类获取session对象		
//		ActionContext ctx
//			=ActionContext.getContext();
//		Map<String,Object>session
//			=ctx.getSession();
		
		if(user.getName().equals("Jack")
				&&user.getPwd().equals("123456")){
			session.put("loginName", "Jack");
			return "success";
		}
		message="用户名或密码错误，请重新登录！";
		return "error";
	}

}






