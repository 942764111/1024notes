#一、指定初始化方法和销毁方法：

##1、init-method
- 属性：指定初始化方法。
- 参数：init-method="init" (init为类中的方法名)
- 容器在创建好对象之后，会立即调用初始化方法。
##2、destroy-method
- 属性：指定销毁方法。
- 参数：destroy-method="destroy" (destroy为类中的方法名)
- 容器在关闭之前，会销毁它所管理的对象,此时，会调用 销毁方法。
- <div class="bg-blue">销毁方法只有在作用域为单例时有效。

##3、lazy-init="boolean"。
- 属性：延时加载
- 参数：boolean值
 
	- a. 默认情况下，容器启动之后，会将所有作用域为单例的bean先创建 出来。
	
	- b. 延迟加载指的是，容器启动之后，对于这些作用域为单例的bean 不再创建了。
 
- <div class="bg-blue">注:直到调用getBean方法时才会创建。

##4、scope="prototype"
- 属性：
	- 指定作用域默认是单例
- 参数：
	- scope属性的缺省值是"singleton"(单例),prototype(多例)

<div class="bg-blue">例：</div>
[点击查看](demo/创建,销毁,作用域/InitXmlTest.html)‘

----------
#二、依赖注入


##1、property name="b" ref="b1"
- 属性：(手动装配)
	- property注入set方法
- 参数：
	- name----set后的方法名容器会自动调用此类中set方法（set属性名）
	- ref----调用有依赖关系的类 参数为beanID	
<div class="bg-blue">例：</div>
[点击查看](../Spring简介/demo/DIDemo/DIDemo.html)
##2、constructor-arg  index = "0" ref="beanID" 
- 属性：(手动装配)
	- (手动装配)就是让容器手动建立依赖关系
	- 使用constructor-arg元素配置构造器注入
- 参数：
	- index----构造器中参数位置的下标
	- ref----调用有依赖关系的类 参数为beanID		   
<div class="bg-blue">例：</div>
[点击查看](demo/constructor-arg/constructor-arg.html)			   
##3、autowire ="byName" 或 byType
- 属性：(自动装配)就是让容器自动建立依赖关系
	- 1. 默认情况下，容器不会自动装配(即不会自动建立依赖关系)。
	- 2. 通过指定autowire属性值，让容器依据某些规则，自动建立 依赖关系。
- 注意：底层依然使用set方法或者构造器来建立依赖关系。
- 参数：
-	 byName : 
	-	 1、容器依据属性名查找对应的bean id,
	-	 2、找到之后,会调用对应的set方法,
	-	 3、如果byName找不到容器中对应的set方法返回null.
-	 byType:
	-		1、容器依据属性类型查找对应的bean class类型
	-		2、找到之后,会调用对应的set方法
	-		3、如果byType找不到容器中beam 对应的属性class类型为返回null.
	-		4、如果找到多个,报错因为byType找的class类型对象只能唯一.
-  constructor:类似于byType,
<div class="bg-blue">例：</div>
[点击查看](demo/autowire/autowire.html)

----------

#三、注入基本类型的值 
##1、property name="name" value="仓松"
- 属性：
	- 注入基本类型的值 
- 参数：
	- name：调用 class中 set方法
	- value：给set方法赋值

- #3.1、注入集合类型的值 
##1、List
	 	<property name="list" >
	 		<list>
	 			<value>^_^</value>
	 			<value>o(∩∩)o...哈哈</value>
	 		</list>
	 	</property>
##2、Set
	 	<property name="city" >
	 		<set>
	 			<value>gg</value>
	 			<value>hh</value>
	 			<value>hh</value>
	 		</set>
	 	</property>
##3、Map
	 	<property name="score" >
	 		<map>
				<entry key ="english" value="59.5" />
				<entry key ="null" value="2.0" />
	 		</map>
	 	</property>
##4、props
	 	<property name="db" >
	 		<props>
				<prop key ="null">www</prop>
				<prop key ="uuu">qqq</prop> 
	 		</props>
	 	</property>
- #3.2、引用集合的值(赋值和注入类似)
			 <util:list id="list2">
			 	<value>仍然</value>
			 	<value>童童</value>
			 	<value>应用</value>
			 </util:list>
			 
			 <bean id="vb2" class="Value.ValueBean" >
			 	<property name="list" ref="list2"></property>
			 </bean>
<div class="bg-blue">例：</div>
[点击查看](demo/property/property.html)

----------


#四、读取文件 
##1、读取properties文件
- 属性：
	- 加载文件内容：<util:properties id="config" location="classpath:config.properties"/>
	- 读取内容属性："#{config.id}" 
- 参数：
	- classpath：让spring容器依据类路径来查找properties文件
	

----------

#五、Spring表达式
- (1)作用：
<div class="bg-blue">使用Spring表达式去读取bean的属性值。语法类似于el表达式.</div>
	
##1、#{beanid.getXX()}
- 参数：
	- beanid：要读取的beanid
	- getXX()：要读取的属性名(beanid中应该有对应的getXX()方法)
##2、List
- 属性：#{vb1.list[0]}
##3、Map
- 属性：#{vb1.list[0]}
- 说明：
	- 如果访问的map属性中key是中文用
	- #{vb1.score['key']}
	- 因为spring容器只支持 ASCII码

#六、其他
##1、开启注解扫描
<context:component-scan base-package="com.tarena"/>
<div class="bg-blue">注解介绍示例：</div>
[点击查看](demo/property/property.html)