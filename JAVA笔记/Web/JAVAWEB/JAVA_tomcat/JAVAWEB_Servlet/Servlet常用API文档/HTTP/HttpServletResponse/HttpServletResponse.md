javax.servlet.http
#Interface HttpServletResponse

- All Superinterfaces:
- ServletResponse
- All Known Implementing Classes:
- HttpServletResponseWrapper

----------
- public interface HttpServletResponse
- extends ServletResponse
- 扩展了ServletResponse接口提供HTTP-specific功能发送响应。
- 例如,它有一些方法来访问HTTP header和cookies.。
- servlet容器创建一个HttpServletResponse对象并将它作为参数传递给servlet的服务方法(doGet、doPost等)。
- 参见:
- ServletResponse

----------
#字段汇总(Field Summary)
##1、static int	SC_ACCEPTED
- 状态码(202)表明处理的请求被接受,但未能完成。
##2、static int	SC_BAD_GATEWAY
- 状态码(502)表明HTTP服务器收到无效的响应从服务器充当代理或网关时参考。
##3、static int	SC_BAD_REQUEST
- 状态码(400)指示客户端发送的请求是语法错误。
##4、static int	SC_CONFLICT
- 状态码(409)表明请求不能完成由于冲突资源的当前状态。
##5、static int	SC_CONTINUE
- 状态码(100)指示客户端可以继续。状态码(100)指示客户端可以继续。
##6、static int	SC_CREATED
- 状态码(201)表示请求成功和在服务器上创建了一个新的资源。
##7、static int	SC_EXPECTATION_FAILED
- 状态码(417),表明给出的服务器无法满足期望的期望请求头。
##8、static int	SC_FORBIDDEN
- 状态码(403)表明服务器理解的请求,但拒绝履行它。
##9、static int	SC_FOUND
- 状态码(302),表明资源暂时居住在一个不同的URI。
##10、static int	SC_GATEWAY_TIMEOUT
- 状态码(504)表明服务器没有收到及时响应从上游服务器作为网关或代理。
##11、static int	SC_GONE
- 状态码(410),表明资源不再是可用的服务器,也没有转发地址。
##12、static int	SC_HTTP_VERSION_NOT_SUPPORTED
- 状态码(505)表明服务器不支持或不支持HTTP请求消息中使用的协议版本。
##13、static int	SC_INTERNAL_SERVER_ERROR
- 状态码(500)表明一个错误在阻止它满足请求的HTTP服务器。
##14、static int	SC_LENGTH_REQUIRED
- 状态码(411)表明请求内容长度不能处理没有定义。
##15、static int	SC_METHOD_NOT_ALLOWED
- 状态码(405)表明该方法中指定请求行是不允许资源得到由请求uri所指定资源。
##16、static int	SC_MOVED_PERMANENTLY
- 状态码(301),表明资源已经永久搬到一个新的位置,和未来的引用应该使用一个新的URI的请求。
##17、static int	SC_MOVED_TEMPORARILY
- 状态码(302),表明资源暂时搬到另一个位置,但未来的引用应该仍然使用原来的URI来访问资源。
##18、static int	SC_MULTIPLE_CHOICES
- 状态码(300)表明所请求的资源对应的一组表示,每个都有自己的特定位置。
##19、static int	SC_NO_CONTENT
- 状态码(204)表明请求成功了,但是没有新的信息返回。
##20、static int	SC_NON_AUTHORITATIVE_INFORMATION
- 状态码(203),表明客户端所呈现的元信息不是来自服务器。
##21、static int	SC_NOT_ACCEPTABLE
- 状态码(406),表明资源被请求只能生成响应实体内容的特征不能接受根据发送请求中的accept标头。
##22、static int	SC_NOT_FOUND
- 状态码(404)表明所请求的资源不可用。
##23、static int	SC_NOT_IMPLEMENTED
- 状态码(501)指示所需的HTTP服务器不支持的功能满足要求。状态码(501)指示所需的HTTP服务器不支持的功能满足要求。
##24、static int	SC_NOT_MODIFIED
- 状态码(304)表明一个条件GET操作发现资源是可用的,而不是修改。
##25、static int	SC_OK
- 状态码(200)通常表示请求成功。
##26、static int	SC_PARTIAL_CONTENT
- 状态码(206)表明服务器已经完成部分GET请求的资源。
##27、static int	SC_PAYMENT_REQUIRED
- 状态码(402)保留以供将来使用。
##28、static int	SC_PRECONDITION_FAILED
- 状态码(412),表明给出的先决条件中的一个或多个请求头字段值为false时在服务器上进行测试。
##29、static int	SC_PROXY_AUTHENTICATION_REQUIRED
- 状态码(407)表明客户机必须首先验证本身与代理。
##30、static int	SC_REQUEST_ENTITY_TOO_LARGE
- 状态码(413)表明服务器拒绝处理请求,因为请求实体大于服务器不愿或不能实现的行为过程。
##31、static int	SC_REQUEST_TIMEOUT
- 状态码(408),表明客户端没有产生一个请求的时间内服务器准备等。
##32、static int	SC_REQUEST_URI_TOO_LONG
- 状态码(414)表明服务器的拒绝服务请求,因为要求通用长于服务器愿意解释。
##33、static int	SC_REQUESTED_RANGE_NOT_SATISFIABLE
- 状态码(416)表明服务器不能提供所请求的字节范围。
##34、static int	SC_RESET_CONTENT
- 状态码(205)表明,代理人应当重置文档视图造成发送请求
##35、static int	SC_SEE_OTHER
- 状态码(303),表明此请求的响应可以找到下一个不同的URI。
##36、static int	SC_SERVICE_UNAVAILABLE
- 状态码(503)表明HTTP服务器暂时过载,,无法处理请求。
##37、static int	SC_SWITCHING_PROTOCOLS
- 状态码(101)指示服务器切换协议根据升级头。
##38、static int	SC_TEMPORARY_REDIRECT
- 状态码(307)表明所请求的资源暂时驻留在一个不同的URI。
##39、static int	SC_UNAUTHORIZED
- 状态码(401)表明请求需要HTTP身份验证。
##40、static int	SC_UNSUPPORTED_MEDIA_TYPE
- 状态码(415)表明服务器的拒绝服务请求,因为实体请求的格式不支持请求的资源请求的方法。
##41、static int	SC_USE_PROXY
- 状态码(305)表明必须通过代理访问所请求的资源的位置字段。

