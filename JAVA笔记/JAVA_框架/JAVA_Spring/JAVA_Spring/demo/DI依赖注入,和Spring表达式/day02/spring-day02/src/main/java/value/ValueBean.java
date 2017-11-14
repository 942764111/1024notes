package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ValueBean {
	private String name;
	private int age;
	private List<String> interest;
	private Set<String> city;
	private Map<String,Double> score;
	private Properties db;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getInterest() {
		return interest;
	}

	public Set<String> getCity() {
		return city;
	}

	public Map<String, Double> getScore() {
		return score;
	}

	public Properties getDb() {
		return db;
	}

	public void setDb(Properties db) {
		this.db = db;
	}

	public void setScore(Map<String, Double> score) {
		this.score = score;
	}

	public void setCity(Set<String> city) {
		this.city = city;
	}

	public void setInterest(List<String> interest) {
		this.interest = interest;
	}

	public ValueBean() {
		System.out.println("ValueBean()");
	}
	
	@Override
	public String toString() {
		return "ValueBean [name=" + name + ", age=" + age + ", interest=" + interest + ", city=" + city + ", score="
				+ score + ", db=" + db + "]";
	}

	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}
	
	public void setAge(int age) {
		System.out.println("setAge()");
		this.age = age;
	}
	
}
