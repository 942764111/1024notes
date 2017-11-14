刘雪松 liuxs@tedu.cn

#SSH是什么？

STRUTS2+SPRING+HIBERNATE

DAY01 STRUTS2简介/消息传递/session使用

DAY02 SPRING+STURTS2/RESULT常用类型/拦截器

DAY03 VALUESTACK值栈/STRUTS2+SPRING+mybatis/hibernate简介

DAY04 ID生成规则/对象生命周期的管理/HQL查询

DAY05 STRUTS2+SPRING+HIBERNATE

#Struts2简介

1- Struts2 apache基金会产品

2- Struts1和Struts2没有任何关系

3- Struts2的前身是webwork

4- Struts1和Struts2都是MVC设计模式

##Struts2作用？

作用于表现层

1、将浏览器数据发送给服务器

2、将服务器处理后的数据以一定的格式返回给客户端

##什么时候用？
替代springmvc框架时使用


##如何使用？
1、导包（Struts2-core 2.3.8）

2、配置文件（web.xml/struts.xml）

3、使用

##Struts标签

    匹配请求路径
    <package namespace="" extends="">
    
    匹配具体请求
    <action name="" class=""></action>
    
    匹配结果处理
    <result name="success"></result>
    
    </package>

##HelloWorld案例

步骤：

1、创建项目-导包

2、配置文件-web.xml/struts.xml

3、实现处理类

4、jsp实现

#消息传递机制

##什么是？

浏览器与服务器之间的数据传递

##什么时候？

浏览器与服务器端发生请求与处理的时候。

##如何实现？

###由Action向浏览器传递数据

实现步骤：

1、在Action类中，增加属性，设置get()方法

2、Action类的方法中，给属性赋值

3、JSP页面中通过EL表达式获取属性值


###由浏览器向服务器传递数据

####基本属性传递方式

1、控制器中声明与html表单项name属性一致的bean属性

2、设置属性的set方法

案例：登录功能

####域模型属性传递方式

优点：处理表单项目时比较便捷，特别是表单重用时更明显

案例：登录功能

1、获取表单信息
2、调用业务层，验证登录信息
3、登录成功，保存信息到session
4、登录失败，提示重新登录

#session的使用

session就是一个会话对象，共享数据。

##session注入：

1、Action类实现接口sessionAware

2、声明属性session 
   private Map<String,Object> session

3、调用session方法

面试题推荐：

1、Struts是类级别的拦截，springmvc是方法级别的拦截

2、springmvc方法是独立，方法之间不共享数据；Struts方法是独立，但     Action变量是共享的。

3、Struts中为了保证线程安全问题，每一个请求都创建一个Action类，比较消耗内存。

4、Struts2拦截器采用interceptor机制；springmvc采用AOP方式实现。

5、springmvc与spring几乎无缝整合的；Struts2管理相对复杂。

#作业：

1、通过基本属性传递方式实现登录功能

2、通过域模型属性传递方式实现登录功能（session）





















