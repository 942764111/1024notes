javax.servlet.http
#Class Cookie

- java.lang.Object
- javax.servlet.http.Cookie
- All Implemented Interfaces:
- java.io.Serializable, java.lang.Cloneable

----------
##<div class="bg-blue">例：</div>
- [点击查看Cookie和session相关文档](../demo/cookieANDsession/day08.html)

----------

- public class Cookie
- extends java.lang.Object
- 实现 java.lang.Cloneable, java.io.Serializable
- 创建一个cookie,少量的信息由一个servlet发送到一个Web浏览器,浏览器保存,后来发送回服务器。
- 一个cookie的值能唯一地标识一个客户,所以Cookies是常用的会话管理,一种浏览器一个Cookie。
- Cookie有一个名字,一个单一的值,和可选属性,如评论,路径和域限定符,最高年龄和版本号。
- 一些Web浏览器缺陷在他们如何处理可选属性,所以要谨慎使用它们来提高互操作性的servlet。
- servlet使用HttpServletResponse.addCookie向浏览器发送cookie(javax.servlet.http.Cookie)方法,
- 将字段添加到HTTP响应头向浏览器发送cookie,一次一个。
- 浏览器将为每个Web服务器支持20个cookie,可能会限制每个cookie大小为4 KB。
- 浏览器返回cookie，servlet通过添加到HTTP请求头字段。
- cookie可以从请求检索利用HttpServletRequest.getCookies()方法。cookie可能有相同的名字,但路径属性不同。
- 使用cookie影响网页的缓存。
- HTTP 1.0不使用cookie创建这个类的缓存页面。这个类不支持HTTP 1.1缓存控制定义。
- 这门课同时支持版本0(Netscape)和版本1(RFC 2109)cookie规范。默认情况下,创建cookie使用版本0,以确保最佳的互操作性。
- 参见:
- Serialized Form(序列化形式)

#Constructor Summary(构造函数的总结)

----------

##1、Cookie(java.lang.String name, java.lang.String value)
- 构造一个cookie与指定的名称和值。
- 名称必须符合RFC 2109。这意味着它可以只包含ASCII字母数字字符,不能包含逗号,分号,或空白或从一个$字符开始。
- cookie的名字创建后不能更改。
- 值可以是任何服务器选择发送。它的价值才感兴趣的可能是服务器。
- cookie的值创建使用setValue方法后可以改变。
- 参数:
- 名称——一个字符串指定cookie的名称
- 价值——一个字符串指定cookie的值
- 抛出:
- java.lang.IllegalArgumentException——如果cookie的名称包含非法字符(例如,逗号,空间,或分号)或是一个令牌用于cookie使用协议
- 参见:
- setValue(java.lang.String), setVersion(int)



#Method Summary(方法总结)

----------

##1、java.lang.Object	clone()
- 克隆：覆盖了标准的java.lang.Object.clone。克隆方法返回一个副本的cookie。

##2、java.lang.String	getComment()
- 返回的评论描述这个cookie的目的,如果cookie没有发表评论返回null。
- 返回:
- 一个字符串包含评论,或者null如果没有
- 参见:
- setComment(以)
##3、public void setComment(java.lang.String purpose)
- 指定了一个评论,描述一个cookie的目的。
- 评论是有用的,如果浏览器向用户介绍了cookie。评论是不支持Netscape(浏览器)版本0 的cookie。
- 参数:
- 目的——一个字符串指定评论显示给用户
- 参见:
- getComment()
##4、public java.lang.String getDomain()
- 返回设置cookie的域名。域名的形式由RFC 2109。
- 返回:
- 一个字符串包含域名
- 参见:
- setDomain(java.lang.String)
##5、public void setMaxAge(int expiry)
- 设置Cookie的过期时间设置Cookie的过期时间
- 默认情况下，Cookie会被浏览器保存在内存中，
- 此时Cookie的生命周期由浏览器决定，只要不关闭浏览器Cookie就会一直存在。
- 如果希望关闭浏览器后Cookie仍存在，则可以通过设置过期时间使得Cookie存在硬盘上得以保存更长的时间。
- 该方法是Cookie提供的实例方法。参数seconds的单位为秒，但精度不是很高。
<div class = "bg-blue">
  <il>	
	<li>seconds > 0 ：代表Cookie保存在硬盘上的时长</br></li>
	<li>seconds = 0 ： 代表Cookie的生命时长为现在，而这一刻稍纵即逝，所以马上Cookie就等同于过了生存时间，所以会被立即删除,这也是删除、Cookie的实现方式。</li>
	<li>seconds < 0 ：缺省值，浏览器会将Cookie保存在内存中(浏览器关闭后消失)。</li>
