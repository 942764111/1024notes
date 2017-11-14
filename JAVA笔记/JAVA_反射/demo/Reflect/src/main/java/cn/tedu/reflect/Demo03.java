package cn.tedu.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo03 {

	public static void main(String[] args) 
		throws Exception{
		//JUnit 4 原型
		Scanner in = new Scanner(System.in);
		System.out.print("类名:");
		String className = in.nextLine();
		//Class 是反射的入口
		Class cls = Class.forName(className);
		//找到类中全部的方法
		Method[] methods = 
			cls.getDeclaredMethods();
		Object obj = cls.newInstance();
		
		for (Method method : methods) {
			//动态解析注解
			Object a = method
				.getAnnotation(Test.class);
			System.out.println(a); 
			if(a!=null){
				method.invoke(obj);
			}
		}
	}

}



