#一、SpringMVC介绍
##(1)SpringMVC是什么?

----------
- Spring框架当中的一个核心模块，
- 是一个用来简化基于MVC架构的 
- web应用程序开发的框架。

----------
##(2)五大组件
- ##DispatcherServlet (前端控制器)

- ##HandlerMapping	(映射处理器)

- ##Controller (处理器)

- ##ModelAndView

- ##ViewResovler　（视图解析器）

<div class="bg-blue">注:

<li>1、DispatcherServlet收到请求之后，依据HandlerMapping的配置， 调用对应的Controller来处理。</li>

<li>2、Controller将处理结果封装成ModelAndView,返回给DispatcherServlet。 </li>

<li>3、DispatcherServlet依据ViewResolver的解析，调用对应的视图 对象(比如某个jsp)来生成相应的页面。 </li>

</div>
- ![](springmvc.png)

----------
#二、SpringMVC编程步骤
##1、导包。
- spring-webmvc。
##2、添加spring配置文件。
- <div class="bg-blue">例：</div>
[点击查看](demo/SpringMVC编程步骤/applicationContext.xml)
##3、配置DispatcherServlet。
- 在web.xml中的配置
- <div class="bg-blue">例：</div>
[点击查看](demo/SpringMVC编程步骤/web.xml)
##4、写Controller。
- 注：Controller负责处理业务逻辑。
- <div class="bg-blue">例：</div>
[点击查看](demo/SpringMVC编程步骤/HelloController.java)
##5、写jsp。
- <div class="bg-blue">例：</div>
[点击查看](demo/SpringMVC编程步骤/hello.jsp)
##6、配置HandlerMapping和ViewResolver。
- <div class="bg-blue">例：</div>
[点击查看](demo/SpringMVC编程步骤/applicationContext.xml)
- <div class="bg-blue">例：</div>
- ![](s1.png)
- ![](s2.png)