</il>	
</div>
- 参见(See Also):
- getMaxAge()
##6、public int getMaxAge()
返回:
整数指定cookie的最高年龄在几秒钟内,如果负数,意味着Cookie一直持续,直到浏览器关闭
参见:
setMaxAge(int)
##7、public void setPath(java.lang.String uri)
- 设置Cookie的路径
- 这样所有资源路径要么与此路径相等，要么是子路径，从而实现了客户端发送任何请求时都会发送Cookie。
- Parameters:
- uri - a String specifying a path
- 参见:
- getPath()
##8、public java.lang.String getPath()
- 返回:
- 字符串包含一个servlet名称指定一个路径,例如,"/目录"
- 参见:
- setPath(java.lang.String)
##9、public void setSecure(boolean flag)
- 显示到浏览器cookie是否只能使用一个安全协议,比如HTTPS和SSL。
- 默认值是false。
- 参数:
- flag——如果这是true,只能使用一个安全协议把cookie从浏览器到服务器,如果false,发送任何协议
- 参见:
- getSecure()
##10、public boolean getSecure()
- 如果浏览器发送cookie只在一个安全的协议返回true,
- 如果浏览器可以使用任何协议发送cookie返回false。
- 返回:
- 如果浏览器使用安全协议;false,true
- 参见:
- setSecure(boolean flag)
##11、public java.lang.String getName()
- 返回cookie的名称。这个名字创建后不能更改。
- 返回:
- 一个字符串指定cookie的名称
##<div class = "bg-blue">例:<div>
- [点击查看](../Cookie/demo/setValue/setValue.html)
##12、public void setValue(java.lang.String newValue)
- 值不应包含空格,括号,括号,等号,逗号,双引号,斜杠,问号,迹象,冒号,分号。
- 空值可能不会在所有浏览器上的表现一样。

----------

- 所谓Cookie的修改，本质是获取到要变更值的Cookie，
- 通过setValue方法将新的数据存入到cookie中，
- 然后由response响应对象发回到客户端，对原有旧值覆盖后即实现了修改。
##<div class = "bg-blue">例:<div>
- [点击查看](../Cookie/demo/setValue/setValue.html)
##13、public java.lang.String getValue()
- 取Cookie的value
##<div class = "bg-blue">例:<div>
- [点击查看](../Cookie/demo/如何查询Cookie/如何查询Cookie.html)
##14、public int getVersion()
- 返回此cookie符合协议的版本。
- 由浏览器提供使用和识别浏览器的cookie的版本。
- 返回:
- 如果Cookie符合原网景规范返回0;如果Cookie符合RFC 2109返回1
- 参见:
- setVersion(int)
##15、public void setVersion(int v)
- 设置版本的曲奇饼干符合协议。0版本符合原网景饼干规范。版本1符合RFC 2109。
- 由于RFC 2109仍是有点新,不建议使用它。
- 参数:
- 0：Cookie应该遵循原网景规范;
- 1：饼干应符合RFC 2109
- 参见:
- getVersion()
##16、public void setHttpOnly(boolean httpOnly)
- 设置cookie是否在客户端隐藏
- 参数:
- 自(Since):
- Servlet 3.0
##17、public boolean isHttpOnly()
- cookie是否在客户端隐藏。
- 返回:
- true,false
- 自(Since):
- Servlet 3.0