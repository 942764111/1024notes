javax.servlet.http
##HttpServletRequest接口


##所有它的超接口:
ServletRequest (Servlet请求)
##所有已知实现类: 
HttpServletRequestWrapper(Http ServletRequest包装)


##公共接口HttpServletRequest
- 扩展ServletRequest
- 扩展了ServletRequest接口提供HTTP servlet的请求信息。
- servlet容器创建一个HttpServletRequest对象并将它作为参数传递给servlet的服务方法(doGet、doPost等)。


##与javax . servlet . servletrequest继承接口的方法
getAsyncContext, getAttribute, getAttributeNames, getCharacterEncoding, getContentLength, getContentType, getDispatcherType, getInputStream, getLocalAddr, getLocale, getLocales, getLocalName, getLocalPort, getParameter, getParameterMap, getParameterNames, getParameterValues, getProtocol, getReader, getRealPath, getRemoteAddr, getRemoteHost, getRemotePort, getRequestDispatcher, getScheme, getServerName, getServerPort, getServletContext, isAsyncStarted, isAsyncSupported, isSecure, removeAttribute, setAttribute, setCharacterEncoding, startAsync, startAsync

##字段汇总
##1、static java.lang.String	BASIC_AUTH
字符串标识符基本身份验证。字符串标识符基本身份验证。
##2、static java.lang.String	CLIENT_CERT_AUTH
客户端证书身份验证字符串标识符。
##3、static java.lang.String	DIGEST_AUTH
摘要式身份验证字符串标识符。
##4、static java.lang.String	FORM_AUTH0
字符串标识符形式认证。

##方法总结
##1、boolean	authenticate(HttpServletResponse response)
触发身份验证过程一样会被触发,如果请求是一个安全约束保护的资源。
##2、java.lang.String	getAuthType()
返回验证方案的名称用于保护servlet。
##3、java.lang.String	getContextPath()
返回请求URI的一部分,表示请求的上下文。

##<div class="bg-blue">例：</div>

----------
http://localhost:8080 /servlet3 /*.duang


- 输出：
##/servlet3
##4、Cookie[]	getCookies()
返回一个数组,其中包含所有的Cookie对象的客户端发送请求。
##5、long	getDateHeader(java.lang.String name)
返回值指定请求头的长值代表一个约会对象.
##6、java.lang.String	getHeader(java.lang.String name)
返回指定的请求头的值为字符串。
##7、java.util.Enumeration<java.lang.String> 	getHeaderNames()
返回一个枚举所有的这个请求包含标题名称。
##<div class="bg-blue">例：</div>

----------

- //1.2消息头(key-value)
- //Enumeration是比Iterator更早的迭代器
- Enumeration<String> e = req.getHeaderNames();
- while(e.hasMoreElements()) {
- String key = e.nextElement();
- String value = req.getHeader(key);
- System.out.println(
- key + ":" + value);
- }

##8、java.util.Enumeration<java.lang.String> 	getHeaders(java.lang.String name)
返回所有指定的请求头的值作为字符串对象的枚举。
##9、int	 getIntHeader(java.lang.String name)
返回指定的请求头的值作为一个int。
##10、java.lang.String	getMethod()
请求方式:返回的HTTP方法的名称,与此请求例如,GET、POST、或PUT。
##11、Part	getPart(java.lang.String name)
被指定的部分或null如果部分并不存在。返回:
指定的部分或null如果部分并不存
##12、java.util.Collection<Part>	getParts()
返回所有上传部分的集合。
##13、java.lang.String	getPathInfo()
返回与URL相关联的任何额外的路径信息时客户端发送此请求。
##14、java.lang.String	getPathTranslated()
- 返回任何额外的路径信息后,servlet名称但在查询字符串,并将它真正的路径。CGI变量的值PATH_TRANSLATED一样。
- 如果URL没有任何额外的路径信息,该方法返回null或servlet容器不能翻译真正的虚拟路径路径由于任何原因(如web应用程序执行时从存档)。
- web容器不解码该字符串。
- 返回:
- 字符串指定的路径,或者零如果没有任何额外的路径信息的URL
##15、java.lang.String	getQueryString()
- 返回一个布尔值表示身份验证的用户是否包含在指定的逻辑“角色”。
- 角色和角色从属关系可以定义使用部署描述符。
- 如果用户还没有经过身份验证,方法返回false。
- 参数：
- 角色——一个字符串指定角色的名称
- 返回：
- 一个布尔提出这种请求指示用户是否属于一个给定角色;假如果用户没有被验证
##16、java.security.Principal getUserPrincipal()
返回一个java.security。主要对象包含当前身份验证的用户的名称。如果用户没有通过身份验证,方法返回null。
##17、java.lang.String getRequestedSessionId()
- 返回会话ID指定的客户端。这可能不是相同的ID的当前有效的会话请求。如果客户没有指定一个会话ID,该方法返回null。
- 返回：
- 一个字符串指定会话ID,或null如果请求没有指定一个会话ID
- 参见：
- isRequestedSessionIdValid()
##18、java.lang.String getRequestURI()
- 返回请求的URL协议的一部分的名字查询字符串的第一行的HTTP请求。web容器不解码该字符串。例如:
- 第一行的HTTP请求返回值
- POST /some/path.html HTTP/1.1	 /some/path.html
- GET http://foo.bar/a.html HTTP/1.0	 /a.html
- HEAD /xyz?a=b HTTP/1.1	 /xyz
- 重建一个URL方案和主机,使用getRequestURL()。
- 返回:
- 一个字符串包含URL的一部分从协议名称查询字符串
- 参见:
- getRequestURL()
##<div class="bg-blue">例：</div>

