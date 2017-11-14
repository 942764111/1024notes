package cn.tedu.entity;

import java.io.Serializable;

public class Tbook implements Serializable{

	private static final long serialVersionUID = 7297398309748023649L;
	private int id;
	private String name;
	private Tuser user;
	public Tbook() {

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
	public Tuser getUser() {
		return user;
	}
	public void setUser(Tuser user) {
		this.user = user;
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
		Tbook other = (Tbook) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tbook [id=" + id + ", name=" + name + ", user=" + user.getName() + "]";
	}
}
