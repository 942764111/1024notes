#一、什么是过滤器
	1、过滤器是Servlet2.3规范之中一种特殊的Web组件,用来拦截Servlet容器的请求和响应的过程
	  以便查看,提取操作正在客户机和服务机之间交换的数据。
	2、利用Servlet过滤器可以拦截* .html * .mp3 * .jpg等请求，检查用户是否登录，只有登录的用户才能访问这些资源。
#二、编写测试流程、
##1、编写一个JAVA类,实现Filter接口
- <div class="bg-blue">例：</div>
- [点击查看](demo/测试流程1/filterdemo.java)
##2、编写一个JAVA类,实现HttpServlet接口
- <div class="bg-blue">例：</div>
- [点击查看](demo/测试流程2/filterdemo.java)
##3、将过滤器添加到Web程序中
- <div class="bg-blue">例：</div>
- [点击查看](demo/测试流程3/web.xml)
##4、把过滤器和WEB应用一起打包部署
##5、执行输出结果
- <div class="bg-blue">例：</div>
- [点击查看](demo/测试流程5/流程5.html)
##6、执行流程图级多个过滤器执行流程图
- <div class="bg-blue">例：</div>
- [点击查看](demo/测试流程5/流程5.html)

#二、servlet与filter
- <div class="bg-blue">例：</div>
- [点击查看](demo/servlet与filter/servlet与filter.html)