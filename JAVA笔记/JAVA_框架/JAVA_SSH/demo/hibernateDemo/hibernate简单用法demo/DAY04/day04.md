#正课：

hibernate的ID生成规则/对象生命周期管理/hql查询

#ID生成规则（主键类型）

数据库中唯一标识记录的标记

##生成主键的方式：

数据库服务器：

应用服务器：

#什么时候用？

向数据库表中插入数据的时候，会用到主键值。


##类型：

###自增类型（sql-server mysql）

	语法：
	<generator class="identity" />
	
	create table student(id int NOT NULL AUTO_INCREMENT,
						 name varchar(30)，
						 primary key(id))
	
	insert into student(name) values('Tom')

	insert into student(id,name) values(null,'Tom')

###序列类型（oracle db2）

    语法：
    <generator class="sequence">
    	<param name="sequnce">seq_name</param>
    </generator>
	
###UUID

	语法：
	<generator class="uuid" />

	create table teacher(id varchar(90) NOT NULL,
						 name varchar(30),
						 primary key(id))

#hibernate对象生命周期管理

##生命周期：从对象被实例化到被GC回收的整个过程。

1、临时状态：内存中有对象，数据库中没有对应数据

2、持久状态：内存中有对象，DB中有数据；修改对象属性，DB中数据随之变化。

3、游离状态：内存中有对象，DB有数据，修改对象属性，DB中的数据不受影响。




1、刚创建对象或者delete后的对象，数据库中没有对应的记录，临时状态。

案例：调用save方法，变为持久状态

2、save后的对象或者get获取的对象，数据库中有对应的记录，修改对象属性的时候，记录的数据也随之变化，持久状态。

案例：改变对象属性

案例：调用delete方法，回到临时状态

3、从session中被清除的对象，数据库中有对应的记录，修改对象属性，记录的数据不受影响，游离状态

session.clear()：清除缓存中所有对象

session.evict(Object)：清除缓存中某个具体对象

案例：调用update方法，回到持久化状态

#HQL hibernate query Language

hibernate提供的新的面向对象的查询语言，与SQL类似，但是与数据库无关。

##与SQL相近的语法

- select 属性

- from 类名

- where 条件

- group by

- order by

- having

##HQL与SQL不同

1、HQL面向对象，按照类名属性名进行查询；SQL面向数据库，通过表名列名进行查询

2、HQL不支持select *

3、HQL除分组函数外不支持其他函数

4、HQL不支持join on

5、HQL支持继承、多态的特性（原因是它面向对象编程）

##为什么？SQL的替代品

##怎么用？

1、获取session对象

2、编写HQL语句

3、利用session的方法创建查询对象

4、如果hql语句带有参数，Query对象调用setXxx()为参数赋值

5、通过对象执行HQL语句，实现查询

6、关闭session

#关联关系

##什么是？

数据库中通过主外键实现表与表之间的关联

反映到实体类上，通过对象的引用体现。

    <one-to-many>
    class User{
    	int id;
    	String name;
    	Set<Book> books=new HashSet<Book>(); 		
    }

    <many-to-one>
    class Book{
    	int id;
    	String name;
    	User user;
    }

		create table t_user(u_id int NOT NULL AUTO_INCREMENT,
					u_name varchar(30),
					primary key(u_id))

		create table t_book(b_id int NOT NULL AUTO_INCREMENT,
					b_name varchar(90),
					b_userid int,
					primary key(b_id))

insert into t_user(u_name) values('Tom')

insert into t_user(u_name) values('Jerry')

insert into t_user(u_name) values('John')

insert into t_user(u_name) values('Andy')


insert into t_book(b_name,b_userid) values('Java',1)

insert into t_book(b_name,b_userid) values('Oracle',1)

insert into t_book(b_name,b_userid) values('Mysql',1)


#作业：

1、主键生成规则：uuid案例

2、hibernate对象的状态转换案例

3、关联关系映射案例