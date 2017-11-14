package annotations;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	@Resource(name="wt")
	private Waiter wt;
	
//	@Resource(name="wt")
//	public void setWt(Waiter wt) {
//		System.out.println("setWt()");
//		this.wt = wt;
//	}

	public Manager() {
		System.out.println("Manager()");
	}

	@Override
	public String toString() {
		return "Manager [wt=" + wt + "]";
	}
	
	
	
	
	
	
}
