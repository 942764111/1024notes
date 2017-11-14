package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ld")
public class Leader {
	@Autowired
	@Qualifier("wt")
	private Waiter wt;
	
	public Leader() {
		System.out.println("Leader()");
	}

//	@Autowired
//	public void setWt(@Qualifier("wt") 
//		Waiter wt) {
//		System.out.println("setWt()");
//		this.wt = wt;
//	}

	@Override
	public String toString() {
		return "Leader [wt=" + wt + "]";
	}
	
}
