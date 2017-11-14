#让容器自动建立依赖关系
#byName 
- 通过在XML中所有配置的bean id  
- 查找匹配的setXX调用set方法若没有返回null
##一、XML中配置
		<bean id="wa" class="ioc.Waiter" />
		<bean id = "mg" class = "autowire.Manager" autowire="byName">
##二、JAVA代码

	public class Manager {
		private Waiter wa;
		public Waiter getWa() {
			Main.log("getWa()", this);
			return wa;
		}
		public void setWa(Waiter wa) {
			Main.log("setWa()", this);
			this.wa = wa;
		}
		@Override
		public String toString() {
			return "Manager [wa=" + wa + "]";
		}
		
	}

----------

#byType 
- 通过在XML中所有配置的bean class对应的类型  
- 查找匹配的class类型调用set方法若没有返回null
- 如果找到多个,报错因为byType找的class类型对象只能唯一.
##一、XML中配置
		<bean id="wa" class="ioc.Waiter" />
		<bean id = "mg" class = "autowire.Manager" autowire="byType">
##二、JAVA代码

	public class Manager {
		private Waiter wa;
		public Waiter getWa() {
			Main.log("getWa()", this);
			return wa;
		}
		public void setWa(Waiter wa) {
			Main.log("setWa()", this);
			this.wa = wa;
		}
		@Override
		public String toString() {
			return "Manager [wa=" + wa + "]";
		}
		
	}