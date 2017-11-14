#依赖注入Demo
##一、applicationContext.xml中配置

	<bean id = "b1" class="ioc.B"/>
	<bean id = "c1" class="ioc.C"/>
	<bean id = "a1" class="ioc.A">
		<!--  
		property属性
			   name：调用a1中set方法并将set后面的首字母转为大写
				   
			   ref：调用有依赖关系的类 参数为beanID
		-->
		<property name="b" ref="c1"/>
	</bean>







----------

#二、JAVA代码：
- 一、接口：
 
	package ioc;
	
	public interface IB {
		public void f1();
	}

- 二、声明B和C类

	package ioc;
	
	public class B implements IB{
	
	
		public B() {
			System.out.println(this.getClass().getName());
		}
		public void f1(){
			System.out.println(this.getClass().getName()+"::f1()");
		}
	}



		package ioc;
		
		public class C   implements IB{
			public C() {
				System.out.println(this.getClass().getName());
			}
			public void f1(){
				System.out.println(this.getClass().getName()+"::f1()");
			}
		}

----------

- 三、在A类调用调用接口利用向上造型


		package ioc;
		
		public class A {
		
			private IB b;
		
			public A() {
				System.out.println(this.getClass().getName());
			}
			public void execute(){
				System.out.println(this.getClass().getName()+"::execute()");
				//需要调用B的f1()方法
				b.f1();
				
			}
			public void setB(IB b) {
				System.out.println(this.getClass().getName()+"::setB()");
				this.b = b;
			}
			public void setC(IB c) {
				System.out.println(this.getClass().getName()+"::setC()");
				this.b = c;
			}
		}