package web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener 
	implements ServletRequestListener,
	ServletRequestAttributeListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("销毁request");
	}

	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("创建request");
		System.out.println(e.getServletRequest());
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("向request中增加数据");
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		
	}

}








