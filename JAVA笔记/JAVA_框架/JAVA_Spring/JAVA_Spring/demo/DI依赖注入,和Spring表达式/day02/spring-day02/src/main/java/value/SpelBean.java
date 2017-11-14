package value;

public class SpelBean {
	private String name;
	private String interest;
	private double score;
	private String pageSize;
	
	public SpelBean() {
		System.out.println("SpelBean()");
	}
	
	@Override
	public String toString() {
		return "SpelBean [name=" + name + ", interest=" + interest + ", score=" + score + ", pageSize=" + pageSize
				+ "]";
	}



	public void setName(String name) {
		this.name = name;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
}