----------
#方法总结(Method Summary)
##1、void addCookie(Cookie cookie)
- 将指定cookie添加到响应。这种方法可以多次调用超过一个cookie。
- 参数:
- cookie---cookie返回给客户端
##2、boolean containsHeader(java.lang.String name)
- 返回一个布尔值表示是否指定响应头已经设置。
- 参数:
- name——标题名称
- 返回:
- TRUE：指定的响应头已经设置;否则FALSE 
##3、java.lang.String encodeURL(java.lang.String url)
- 编码指定的URL,包括session ID,或者,如果不需要编码,返回的URL不变。
- 这个方法的实现包括逻辑判断session ID需要编码的URL。
- 例如,如果浏览器支持Cookie,或session 跟踪是关闭的,URL编码是不必要的。
- 健壮session 跟踪、一个servlet发出的所有url应该通过这种方法运行。
- 否则,不能使用URL重写的浏览器不支持Cookie。
- 参数:
- url - url编码。
- 返回:
- 如果需要编码的编码的URL;否则不变的URL。
##4、java.lang.String encodeRedirectURL(java.lang.String url)
- 编码指定URL sendRedirect方法或使用,如果不需要编码,返回的URL不变。
- 这个方法的实现包括逻辑判断会话ID需要编码的URL。
- 因为做这个决定的规则可以不同于那些用于决定是否编码一个正常的链接,该方法分离encodeURL方法。
- 所有url发送到HttpServletResponse。
- sendRedirect方法应该通过这个方法来运行。
- 否则,不能使用URL重写的浏览器不支持cookie。
- 参数:
- url - url编码。
- 返回:
- 如果需要编码的编码的URL;否则不变的URL。
- 参见:
- sendRedirect(java.lang.String), encodeUrl(java.lang.String)
##5、java.lang.String encodeUrl(java.lang.String url)
- 弃用。从版本2.1开始,使用encodeURL(java.lang.String url)
##6、java.lang.String encodeRedirectUrl(java.lang.String url)
- 弃用。从版本2.1开始,使用encodeRedirectURL(字符串url)

##7、void sendError(int sc,java.lang.String msg)
               throws java.io.IOException
- 使用指定的状态代码发送一个错误响应给客户端,并清空输出缓冲区。
- 如果响应已经承诺,该方法抛出IllegalStateException。
- 使用这种方法后,响应应该被认为是承诺和不应该被写入。
- 参数:
- msg -错误状态码的描述性信息
- 抛出:
- java.io.IOException——如果一个输入或输出异常发生
- java.lang.IllegalStateException——如果反应是承诺或部分URL给出,不能转化为一个有效的URL
##8、void sendError(int sc)
               throws java.io.IOException
- 发送一个错误响应给客户端使用指定的状态代码,并清空缓冲区。这相当于调用sendError(int, String)相同的状态码和空的消息。
- 参数:
- sc -错误状态码
##9、void sendRedirect(java.lang.String location)
                  throws java.io.IOException
