package entity;

public class Employee2 {
	private Integer empNo;
	private String ename;
	private Integer age;
	
	@Override
	public String toString() {
		return "Employee2 [empNo=" + empNo + ", ename=" + ename + ", age=" + age + "]";
	}
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
