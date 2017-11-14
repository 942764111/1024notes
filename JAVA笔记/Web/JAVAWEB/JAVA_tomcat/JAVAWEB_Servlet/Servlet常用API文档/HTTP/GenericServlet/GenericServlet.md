javax.servlet
##公共抽象类GenericServlet


- java.lang.object
- javax.servlet.GenericServlet
- 实现接口:
- ServletConfig java.io.Serializable,Servlet
- 已知子类:
- HttpServlet

----------
##<div class="bg-blue">例：</div>
- [点击查看子类继承例子](../GenericServlet/demo/GenericServlet.html)

----------

- 公共抽象类GenericServlet
- 扩展了java . lang . object
- 实现了Servlet，ServletConfig，java.io.Serializable
- 定义了一个通用的、独立于协议的servlet。
- 写一个HTTP servlet在Web上使用,扩展HttpServlet来代替。
- GenericServlet实现Servlet和ServletConfig接口。
- GenericServlet可能直接延长一个servlet,不过更常见的扩展HttpServlet等特定于协议的子类。
- GenericServlet使得编写servlet变得更加容易。
- 它提供了简单的版本的生命周期方法初始化和销毁,在ServletConfig接口的方法。GenericServlet还实现了日志方法,在ServletContext接口中声明。
- 编写一个通用的servlet,您只需要重写抽象的服务方法。
- 参见:
- Serialized Form(序列化形式)

#Constructor Summary(构造函数的总结)
##1、GenericServlet()
- Does nothing(什么也不做)
#Method Summary(方法总结)
##1、public void destroy()
- 结束摧毁Servlet方法
##2、java.lang.String	getInitParameter(java.lang.String name)
- 返回一个字符串,其中包含指定的初始化参数的值,或null如果参数不存在。
##3、java.util.Enumeration<java.lang.String>	getInitParameterNames()
- 返回servlet的名称作为枚举字符串对象的初始化参数,或一个空枚举如果servlet没有初始化参数。
##4、ServletConfig	getServletConfig()
- 返回这个servlet的ServletConfig对象。
##5、ServletContext	getServletContext()
- 返回这个servlet的ServletContext对象。
##6、java.lang.String	getServletInfo()
- servlet返回信息,比如作者、版本和版权。
##7、java.lang.String	getServletName()
- 返回这个servlet实例的名称。
##8、public void init()
          throws ServletException
- Servlet初始化方法
- 方便可以覆盖方法,没有必要叫super.init(配置)。
- 而不是覆盖init(ServletConfig),只需覆盖这个方法,它会被称为GenericServlet.init(ServletConfig配置)。
- ServletConfig对象仍然可以通过检索getServletConfig()。
- 抛出:
- ServletException——如果发生异常中断servlet的正常运行
##9、public void init(ServletConfig config)
          throws ServletException
- 由servlet容器来表示一个servlet调用servlet被放置在服务。看到Servlet.init(javax.servlet.ServletConfig)。
- 这个实现存储ServletConfig对象接收从servlet容器供以后使用。当覆盖这种形式的方法,调用super.init(配置)。
- 规定:
- 在界面初始化Servlet
- 参数:
- 配置——ServletConfig对象包含这个servlet的配置信息
- 抛出:
- ServletException——如果发生异常中断servlet的正常运行
- 参见:
- UnavailableException
##10、public void log(java.lang.String msg)
- 写到指定的消息一个servlet日志文件,按servlet的名称。看到ServletContext.log(字符串)。
- 参数:
- log——一个字符串指定消息写入到日志文件中
##11、public void log(java.lang.String message,
       java.lang.Throwable t)
- 按servlet的名称写一个解释性消息和堆栈跟踪给定Throwable异常servlet日志文件。看到ServletContext.log(字符串)。
- 参数:
- 消息——一个字符串描述错误或异常
- t - 可抛出错误或异常
##12、public abstract void service(ServletRequest req,
           ServletResponse res)
                      throws ServletException,
                             java.io.IOException
- 由servlet容器允许调用servlet响应一个请求。看到Servlet.servic(javax.servlet.ServletRequest ,javax.servlet.ServletResponse)。
- 此方法声明为抽象子类,如HttpServlet,必须覆盖它。
- 规定:
- 服务接口Servlet
- 参数:
- req——ServletRequest对象包含客户机的请求
- res——ServletResponse对象将包含servlet的响应
- 抛出:
- ServletException——如果发生异常干扰servlet的正常运行
- . io .IOException。如果一个输入或输出异常发生