- 发送一个临时重定向响应给客户端使用指定的URL重定向位置。
- 该方法可以接受相对URL;servlet容器之前必须将相对URL转换为绝对URL发送响应给客户端。
- 如果没有领导‘/’的位置是相对的容器把它解释为相对于当前请求URI。
- 如果领导‘/’的位置是相对的容器把它解释为相对于servlet容器根。
- 如果响应已经承诺,该方法抛出IllegalStateException。
- 使用这种方法后,响应应该被认为是承诺和不应该被写入。
- 参数:
- location,location重定向到URL
- 抛出:
- java.io.IOException——如果一个输入或输出异常发生
- java.lang.IllegalStateException——如果反应是承诺或部分URL给出,不能转化为一个有效的URL
----------
##<div class="bg-blue">例：</div>
- [点击查看](demo/sendRedirect/sendRedirect.html)
##10、void addDateHeader(java.lang.String name,long date)
- 用给定的名称和日期值添加一个响应头。在指定的日期是以毫秒为单位。这种方法允许多个值响应标头。
- 参数:
- name——标题设置的名称
- date——额外的日期值
- 参见:
- setDateHeader(java.lang.String name,long date)
##11、void setHeader(java.lang.String name,java.lang.String value)
- 用给定的名称和值设置一个响应头。
- 如果头已经设置,新值覆盖前一个。
- containsHeader方法可以用来测试指定响应头是否已经设置。
- 参数:
- name——标题的名称
- value——头的值如果它包含八位字节字符串,它应该根据RFC 2047(http://www.ietf.org/rfc/rfc2047.txt)编码
- 参见:
- containsHeader(java.lang.String), addHeader(java.lang.String, java.lang.String)
##12、void addHeader(java.lang.String name,java.lang.String value)
- 用给定的名称和值添加一个响应头。这种方法允许多个值响应标头。
- 参数:
- name——标题的名称
- value——附加头的值如果它包含八位字节字符串,它应该根据RFC 2047(http://www.ietf.org/rfc/rfc2047.txt)编码
- 参见:
- setHeader(java.lang.String name,java.lang.String value)
##13、void setIntHeader(java.lang.String name,int value)
- 设置一个给定名称的响应头和整数值。
- 如果头已经设置,新值覆盖前一个。
- containsHeader方法可以用来测试指定响应头是否已经设置。
- 参数:
- name——标题的名称
- value——分配的整数值
- 参见:
- containsHeader(java.lang.String),addIntHeader(java.lang.String name,int value)
##14、void addIntHeader(java.lang.String name,int value)
- 添加一个给定名称的响应头和整数值。这种方法允许多个值响应标头。
- 参数:
- name——标题的名称
- value——分配的整数值
- 参见:
- tIntHeader(java.lang.String name,int value)
##15、void setStatus(int sc)
- 设置状态代码为这个反应。该方法用于设置没有错误时返回状态代码(例如,状态代码SC_OK或SC_MOVED_TEMPORARILY)。
- 如果有一个错误,调用者想要调用的web应用程序中定义一个页面偷走了,应该使用sendError方法。
- 参数:
- sc -状态代码
- 参见:
- sendError(int sc)
##16、void setStatus(int sc,java.lang.String sm)
- 弃用。从版本2.1开始,由于消息参数的模糊意义。
- 设置状态代码使用setStatus(int),发送一个错误描述使用sendError(int,字符串)。
- 设置状态代码和消息响应。
- 参数:
- sc -状态代码
- sm -状态消息
##17、int getStatus()
- 返回的HTTP状态代码与此相关的反应。
- 自:
- Servlet 3.0
##18、java.lang.String getHeader(java.lang.String name)
- 返回指定的标题的值,如果没有设置这个头返回null。
- 如果超过一个值被添加这个名字,只有第一个返回;
- 使用getHeaders(java.lang.String nam)来检索。
- 参数:
- name——标题名称查找
- 自:
- Servlet 3.0
##19、java.util.Collection<java.lang.String> getHeaders(java.lang.String name)
- 返回的集合所有标头值与指定的标题名称。
- 参数:
- name——标题名称查找
- 自:
- Servlet 3.0
##20、java.util.Collection<java.lang.String> getHeaderNames()
- 返回一个Iterable所有的标题名称设置为这个响应。
- 自:
- Servlet 3.0
##21、void setDateHeader(java.lang.String name,long date)
- 用给定的名称和日期值设置一个响应头。在指定的日期是以毫秒为单位。
- 如果头已经设置,新值覆盖前一个。
- containsHeader方法可以用来测试指定响应头是否已经设置。
- 参数:
- name——标题设置的名称
- date——分配的日期值
- 参见:
- containsHeader(java.lang.String), addDateHeader(java.lang.String, long)

----------
#Methods inherited from interface javax.servlet.ServletResponse(从ServletResponse继承的接口)
flushBuffer, getBufferSize, getCharacterEncoding, getContentType, getLocale, getOutputStream, getWriter, isCommitted, reset, resetBuffer, setBufferSize, setCharacterEncoding, setContentLength, setContentType, setLocale
