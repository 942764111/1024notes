# 一.监听器
## 1.什么是监听器
- 用来监视事件发生的对象
- 当事件发生时该对象会通知服务器

## 2.监听的目标
### 1) request
- ServletRequestListener:监视request的创建与销毁
- ServletRequestAttributeListener:监视request中数据的变化

### 2) session
- HttpSessionListener:监视session的创建与销毁
- HttpSessionAttributeListener:监视session中数据的变化

### 3) context
- ServletContextListener:监视context的创建与销毁
- ServletContextAttributeListener:监视context中数据的变化

## 3.如何使用监听器
 写一个类,实现对应的Listener接口
- 
	package Listener;
	
	import javax.servlet.http.HttpSessionEvent;
	import javax.servlet.http.HttpSessionListener;
	
	public class ListenerDemo implements HttpSessionListener{
		private int count = 0;
		public ListenerDemo() {
			System.out.println("ListenerDemo");
		
		}
	
		public void sessionCreated(HttpSessionEvent arg0) {
	
			count ++;
			System.out.println("sessionCreated"+count);
			
		}
	
		public void sessionDestroyed(HttpSessionEvent arg0) {
	
			count--;
			System.out.println("sessionDestroyed"+count);
		}
	
	}
 在web.xml中声明此类
- 
	<listener>
	    <listener-class>Listener.ListenerDemo</listener-class>
	</listener>