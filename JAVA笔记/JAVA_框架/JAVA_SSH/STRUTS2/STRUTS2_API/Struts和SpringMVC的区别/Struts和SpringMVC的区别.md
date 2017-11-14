#session的使用

session就是一个会话对象，共享数据。

##session注入：

1、Action类实现接口sessionAware

2、声明属性session 
   private Map<String,Object> session

3、调用session方法

面试题推荐：

1、Struts是类级别的拦截，springmvc是方法级别的拦截

2、springmvc方法是独立，方法之间不共享数据；Struts方法是独立，但Action变量是共享的。

3、Struts中为了保证线程安全问题，每一个请求都创建一个Action类，比较消耗内存。

4、Struts2拦截器采用interceptor机制；springmvc采用AOP方式实现。

5、springmvc与spring几乎无缝整合的；Struts2管理相对复杂。