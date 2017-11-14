javax.servlet.http
#Interface HttpSession 

----------
##<div class="bg-blue">例：</div>
- [点击查看Cookie和session相关文档](../demo/cookieANDsession/day08.html)

----------

- public interface HttpSession
- 提供了一种方法来识别用户在多个页面请求或访问一个网站,来存储有关用户的信息。
- servlet容器使用该接口来创建一个HTTP客户端和一个HTTP服务器之间的会话。
- 会话持续指定的时间,在一个以上的连接或页面请求的用户。一个会话通常对应一个用户,他们可能多次访问一个网站。
- 服务器可以维持一个会话在许多方面,如使用cookie或重写url。
- 这个接口允许servlet视图和操作一个会话的信息,如会话标识符,创建时间,最后访问时间对象绑定到会话,跨多个用户连接允许用户信息保存
- 当应用程序将一个对象存储在会话或删除一个对象,对象是否实现HttpSessionBindingListener会话检查。
- 如果是,servlet通知的对象被绑定到或从会话释放。通知发送后绑定方法完成。会话无效或过期,通知发送后,会话已失效或过期。
- 当容器迁移虚拟机之间的会话容器在分布式环境中,通知所有会话属性实现HttpSessionActivationListener接口。
- servlet应该能够处理情况下,客户端不选择加入一个会话,例如当饼干是故意关机。直到客户端连接会话,isNew返回true。
- 如果客户选择不加入会话,getSession将返回一个不同的会话在每个请求,和isNew将始终返回true。
- 会话信息只有当前的web应用程序作用域(ServletContext),所以信息存储在一个上下文不会直接出现在另一个地方。
- 参见:
- HttpSessionBindingListener

#方法总结(Method Summary)

----------
##1、long getCreationTime()
- 返回:
- 返回该会话被创建时候的时间,以毫秒为单位。
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##2、java.lang.String getId()
- 返回一个字符串,其中包含惟一标识符ID。由servlet容器的标识符分配,是依赖于实现的。
- 返回:
- 一个字符串指定的标识符分配给这个会话
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##3、long getLastAccessedTime()
- 返回:
- 返回最后一次与该客户端发送请求的时间,以毫秒为单位。
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##4、ServletContext getServletContext()
- 返回此会话所属的ServletContext。
- 返回:
- ServletContext对象的web应用程序
- 自:
- 2.3
##5、void setMaxInactiveInterval(int interval)
- 修改Session的缺省时间限制
- 使用声明式来修改缺省时间，
- 那么该应用创建的所有Session对象的生命周期都会应用这个规定的时间，单位为分钟。
- 使用编程式来修改缺省时间只会针对调用该方法的Session对象应用这一原则，不会影响到其他对象，所以更灵活。
- 通常在需要特殊设置时使用这种方式。
- 时间单位是秒，与声明式的时间单位不同。
- 如果用户在此设置的时间内无任何操作该Session对象死亡
- 一个零或负时间表明,会话永远不会超时。

----------
##<div class = "bg-blue">例:<div>
- [点击查看](../HttpSession/demo/setMaxInactiveInterval/setMaxInactiveInterval.html) 
##6、int getMaxInactiveInterval()
- 获取Session的缺省时间限制
##7、HttpSessionContext getSessionContext()
- 弃用。从版本2.1开始,不建议使用这个方法,没有更换。它将被删除在未来版本的Java Servlet API。
##8、java.lang.Object getAttribute(java.lang.String name)
- 返回指定名称的对象绑定在这个会话,或null如果没有绑定对象的名字。
- 参数:
- 名称——一个字符串指定对象的名称
- 返回:
- 指定名称的对象
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##9、java.lang.Object getValue(java.lang.String name)
- 弃用。从版本2.2开始,这个方法被getAttributeNames()
- 返回:
- 字符串对象数组指定的所有对象的名字绑定到这个会话
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##10、java.util.Enumeration<java.lang.String> getAttributeNames()
- 返回一个字符串对象包含枚举的名字对象绑定到这个会话。
- 返回:
- 得到所有属性名称
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##11、java.lang.String[] getValueNames()
- 弃用。从版本2.2开始,这个方法被getAttributeNames()
- 返回:
- 字符串对象数组指定的所有对象的名字绑定到这个会话
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##12、void setAttribute(java.lang.String name,java.lang.Object value)
- 结合这个会话对象,使用指定的名字。如果相同的名称的对象已经绑定到会话,对象被替换。
- 这个方法执行后,如果新对象实现HttpSessionBindingListener HttpSessionBindingListener.valueBound容器调用。
- 容器然后通知中的- - 任何HttpSessionAttributeListeners web应用程序。
- 如果一个对象已经绑定到这个名字的会话实现HttpSessionBindingListener HttpSessionBindingListener。valueUnbound方法被调用。
- 如果传入的值是null,和removeAttribute一样的效果()。

----------

- 参数:
- name-对象绑定的名称;不能为空
- value——被绑定的对象
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话
##13、void putValue(java.lang.String name,java.lang.Object value)
- 弃用。从版本2.2开始,setAttribute(java.lang.String name,java.lang.Object value)取代了该方法。
##14、void invalidate()
- 销毁Session
- 如果客户端想删除SID对应的Session对象时，可以使用该方法。
##15、boolean isNew()
- 如果服务器创建了一个会话,但是客户还没有加入返回true
##16、void removeAttribute(java.lang.String name)
- 除绑定数据
##17、void removeValue(java.lang.String name)
- 弃用。从版本2.2开始,这个方法被removeAttribute(java.lang.String name)取代
- 参数:
- name-对象的名称删除从这个会话
- 抛出:
- java.lang.IllegalStateException——如果调用此方法失效的会话