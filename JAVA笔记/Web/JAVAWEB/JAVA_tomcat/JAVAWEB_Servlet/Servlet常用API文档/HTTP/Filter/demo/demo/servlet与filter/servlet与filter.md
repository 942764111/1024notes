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