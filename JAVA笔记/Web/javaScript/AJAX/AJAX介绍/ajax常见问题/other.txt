一 Spring容器
1. Spring是什么?
	简化开发
	管理对象
	集成其它框架
2. Spring容器
	a. 什么是Spring容器?
	b. 启动?
	c. 创建对象的三种方式
		无参构造器 
		静态工厂方法  (了解)
		实例工厂方法  (了解)
	d. 作用域
	e. 生命周期
	f. 延迟加载 (了解)
3. IOC
	a. IOC是什么?
	b. DI是什么?
	c. 两种方式
		set方法注入
		构造器注入
	d. 自动装配（了解）
		autowire:byName byType constructor
	e. 注入基本类型的值
		value
	f. 注入集合类型的值
		list set map props
		<util:properties id="" location=""
	g. Spring表达式
		#{vb1.name} #{vb1.interest[0]} #{vb1.score['english']}

4. 注解简化配置
	a. 组件扫描
	b. 步骤
		@Component @Service  @Repository  @Controller
		<context:component-scan base-package=""/>
	c. @Scope @Lazy @PostContruct  @PreDestroy
	d. @Value
	e. @Autowired / @Qualifier   @Resource(name="")
	
二.SpringMVC
1. springmvc是什么?
2. 五大组件
	DispatcherServlet
	HandlerMapping
	Controller
	ModelAndView
	ViewResolver
3. 编程步骤
	a. 导包
	b. 配置文件
	c. 配置DispatcherServlet	
	d. Controller
	e. jsp
4. 读取请求参数值
	request  @RequestParam	javabean
5. 向页面传值
	request session ModelAndView ModelMap
6. 重定向
	return "redirect:toIndex.do"
7. 拦截器
	a.什么拦截器
	b.如何写拦截器
		HandlerInterceptor
		preHandle	postHandle afterCompletion
	c.优先级
8. 表单中文参数乱码
9. 异常处理
	@ExceptionHandler

三. 分层（扩展）
1.如何分层
	表示层 UI 请求分发
	业务层 业务逻辑的处理
	持久层 数据访问逻辑
2.如何调用
	通过接口
四.MyBatis
1.是什么?
2.基本原理
3.编程步骤
	导包
	配置文件
	实体类
	映射文件
	SqlSession
4. 返回Map
5. resultMap
6. Mapper映射器
五.Spring + MyBatis
	导包
	配置文件
		SqlSessionFactoryBean		
	实体类
	映射文件
	Mapper映射器
		MapperScannerConfigurer	
	只扫描特定的映射器
	
	SqlSessionTemplate	