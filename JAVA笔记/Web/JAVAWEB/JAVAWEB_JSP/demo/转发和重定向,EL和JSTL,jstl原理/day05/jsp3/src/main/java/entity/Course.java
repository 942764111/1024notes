package entity;

import java.io.Serializable;

public class Course implements Serializable {

	//对象的属性
	private Integer courseId;
	private String name;
	private Integer days;
	
	//id是Bean属性:
	//通过get/set方法所直接反映出来的属性。
	//将get/set去掉所得到的单词，再将其首字母小写。
	public Integer getId() {
		return courseId;
	}
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
}