----------
http://localhost:8080/servlet3/*.duang

- 输出：
## /servlet3/*.duang
##19、java.lang.StringBuffer getRequestURL()
- 塑造URL所使用的客户端请求。返回的URL包含一个协议,服务器名称、端口号和服务器的路径,但它不包含查询字符串参数。
- 因为这个方法返回一个StringBuffer,而不是一个字符串,您可以修改URL,例如,添加查询参数。
- 这个方法是非常有用的用于创建重定向消息和错误报告。
- 返回：
- StringBuffer对象包含重建的URL
- 返回:
- 一个字符串包含URL的一部分从协议名称查询字符串
- 参见:
- getRequestURL()
##<div class="bg-blue">例：</div>

----------
输出：
## http://localhost:8080/servlet3/*.duang
##20、java.lang.String getServletPath()
-返回访问路径
- 返回此请求调用servlet的URL的一部分。这条路开始于一个“/”字符,包括servlet servlet名称或路径,但不包括任何额外的路径信息或查询字- - 符串。一样的值SCRIPT_NAME CGI变量。
- 这个方法将返回空字符串(" ")如果servlet用于处理这个请求匹配使用“/ *”模式。
- 返回:
- 一个字符串包含被调用servlet的名称或路径,在请求URL中指定,解码,或空字符串如果用来处理请求的servlet使用“/ *”模式相匹配。
##<div class="bg-blue">例：</div>

----------
http://localhost:8080/servlet3/*.duang

- 输出：
## /*.duang
##21、HttpSession getSession(boolean create)
- 参数:
- 创造——真正为这个请求创建一个新的会话如果必要;假返回null如果没有当前会话
- 返回:
- 与此请求相关联的HttpSession或null如果创建是假的,没有有效的会话的请求
- 参见:
- getSession()
##22、HttpSession getSession()
- 返回与此相关的当前会话请求,或者如果没有一个会话的请求,创建一个。
- 返回:
- HttpSession与此相关的请求
- 参见:
- getSession(布尔)
##23、boolean isRequestedSessionIdValid()
检查请求的会话ID是否仍然有效。
##24、boolean isRequestedSessionIdFromCookie()
- 检查是否请求的会话ID是一个cookie。
- 返回:
- 如果会话ID是一个cookie;否则,假的
- 参见:
- getSession(布尔)
##25、boolean isRequestedSessionIdFromURL()
- 检查是否请求的会话ID作为请求URL的一部分。
- 返回:
- 如果会话ID进来作为URL的一部分;否则,假的
- 参见:
- getSession(布尔)
##26、boolean isRequestedSessionIdFromUrl()
弃用。java servlet api的2.1版本,使用isrequestedsessionidfromurl()。
##27、boolean authenticate(HttpServletResponse response)
                    	throws java.io.IOException,
                            ServletException
- 如果用户成功地验证,如果不是假的
- 抛出:
- java.io.IOException
- ServletException
- 自:
- Servlet 3.0

##28、void login(java.lang.String username,java.lang.String password)
           throws ServletException
- 提供的用户名和密码进行身份验证,然后相关的身份验证的用户请求。
- 参数:
- 用户名 ----用户名进行身份验证
- 密码----密码使用对用户进行身份验证
- 抛出:
- ServletException——如果任何getRemoteUser(),getUserPrincipal()或getAuthType()非空,如果配置的身份验证不支持用户名和密码认证       或认证失败
- 自:
- Servlet 3.0
##29、void logout()
            throws ServletException
- 删除任何身份验证的用户的请求。
- 抛出:
- ServletException——如果注销失败
- 自:
- Servlet 3.0
##30、java.util.Collection<Part> getParts()
                                    throws java.io.IOException,
                                           java.lang.IllegalStateException,
                                           ServletException
- 返回所有上传部分的集合。
- 返回:
- 所有上传部分的集合。
- 抛出:
- . io .IOException——如果发生I / O错误
- . lang。IllegalStateException——如果超过大小限制
- ServletException——如果请求不是多部分/格式
- 自:
- Servlet 3.0

##31、Part getPart(java.lang.String name)
             throws java.io.IOException,
                    java.lang.IllegalStateException,
                    ServletException
- 被指定的部分或null如果部分并不存在。触发上传的所有部分。
- 参数:
- 名字,
- 返回:
- 指定的部分或null如果部分并不存在
- 抛出:
- . io .IOException——如果发生I / O错误
- . lang。IllegalStateException——如果超过大小限制
- ServletException——如果请求不是多部分/格式
- 自:
- Servlet 3.0