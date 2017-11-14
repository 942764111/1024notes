package cn.tedu;

import java.io.Serializable;

public class UserPwd implements Serializable{

	private static final long serialVersionUID = 4987829561791367037L;
	private int id;
	private String name;
	private String password;
	public UserPwd(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPwd other = (UserPwd) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserPwd [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}





