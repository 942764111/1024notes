#拦截器

##什么是？

java动态拦截Action调用的对象

##为什么？

适用于封装共同的处理，通过配置进行调用，比较灵活。

请求——>Filter——>拦截点——>Action——>拦截点——>result——>响应

##怎么实现？

1、创建拦截器（类）

2、注册拦截器（struts.xml-<package>）

3、引用拦截器（struts.xml-<Action>）


###编写拦截器组件原则：

1、实现Interceptor接口

2、在约定的方法中实现拦截功能

###注册拦截器：

    <interceptors>
    <interceptor name="demo" class="cn.tedu.DemoInterceptor" />
    </interceptors

###引用拦截器：

<interceptor-ref name="demo" />

Struts2中默认引用拦截器栈，一旦我们设置了任何拦截器，该栈就失效了。


VALUESTACK值栈/STRUTS2+SPRING+mybatis/hibernate简介

#ValueStack 

##是什么？

值栈 Struts中共享数据的数据结构 

##为什么？

1、由控制器向浏览器传递数据

2、用于存储对象数据

##值栈结构

1、Contents 栈结构   存储值

2、Context  Map结构  存储对象数据

##值栈访问方式

ONGL:Object navigation grapyics language 对象图导航语言
/EL

Contents:由栈顶逐一向下遍历

Context：#key

##生命周期

请求进入到服务器的Filter以后，创建ValueStac对象。请求处理结束，

ValueStac对象被销毁。

案例：展示ValueStack

#STRUTS2+SPRING+mybatis

案例：环境搭建

1、创建项目-导包

2、配置文件：web.xml spring-context spring-mybatis struts.xml

3、测试

    create table user(id int primary key,name varchar(20))
    
    insert into user values(1,'Jackson');

案例：登录功能

    create table user_pwd(id int,name varchar(20),password varchar(20))
    
    insert into user_pwd values(1,'zhangsan','123456')


#hibernate简介

##是什么？

不需要写SQL语句的数据库框架。

Gavin king  其想法将java中的实体对象映射并存储到数据库表中。只需要定

义好实体对象与数据库的关系。框架会根据映射关系自动生成SQL语句。

#如何使用？

1、导包：hibernate-core

2、hibernate主配置文件

3、hibernate映射文件

4、调用API实现对数据库的访问


#作业：

1、拦截器案例的实现：
- 创建拦截器
- 注册拦截器
- 引用拦截器
- 拦截器栈的使用

2、hibernate案例的实现
- 导包(hibernate-core)
- 配置文件（hibernate.cfg.xml User.hbm.xml）
- 创建测试类
















