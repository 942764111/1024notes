package annotations;

import org.springframework.stereotype.Component;

@Component("wt")
public class Waiter {

	public Waiter() {
		System.out.println(
				"Waiter()");
	}
	
}

