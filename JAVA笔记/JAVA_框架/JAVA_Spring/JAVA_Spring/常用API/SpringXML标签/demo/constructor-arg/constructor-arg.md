#手动装配构造器注入 
##一、XML中配置
		<bean id = "wt" class = "ioc.Waiter" />
		<bean id = "rest" class = "ioc.Restaurant">
			<constructor-arg index="0" ref="wt" />
		</bean>

----------

##二、JAVA代码

	package ioc;
	
	public class Restaurant {
		private Waiter wt;
		public Restaurant() {
			System.out.println(this.getClass().getName()+"::Restaurant()");
		}
		public Restaurant(Waiter wt) {
			this.wt=wt;
			System.out.println(this.getClass().getName()+"::Restaurant(Waiter wt)");
		}
		@Override
		public String toString() {
			return "Restaurant [wt=" + wt + "]";
		}
		
	}