package cn.tedu.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo02 {
	public static void main(String[] args)
		throws Exception{
		Scanner in = new Scanner(System.in);
		//动态加载类
		System.out.print("输入类名:");
		String className=in.nextLine();
		Class cls = Class.forName(className);
		System.out.println(cls);
		
		//动态创建对象
		Object obj = cls.newInstance();
		System.out.println(obj);
		
		//动态找到一个方法
		System.out.print("方法名:");
		String name=in.nextLine();
		Method m=cls.getDeclaredMethod(name);
		System.out.println(m); 
		
		//动态执行方法
		m.setAccessible(true);//访问私有
		Object val = m.invoke(obj);
		System.out.println(val);
		
	}

}






