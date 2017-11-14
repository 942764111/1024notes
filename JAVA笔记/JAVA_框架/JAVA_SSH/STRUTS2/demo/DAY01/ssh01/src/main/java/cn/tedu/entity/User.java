package cn.tedu.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -2074369796447083139L;
	private String name;
	private String pwd;
	public User() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + "]";
	}
}








