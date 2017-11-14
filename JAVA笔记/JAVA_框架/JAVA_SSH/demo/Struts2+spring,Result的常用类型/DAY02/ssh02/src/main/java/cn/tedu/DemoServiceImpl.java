package cn.tedu;

import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl 
				implements DemoService{

	public void hello(){
		System.out.println("Hello Service!!!");
	}
}
