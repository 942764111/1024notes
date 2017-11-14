package annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cp")
public class Computer {
	@Value("蓉儿")
	private String name;
	
	@Value("#{config.pagesize}")
	private int pageSize;
	
//	@Value("蓉儿")
//	public void setName(String name) {
//		System.out.println("setName()");
//		this.name = name;
//	}
	
	@Override
	public String toString() {
		return "Computer [name=" + name + ", pageSize=" + pageSize + "]";
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
