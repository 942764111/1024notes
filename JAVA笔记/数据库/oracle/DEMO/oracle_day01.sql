SQL语句本身是不区分大小写的,但是为了
增强可读性,通常会将关键字与非关键字
区别开,所有关键字大写.
SELECT SYSDATE FROM dual

DDL语句 数据定义语言
用来增删改数据库对象
数据库对象:表,视图,索引,序列

创建表:
CREATE语句

CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)


查看表结构
DESC table_name
例:
DESC employee

数据库中,所有字段的默认值都是NULL.
可以使用DEFAULT为字段单独指定默认值.

在数据库中,字符串的字面量是使用单引号
括起来的,并且字符串内容是区分大小写的.

删除表
DROP TABLE table_name
DROP TABLE employee

NOT NULL约束
NOT NULL要求指定字段必须给值.
CREATE TABLE employee(
	id NUMBER(4) NOT NULL,
	name VARCHAR2(20),
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2) DEFAULT 5000,
  job VARCHAR2(30),
  deptno NUMBER(2)
);

DESC employee


修改表
1:修改表名
2:修改表结构

修改表名
RENAME old_name TO new_name

RENAME employee TO myemp

DESC myemp

修改表结构
1:添加新字段
2:修改现有字段
3:删除字段

1:添加新字段
ALTER TABLE myemp
ADD(
  hiredate DATE DEFAULT SYSDATE
)
添加的字段会被追加到表的最后.
SYSDATE在ORACLE中对应一个内置函数,返回
一个DATE类型的当前系统时间的值.



2:修改字段
可以修改表字段的类型,长度,默认值,非空.

尽量不要在表中含有数据后修改,如果有数据,
那么尽量不修改类型,长度尽量不减小,否则
可能修改失败.

ALTER TABLE myemp
MODIFY(
  job VARCHAR2(40) DEFAULT 'CLERK' 
)

删除字段
ALTER TABLE myemp
DROP(hiredate)


DML 数据操作语言
用来增,删,改表中数据的.

添加新数据:INSERT语句

INSERT INTO myemp
(id,name,salary,job,deptno)
VALUES
(1,'rose',4000,'MANAGER',10)

SELECT * FROM myemp

INSERT INTO myemp
(id,name,job,birth)
VALUES
(2,'JACK','CLERK',
 TO_DATE('1992-08-06','YYYY-MM-DD')
)

SELECT * FROM myemp

修改数据:UPDATE 语句
UPDATE myemp
SET salary=8000,deptno=20
WHERE name='JACK'

UPDATE语句通常要添加WHERE子句,来
限定只修改表中满足WHERE条件要求的
记录,否则是全表更新!

删除数据:DELETE语句
DELETE FROM myemp
WHERE name='JACK'

不添加WHERE子句是清空表操作!




























