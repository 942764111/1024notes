#功能注解demo


- package annotations;

- import javax.annotation.PostConstruct;
- import javax.annotation.PreDestroy;

- import org.springframework.context.annotation.Lazy;
- import org.springframework.context.annotation.Scope;
- import org.springframework.stereotype.Component;

- @Component("stu1")//默认beanid为小写开头的类名
- @Scope("prototype")//默认作用域是 单例："singlenton"
- @Lazy(true)

 public class Student {  
 
	public Student() {
		System.out.println("Student()");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init()");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("destroy()");
	}
}

