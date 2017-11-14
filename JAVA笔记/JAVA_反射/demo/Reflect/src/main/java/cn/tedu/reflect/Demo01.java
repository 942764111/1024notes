package cn.tedu.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) 
		throws ClassNotFoundException,
			InstantiationException, 
			IllegalAccessException, 
			NoSuchFieldException, 
			SecurityException{
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名:");
		String className=in.nextLine();
		Class cls = Class.forName(className);
		System.out.println(cls);
		Object obj = cls.newInstance();
		System.out.println(obj);
		
		//找到属性声明信息
		System.out.print("属性名:");
		String name = in.nextLine();
		//动态找到属性声明信息
		Field fld = cls.getDeclaredField(name);
		System.out.println(fld); 
		//读取对象的属性: 在一个对象上读取属性的值
		
		//打开访问权限
		fld.setAccessible(true);
		
		Object val = fld.get(obj);
		System.out.println(val); 
		
		//Foo foo = new Foo();
		//foo.
		
		//反射类的全部属性
		Field[] fields=
			cls.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		//反射类的全部方法
		Method[] methods=
			cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method); 
		}
	}
}









