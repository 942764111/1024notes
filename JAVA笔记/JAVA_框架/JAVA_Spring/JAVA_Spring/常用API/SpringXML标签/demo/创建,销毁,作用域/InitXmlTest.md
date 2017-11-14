	

#一、XML配置
	<bean id="mb1" class="basic.messagebean" 
		init-method="init" 
		destroy-method="destroy"
		scope="prototype">
	</bean>


----------

#二、JAVA代码
- 一、定义测试类
	package basic;
	
	public class MessageBean {
	
		public MessageBean() {
			System.out.println("MessageBean()");
		}
		
		public void init(){
			System.out.println("init()");
		}
		
		public void sendMsg(){
			System.out.println("sendMsg()");
		}
		
		public void destroy(){
			System.out.println("destroy()");
		}
		
		
	}

- 二、调用测试类

	//测试 生命周期

	public void test1(){

		String config = "basic.xml";

		//启动spring容器
		/*
		 * ApplicationContext接口没有提供close
		 * 方法,AbstractApplicationContext
		 * 是一个抽象类，实现了ApplicationContext
		 * 接口,并且提供了close方法。
		 */
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
					config);
		//调用容器提供的getBean方法获得对象
		MessageBean mb1 = 
				ac.getBean("mb1",
						MessageBean.class);
		mb1.sendMsg();
		//关闭容器此时调用销毁方法
		ac.close();
	}


