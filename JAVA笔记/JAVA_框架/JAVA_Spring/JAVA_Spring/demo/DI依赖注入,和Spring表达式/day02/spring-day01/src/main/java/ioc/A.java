package ioc;

public class A {
	private IB b;
	
	public void setB(IB b) {
		System.out.println("A's setB()");
		this.b = b;
	}

	public A() {
		System.out.println("A()");
	}
	
	public void execute(){
		System.out.println("A's execute()");
		//需要调用B的f1()
		b.f1();
	}
	
}
