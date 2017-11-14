javax.servlet

#Interface Filter

----------
##<div class="bg-blue">例：</div>
- [点击查看过滤器相关介绍文档](../GenericServlet/demo/GenericServlet.html)

----------


- public interface Filter
- 一个过滤器是一个对象,执行过滤任务请求的资源(servlet或静态内容),或在响应从资源,或两者兼而有之。
- 在doFilter方法过滤器进行过滤。
- 每个过滤器都有FilterConfig访问对象,它可以获得初始化参数,
- 引用ServletContext它可以使用,
- 例如,加载过滤任务所需的资源。
- 过滤器是一个web应用程序的部署描述符中配置
- 这个设计例子已确定
- 1)身份验证过滤器
- 2)日志记录和审计过滤器
- 3)图像转换过滤器
- 4)数据压缩过滤器
- 5)加密过滤器
- 6)分过滤器
- 7)过滤器,触发资源访问事件
- 8)XSL / T过滤器
- 9)mime类型过滤器链

----------
#Method Detail
##1、void init(FilterConfig filterConfig)
          throws ServletException

##2、void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
              throws java.io.IOException,
                     ServletException

##3、void destroy()