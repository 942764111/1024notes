#hibernate的缓存机制

##为什么？

提高应用的运行性能。应用程序访问缓存内数据，降低与数据库交互的次数，在一定条件下，会同步缓存与数据库中的数据。

##什么是？

hibernate缓存：

- Session缓存（一级缓存）

- SessionFactory缓存类型（二级缓存）

##缓存的应用原理

hibernate 通过访问数据对象时，首先访问session缓存，当没有结果时，再访问二级缓存，如果仍然没有，就会访问数据库获取结果。当删除、更新、增加数据的时候，会同步数据库中数据。

##怎么用？

Session缓存的管理：

- session.evict(object) :从缓存中清除某个对象

- session.clear()：清除缓存中的所有对象

- session.contains(object):判断某个对象时候存在于缓存中

- session.flush():刷新缓存，同步数据库

Session缓存的应用：

- session.save(object):保存对象，保存后将数据放到session中

- session.get(,):查询数据，查询后将数据放到session中

- session.load(,):查询数据，查询后将数据放到session中

- HQL:查询数据，查询后将数据放到session中

#懒惰加载

##什么是？

懒惰=延迟=按需 尽可能晚的加载数据到内存。

lazy="false"

##什么时候用？

- session.load()--get()

- query.iterate()--list()

- 关联映射

## openSessionInViewFilter

解决表现层使用延迟加载功能的异常

#Spring+hibernate整合

ORM 框架：Object Relation Mapping 将对象映射到数据库表中的某一条记录。

整合的目的：让Spring管理hibernate对象，本质就是管理session和sessionFactory

步骤：

1- 导包

       hibernate-core
       spring-orm 3.0.5
       Struts2-spring-plugin
       mysql-connector-java
       dbcp C3P0 0.9.1
       Junit

2- 配置文件

   web.xml

   spring-context.xml

3- 环境测试
	
	create table cn_user(id varchar(90),name varchar(90),
					 password varchar(90),token varchar(90),
					 nick varchar(90),primary key(id))

	insert into cn_user values('1','JackSon','123456','123456','Jack')

4- 业务层处理

5- Struts2+spring+hibernate

 - 导包：Struts2-core 2.3.8
 - 配置：web.xml struts.xml
 - 实现Action：调用service方法

6- /test/login.action
   LoginAction
   msg.jsp/erro.jsp

面试题：描述hibernate和mybatis的区别？

1、hibernate 面向对象；mybatis 面向数据库的。

2、hibernate 需求管理对象与映射；mybatis 不需要管理映射。

3、hibernate 移植性好；mybatis 移植性较差。

4、hibernate 不支持动态SQL;mybatis支持动态SQL。

5、hibernate 功能、特性较多，全面掌握较难；
   mybatis 自身功能较少，支持开源plugin插件扩展功能。

6、hibernate 一款复杂的数据库框架；mybatis轻量级的简单框架。











