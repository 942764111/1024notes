javax.servlet.http
##HttpServlet抽象类


- java.lang.object
- javax.servlet.GenericServlet
- javax.servlet.http.HttpServlet
##实现接口:
java.io.Serializable, Servlet, ServletConfig

##公共抽象类HttpServlet
- 扩展GenericServlet
- 提供了一个抽象类派生子类来创建一个HTTP servlet适合一个网站。HttpServlet的子类必须覆盖至少有一个方法,通常其中一个:
- doGet,如果servlet支持HTTP GET请求
- doPost,HTTP POST请求
- doPut,HTTP PUT请求
- doDelete HTTP DELETE请求
- 初始化和销毁,管理资源servlet的生活
- getServletInfo,servlet使用提供的信息本身
- 几乎没有理由覆盖的服务方法。服务处理标准HTTP请求派遣他们每个HTTP请求的处理程序方法类型(上述doMethod方法)。
- 同样,几乎没有理由覆盖doOptions和doTrace方法。
- servlet通常运行在多线程的服务器,所以请注意,一个servlet必须处理并发请求和小心对共享资源的同步访问。共享资源包括内存数据,如实例或  
- 类变量和外部对象(如文件、数据库连接和网络连接。有关更多信息,请参见Java多线程编程教程在Java程序中处理多个线程。
- 作者:
- Various
- 参见:
- Various(序列化形式)


##构造函数的总结
##1、HttpServlet()
什么也不做,因为这是一个抽象类。
##2、protected void	doDelete(HttpServletRequest req, HttpServletResponse resp)
由服务器(通过服务方法)允许servlet处理DELETE请求。
##3、protected void	doGet(HttpServletRequest req, HttpServletResponse resp)
由服务器(通过服务方法)允许一个servlet来处理GET请求。
##4、protected void	doHead(HttpServletRequest req, HttpServletResponse resp)
从受保护的服务方法接收HTTP HEAD请求和处理该请求。
##5、protected void	doOptions(HttpServletRequest req, HttpServletResponse resp)
由服务器(通过服务方法)允许servlet请求处理选项。
##6、protected void	doPost(HttpServletRequest req, HttpServletResponse resp)
由服务器(通过服务方法)允许一个servlet来处理POST请求。
##7、protected void	doPut(HttpServletRequest req, HttpServletResponse resp)
由服务器(通过服务方法)允许servlet处理PUT请求。
##8、protected void	doTrace(HttpServletRequest req, HttpServletResponse resp)
由服务器(通过服务方法)允许servlet处理跟踪请求。
##9、protected long	getLastModified(HttpServletRequest req)
返回HttpServletRequest对象最后修改的时间,以毫秒为单位自1970年1月1日午夜。
##10、protected void	service(HttpServletRequest req, HttpServletResponse resp)
接收来自公共服务标准的HTTP请求方法并将它们分派到doMethod在这个类中定义的方法。
##11、void service(ServletRequest req, ServletResponse res)
将客户端请求保护的服务方法。

##javax.servlet.GenericServlet方法继承类
destroy, getInitParameter, getInitParameterNames, getServletConfig, getServletContext, getServletInfo, getServletName, init, init, log, log
##方法java.lang.object继承类
clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait