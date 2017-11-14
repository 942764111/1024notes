#如何修改Session的超时时间

有两种方式可以修改Session的缺省时间限制，编程式和声明式。

- 编程式：
<div class = "bg-blue">例:</div>
void  setMaxInactiveInterval（int seconds）

----------

- 声明式：在web中配置
<div class = "bg-blue">例:</div>
<session-config>
        <session-timeout>30</session-timeout>
</session-config>

----------

- 使用声明式来修改缺省时间，那么该应用创建的所有Session对象的生命周期都会应用这个规定的时间，单位为分钟。
- 使用编程式来修改缺省时间只会针对调用该方法的Session对象应用这一原则，
- 不会影响到其他对象，所以更灵活。
- 通常在需要特殊设置时使用这种方式。
- 时间单位是秒，与声明式的时间单位不同。 