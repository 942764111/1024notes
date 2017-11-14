package autowire;

public class Manager {
	private Computer cp;

	public Manager() {
		System.out.println("Manager()");
	}

	public void setCp(Computer cp) {
		System.out.println("setCp()");
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}
	
	
	
	
}
