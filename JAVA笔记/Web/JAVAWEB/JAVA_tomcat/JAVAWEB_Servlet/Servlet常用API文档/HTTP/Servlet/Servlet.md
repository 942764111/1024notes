javax.servlet
## Servlet接口


##所有已知实现类:
### GenericServlet,HttpServlet


##公共接口Servlet
- 定义了所有servlet必须实现的方法。
- servlet是一个小的Java程序运行在一个Web服务器。
- servlet接收并响应来自Web客户端的请求,通常在HTTP、超文本传输协议。
- 要实现这个接口,您可以编写一个通用的servlet javax.servlet。
- 扩展javax.servlet.http.HttpServlet GenericServlet或一个HTTP servlet。
- 这个接口定义了方法来初始化一个servlet,服务请求,并从服务器删除servlet。
- 这些被称为生命周期方法和被称为在下列顺序:
- servlet构造,然后用init初始化方法。
- 任何来自客户机的调用服务方法处理。
- servlet的服务,然后摧毁了销毁方法,垃圾收集和完成。
- 除了生命周期方法,该接口提供了getServletConfig方法,servlet可以使用它来得到任何启动信息,和getServletInfo方法,它允许servlet返回自身的基本信息,比如- - 作者、版本和版权。

参见:
GenericServlet,HttpServlet

#Method Summary
## void	destroy()
由servlet容器来表示一个servlet调用servlet被服务。
##ServletConfig	getServletConfig()
返回一个ServletConfig对象,其中包含初始化这个servlet和启动参数。
##java.lang.String	getServletInfo()
servlet返回信息,比如作者、版本和版权。
##void	init(ServletConfig config)
由servlet容器来表示一个servlet调用servlet被放置在服务。
##void	service(ServletRequest req, ServletResponse res)
由servlet容器允许调用servlet响应一个请求。