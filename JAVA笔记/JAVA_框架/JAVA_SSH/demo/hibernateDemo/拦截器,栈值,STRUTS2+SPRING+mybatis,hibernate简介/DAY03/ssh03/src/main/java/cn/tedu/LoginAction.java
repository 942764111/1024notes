package cn.tedu;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import cn.tedu.service.UserService;
import cn.tedu.util.Result;

@Controller
public class LoginAction implements SessionAware{

	private Map<String,Object> session;
	private String name;
	private String password;
	private Result result;
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	@Resource
	private UserService userService;
	
	public String execute(){
		result
		=userService.checkLogin(name, password);
		if(result.getStatus()==0){
			UserPwd user=(UserPwd) result.getData();
			session.put("loginUser", user);
			return "success";
		}else{
			return "error";
		}
	}
}



