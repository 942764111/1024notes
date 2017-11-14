#正课内容

Struts2+spring/Result的常用类型/拦截器

#servlet与filter

##概念：

servlet：运行在服务器的程序，可以动态生成web页面

filter：一段可以复用的代码，不能产生请求和响应，但可以对其进行处理

##生命周期：

servlet：web服务器启动或接收到请求时，初始化；对每次请求调用doGet()或doPost();停止服务器时，调用destroy()销毁实例。

filter：服务器启动时直接加载过滤器；每次请求都会调用doFilter();停止服务器时调用destroy()销毁实例；

#面试题：

##为什么编码?

服务器内存中char是16位的(比较大)，网络传输单位8位的byte（比较小），我们必须对内存中的数据进行拆分，才能传输，拆分的过程叫做编码。

##描述utf-8和gbk的特点？

UTF-8是国际化的最优方案，可表示10万+，中文占3个字节

GBK是本土的最优方案，可表示2万+ ，中文占2个字节


#Struts2+spring整合

##为什么要整合Spring？

通过Spring管理组件，实现注入。


##如何整合？

1、导包：Struts2-spring-plugin.jar

2、配置文件:web.xml spirng-*.xml struts.xml

##案例：HelloWorld

1、创建项目-导包：Struts2-core2.3.8 Struts2-spring-plugin 2.3.8

2、配置web.xml spring-context.xml struts.xml

3、实现Action 注入service

##注解回顾：

@Component ：通用，不推荐

@Controller：作用于表现层bean

@Service ：作用于业务层bean

@Repository：作用于持久层

@Resource ：通知Spring需要注入

#Result的常用类型

##什么是？结果，服务器处理后的结果。处理结果的组件。

##常用类型：

dispatcher：转发（默认）

redirectAction：重定向Action

redirect：重定向URL

stream：流，处理图片或下载

json  ：处理ajax请求 Struts2-json-plugin


###redirectAction

    语法：
    <result name="" type="redirectAction">hello</result>
    或
    <result name="" type="redirectAction">
    	<param name="namespace">/demo</param>
    	<param name="actionName">hello</param>
    </result>

###redirect

    语法：
    <result type="redirect">
    	http://doc.tedu.cn
    </result>
    或
    <result type="redirect">
    	<param name="location">
    			http://doc.tedu.cn
    	</param>
    </result>

处理请求时，默认调用execute()方法。当需要指定具体方法时，

可以通method属性实现。

案例：switchAction
    
###stream

    语法：
    <result name="success" type="stream">
       <param name="contentType">image/jpeg</param>
       <param name="inputName">imageStream</param>
       <param name="contentDisposition">attachment;filename="document.pdf"</param>
       <param name="bufferSize">1024</param>
    </result>

###json

    语法：
	返回Action的所有属性
    <result type="json"></result>
    或
	返回指定的Action属性
    <result type="json">
    	<param name="root">
    		value
    	</param>
    </result>

#作业

1、Struts2+spring环境搭建

2、result类型练习（redirectAction/json）










