package ioc;

public class Restaurant {
	private Waiter wt;

	public Restaurant() {
		System.out.println("Restaurant()");
	}

	public Restaurant(Waiter wt) {
		System.out.println("Restaurant(wt)");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
	
	
	
}
