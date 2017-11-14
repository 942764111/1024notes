package cn.tedu.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Tuser implements Serializable{

	private static final long serialVersionUID = 2377353797955907812L;
	private int id;
	private String name;
	private Set<Tbook> books=new HashSet<Tbook>();
	public Tuser() {

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
	public Set<Tbook> getBooks() {
		return books;
	}
	public void setBooks(Set<Tbook> books) {
		this.books = books;
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
		Tuser other = (Tuser) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tuser [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
	

}
