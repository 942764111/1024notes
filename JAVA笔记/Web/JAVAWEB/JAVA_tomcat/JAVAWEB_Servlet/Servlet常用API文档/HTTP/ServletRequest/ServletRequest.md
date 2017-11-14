javax.servlet
##接口ServletRequest


##所有已知种子接口:
- HttpServletRequest
##所有已知实现类:
- HttpServletRequestWrapper,ServletRequestWrapper


##公共接口ServletRequest
- 定义一个对象提供一个servlet客户端请求信息。servlet容器创建一个ServletRequest对象并将它作为参数传递到servlet的服务方法。
- ServletRequest对象提供数据包括参数名和值,属性和一个输入流。
- 接口扩展ServletRequest可以提供额外的特定于协议的数据(例如,HTTP HttpServletRequest提供的数据。
- 作者:
- Various
- 参见:
- HttpServletRequest

##方法总结
##1、AsyncContext	getAsyncContext()
- 获取当前异步上下文
##2、java.lang.Object	getAttribute(java.lang.String name)

返回指定属性的值是一个对象,如果没有名字的属性存在返回null。

- <div class="bg-blue">例：</div>

----------
[点击查看](file:///C:/Users/QiaoBin/Desktop/JAVA%E7%AC%94%E8%AE%B0/Web/JAVAWEB/JAVAWEB_Servlet/Servlet%E5%B8%B8%E7%94%A8API%E6%96%87%E6%A1%A3/HTTP/ServletRequest/demo/Attribute/Attribute.html)

##3、java.util.Enumeration<java.lang.String>	getAttributeNames()
返回一个枚举包含此请求可用的属性的名称。
##4、java.lang.String	getCharacterEncoding()
返回字符编码的名称中使用此请求的身体。
##5、int	getContentLength()
请求的返回长度,以字节为单位,身体和可用的输入流,如果长度是未知的返回-1。
##6、java.lang.String	getContentType()
返回的MIME类型的请求,如果类型是未知的返回null。
##7、DispatcherType	getDispatcherType() 
- 返回:
- TODO
- 自:
- Servlet 3.0 TODO SERVLET3 - Add comments
##8、ServletInputStream	getInputStream()
检索请求的主体使用ServletInputStream二进制数据。
##9、java.lang.String	getLocalAddr()
地址接口收到的请求返回的互联网协议(IP)地址
##10、java.util.Locale	getLocale()
返回首选区域设置。接受客户的地区基于accept - language头。
##11、java.util.Enumeration<java.util.Locale>	getLocales()
返回一个Locale对象的枚举指示,减少订单开始首选区域设置,接受客户的地区基于accept - language头。
##12、java.lang.String	getLocalName()
返回的主机名互联网协议(IP)接口收到的请求。
##13、int	getLocalPort()
返回的互联网协议(IP)端口号的接口请求被接受。
##14、java.lang.String	getParameter(java.lang.String name)
返回一个请求参数的值是一个字符串,或null如果参数不存在。
- <div class="bg-blue">例：</div>

----------
[点击查看](file:///C:/Users/QiaoBin/Desktop/JAVA%E7%AC%94%E8%AE%B0/Web/JAVAWEB/JAVAWEB_Servlet/Servlet%E5%B8%B8%E7%94%A8API%E6%96%87%E6%A1%A3/HTTP/ServletRequest/demo/getParameter/getParameter.html)
##15、java.util.Map<java.lang.String,java.lang.String[]>	getParameterMap()
返回一个java.util.map。这个是请求的参数的map。
##16、java.util.Enumeration<java.lang.String>	getParameterNames()
- 返回一个java.util.map。这个请求的参数的地图。请求参数是额外的信息发送的请求。HTTP servlet,参数中包含查询字符串或发布表单数据。
- 返回:
- 一个不可变的java.util.map。地图包含参数名称作为键和参数值映射值。参数映射的键类型的字符串。参数映射中的值是字符串数组的类型。
##17、java.lang.String[]	getParameterValues(java.lang.String name)
- 返回字符串对象的数组,其中包含的所有值给定的请求参数,或null如果参数不存在。
- 如果参数有一个值,数组的长度为1。
- 参数:
- 名称——一个字符串包含请求参数的值的名称
- 返回:
- 一个字符串对象数组,包含参数的值
- 参见:
- getParameter(以)
##18、java.lang.String getProtocol()
- 返回请求使用的协议的名称和版本协议/ majorVersion。例如,minorVersion HTTP / 1.1。对于HTTP servlet,返回的值是一样的价值- - - - SERVER_PROTOCOL CGI变量。
- 返回:
- 一个字符串包含协议的名称和版本号
##19、java.lang.String getScheme()
- 回报方案用于制造该请求的名称,例如,http、https、ftp。不同的项目有不同的规则构造url,在RFC 1738。
- 返回:
- 一个字符串包含的名称方案用于制造此请求
##20、java.lang.String getServerName()
- 返回一个字符串包含的名称服务器
##21、int getServerPort()
- 一个整数返回指定端口号
##22、java.io.BufferedReader getReader()
                                 throws java.io.IOException
- 读者将字符数据根据身体上使用的字符编码检索请求的主体使用BufferedReader字符数据。
- 返回:
- 一个包含请求的身体BufferedReader
- 抛出:
- . io .UnsupportedEncodingException——如果不支持使用的字符集编码和文本不能解码
- . lang。IllegalStateException——如果getInputStream()方法被称为这个请求
- . io .IOException。如果一个输入或输出异常发生
- 参见:
- getInputStream()
##23、java.lang.String getRemoteAddr()
- 返回的互联网协议(IP)地址的客户或代理发送请求。对于HTTP servlet、REMOTE_ADDR CGI变量的值一样。
- 返回:
- 一个字符串包含客户机的IP地址,发送请求
##24、java.lang.String getRemoteHost()
- 返回客户机的完全限定名称或最后代理发送请求。如果发动机不能或选择不解决主机名(以提高性能),该方法返回的dotted-string形式IP地址。对于HTTP servlet、REMOTE_HOST CGI变量的值一样。
- 返回:
- 一个字符串包含客户机的完全限定名称

##25、void setAttribute(java.lang.String name,java.lang.Object o)
- 将一个属性存储在此请求。属性重置请求之间。这种方法通常是用RequestDispatcher结合使用。
- 属性名称应遵循相同的约定包名称。开始与java名称。*、javax。*,com.sun。*,是由Sun Microsystems保留使用。
- 如果传入的对象是null,效果是一样的叫removeAttribute(以)。
- 是警告说,当从servlet请求派出由RequestDispatcher驻留在一个不同的web应用程序,这种方法可能不是正确的对象检索调用servlet。
- 参数:
- 名称——一个字符串指定属性的名称
- o -这是对象存储
##26、void removeAttribute(java.lang.String name)
- 从这个请求删除一个属性。这种方法一般不需要作为属性只有坚持只要请求正在处理。
- 属性名称应遵循相同的约定包名称。开始与java名称。*、javax。*,com.sun。*,是由Sun Microsystems保留使用。
- 参数:
- 名称—— 一个字符串指定属性的名称删除
##27、java.util.Locale getLocale()
- 返回首选区域设置,客户会接受的内容,基于accept - language头。如果客户机请求不提供一个accept - language头,该方法返回的默认语言环- 境服务器。
- 返回:
- 为客户机首选区域设置
##28、java.util.Enumeration<java.util.Locale> getLocales()
- 返回一个Locale对象的枚举指示,减少订单开始首选区域设置,接受客户的地区基于accept - language头。如果客户机请求不提供一个accept - - language头,这个方法返回一个枚举包含一个语言环境,服务器的缺省语言环境。
- 返回:
- 为客户机首选区域设置对象的枚举
##29、boolean isSecure()
- 返回一个布尔值表示这个请求是否通过一个安全通道,比如HTTPS。
- 返回:
- 一个布尔值表示如果请求使用一个安全的通道
##30、RequestDispatcher getRequestDispatcher(java.lang.String path)
- 返回一个RequestDispatcher对象作为包装器的资源位于给定的路径。RequestDispatcher对象可以用来请求转发给资源或资源包含在响应。可以- 动态或静态的资源。
- 指定的路径名可能是相对的,虽然外面不能扩展当前servlet上下文。如果路径以“/”开头,解释为相对于当前上下文根。这个方法返回null如果 
- servlet容器不能返回一个RequestDispatcher。
- 这种方法的区别和ServletContext.getRequestDispatcher(以),该方法可以相对路径。
- 参数:
- 路径——指定路径名字符串资源。如果它是相对的,它必须是相对与当前servlet。
- 返回:
- RequestDispatcher对象作为包装器的资源在指定的路径,或null如果servlet容器不能返回一个RequestDispatcher
- 参见:
- RequestDispatcher ServletContext.getRequestDispatcher(以)

- <div class="bg-blue">例：</div>

----------
[点击查看](file:///C:/Users/QiaoBin/Desktop/JAVA%E7%AC%94%E8%AE%B0/Web/JAVAWEB/JAVAWEB_Servlet/Servlet%E5%B8%B8%E7%94%A8API%E6%96%87%E6%A1%A3/HTTP/ServletRequest/demo/Attribute/Attribute.html)
##31、java.lang.String getRealPath(java.lang.String path)
- 弃用。Java Servlet API的2.1版本,使用ServletContext.getRealPath(以)。
- 参数:
- 路径——虚拟路径被转换成一个真正的路径
- 返回:
- ServletContext.getRealPath(字符串)
##32、int getRemotePort()int getRemotePort()
- 返回互联网协议(IP)客户端或最后的源端口代理发送请求。
- 返回:
- 一个整数指定端口号
- 自:
- 2.4
##33、java.lang.String getLocalName()
- 返回的主机名互联网协议(IP)接口收到的请求。
- 返回:
- 一个字符串包含的主机名的IP请求被接受。
- 自:
- 2.4
##34、java.lang.String getLocalAddr()
- (IP)地址接口收到的请求。
- 返回:
- 一个字符串包含接收请求的IP地址。
- 自:
- 2.4
##35、int getLocalPort()
- 返回的互联网协议(IP)端口号的接口请求被接受。
- 返回:
- 一个整数指定端口号
- 自:
- 2.4
##36、ServletContext getServletContext()
- 返回:
- 待办事项
- 自:
- Servlet 3.0 TODO SERVLET3——添加评论
##37、AsyncContext startAsync()
- 返回:
- 待办事项
- 抛出:
- . lang。IllegalStateException——如果不支持异步请求
- 自:
- Servlet 3.0 TODO SERVLET3——添加评论
##38、AsyncContext startAsync(ServletRequest servletRequest,ServletResponse servletResponse)
- 参数:
- servletRequest——servletRequest来初始化异步上下文
- servletResponse——servletResponse来初始化异步上下文
- 返回:
- 待办事项
- 抛出:
- . lang。IllegalStateException——如果不支持异步请求
- 自:
- Servlet 3.0 TODO SERVLET3——添加评论
##39、boolean isAsyncStarted()
- 返回:
- 待办事项
- 自:
- Servlet 3.0 TODO SERVLET3——添加评论
##40、boolean isAsyncSupported()
- 返回:
- TODO
- 自:
- Servlet 3.0 TODO SERVLET3——添加评论
##41、AsyncContext getAsyncContext()
- 获取当前AsyncContext（异步上下文）。
- 返回:
- 当前AsyncContext（异步上下文）
- 抛出:
- . lang。IllegalStateException——如果没有在异步请求模式(即@link # isAsyncStarted()是假的)
- 自:
- Servlet 3.0
##42、DispatcherType getDispatcherType()
返回:
待办事项
自:
Servlet 3.0 TODO SERVLET3——添加评论