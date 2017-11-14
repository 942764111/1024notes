package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Restaurant {
	
	private Waiter wt;

	public Restaurant() {
		System.out.println("Restaurant()");
	}

	@Autowired
	public Restaurant(@Qualifier("wt") 
		Waiter wt) {
		System.out.println("Restaurant(wt)");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
	
	
	
	
}
