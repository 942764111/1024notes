DQL 查询语句

查询语句必须含有的两个子句:
1:SELECT子句
SELECT子句用来指定要查询的字段
2:FROM子句
FROM子句用来指定数据来源的表

SELECT * FROM emp

SELECT ename,job,sal,deptno
FROM emp

SELECT子句除了可以直接使用表中的
字段外,还可以是函数,表达式.

查看每个员工的年薪?
SELECT ename,sal,sal*12
FROM emp


查询语句中也可以添加WHERE子句来
指定过滤条件.从而只检索满足条件
的记录.

查看职位是MANAGER的员工?
SELECT ename,job,sal,deptno
FROM emp
WHERE job='MANAGER'

条件中如:>,>=,<,<= 与 JAVA一致.
需要区分:"="表示等于,"<>"表示不等于

查看MANAGER职位以外的其他员工?
SELECT ename,job
FROM emp
WHERE job<>'MANAGER'


字符串函数:

字符串连接符"||"
字符串连接函数CONCAT(c1,c2)
SELECT CONCAT(ename,sal)
FROM emp

SELECT CONCAT(CONCAT(ename,','),sal)
FROM emp

SELECT ename||','||sal
FROM emp


LENGTH(c)
查看字符串字符个数(长度)
SELECT ename,LENGTH(ename)
FROM emp

SELECT ename
FROM emp
WHERE LENGTH(ename)=6


UPPER,LOWER,INITCAP函数
将字符串转换为全大写,全小写,首字母
大写
SELECT UPPER('helloworld'),
       LOWER('HELLOWORLD'),
       INITCAP('HELLO WORLD')
FROM dual

dual:伪表,当要查询的内容与任何表无关
时,可以使用伪表

SELECT ename,job,deptno
FROM emp
WHERE ename=UPPER('scott')




TRIM,LTRIM,RTRIM
去除字符串两边指定的重复字符
LTRIM仅去除左侧,RTRIM去除右侧

SELECT 
  TRIM('e' FROM 'eeeliteee')
FROM dual

SELECT
  LTRIM('esffesliteseseses','efs')
FROM dual

LPAD,RPAD
补位函数
LPAD(c1,n,c2)
将c1显示为n位长度,不足时左侧补充
若干c2以达到n位长度
SELECT ename,LPAD(sal,6,'$')
FROM emp



SUBSTR(c,m[,n])
截取字符串
m表示从第几个字符开始截取
n表示截取多少个字符,n不指定,则
是截取到字符串末尾,n若超高可以截
取的字符个数也是截取到字符串末尾

需要注意,数据库中下标从1开始.

位置若为负数,则是从倒数位置开始取
SELECT 
  SUBSTR('thinking in java',-7,2)
FROM 
  dual


INSTR(c1,c2[,m[,n]])
查看c2在c1中的位置
m表示从第几个字符开始查找,不写则从1开始
n表示第几次出现,不写则为1

SELECT 
 INSTR('thinking in java','in',4,2)
FROM 
 dual


数值函数
ROUND(n[,m])
四舍五入
对n四舍五入,保留小数点后
m位.
m不指定这是0,表示保留到整数位
m为负数这是保留十位以上数字.
SELECT ROUND(45.678, 2) FROM DUAL
SELECT ROUND(45.678, 0) FROM DUAL
SELECT ROUND(45.678, -1) FROM DUAL


TRUNC函数
截取数字,参数意义与ROUND函数一致
SELECT TRUNC(45.678, 2) FROM DUAL
SELECT TRUNC(45.678, 0) FROM DUAL
SELECT TRUNC(45.678, -1) FROM DUAL

MOD(m,n)函数,求余
计算原则 m/n
n若为0,则直接返回m
SELECT ename, sal, MOD(sal, 1000) 
FROM emp


CEIL,FLOOR
向上取整与向下取整
SELECT CEIL(45.678) FROM DUAL; --46?
SELECT FLOOR(45.678) FROM DUAL;--45


日期相关关键字
SYSDATE,SYSTIMESTAMP
对应内置函数,返回当前系统时间

SELECT SYSDATE FROM dual
SELECT SYSTIMESTAMP FROM dual

日期转换函数
TO_DATE()
将一个字符串解析为一个DATE类型值
SELECT 
 TO_DATE('2008-08-08 20:08:08',
         'YYYY-MM-DD HH24:MI:SS')
FROM dual

DATE在数据库中是可以做计算的
对一个DATE值加减一个数字,等同于加减天
两个日期之间进行减法,差为相差的天
日期间可以比较大小,越晚的越大

SELECT SYSDATE+1
FROM dual

查看每个员工入职至今多少天了?
SELECT ename,SYSDATE-hiredate
FROM emp

日期格式字符串中凡不是英文,符号,数字的
其他字符都要使用双引号括起来
SELECT 
 TO_DATE('2008年08月08日 20:08:08',
         'YYYY"年"MM"月"DD"日" HH24:MI:SS')
FROM dual


TO_CHAR函数
常用来将DATE转换为一个字符串

SELECT
 TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS')
FROM 
 dual


SELECT 
  TO_CHAR(
   TO_DATE('49-08-05','RR-MM-DD'),
   'YYYY-MM-DD'
  )
FROM 
  dual



LAST_DAY(date)
返回给定日期所在月的月底日期

查看当月月底?
SELECT LAST_DAY(SYSDATE)
FROM dual


ADD_MONTHS(date,i)
对给定日期加上指定的月,若i为负数则是减去

查看每个员工入职20周年纪念日
SELECT 
 ename,ADD_MONTHS(hiredate,12*20)
FROM
 emp

MONTHS_BETWEEN(d1,d2)
计算两个日期之间相差的月

查看每个员工入职至今多少个月了?
SELECT 
 ename,MONTHS_BETWEEN(SYSDATE,hiredate)
FROM
 emp


NEXT_DAY(date,i)
返回给定日期第二天开始一周内的周几
所对应的日期
i的范围1-7,分别表示周日,周一...周六

SELECT NEXT_DAY(SYSDATE,3)
FROM dual


LEAST、GREATEST
最小值与最大值

SELECT 
 LEAST(SYSDATE, TO_DATE('2008-10-10','YYYY-MM-DD')) 
FROM dual




EXTRACT(date FROM datetime)
提取给定日期所对应时间分量的值

查看1980年入职的员工有哪些?
SELECT ename,hiredate
FROM emp
WHERE EXTRACT(YEAR FROM hiredate)=1980



CREATE TABLE student(
  id NUMBER(4), 
  name CHAR(20), 
  gender CHAR(1) NOT NULL
);

INSERT INTO student VALUES(1000, '李莫愁', 'F');

INSERT INTO student VALUES(1001, '林平之', NULL);

INSERT INTO student(id, name) VALUES(1002, '张无忌');

SELECT * FROM student


更新成NULL
UPDATE student
SET gender=NULL

SELECT * FROM student

删除性别为NULL的记录
DELETE FROM student
WHERE gender IS NULL


NULL与字符串连接,结果等于什么都没干.
NULL与数字运算,结果为NULL.

查看每个员工的收入情况(工资+绩效)
SELECT ename,sal,comm,sal+comm
FROM emp


空值函数
NVL(a1,a2)
当a1为NULL时,函数返回a2的值
当a1不为NULL时,函数返回a1自身
所以该函数的意义是将NULL值替换为非NULL值

SELECT 
 ename,sal,comm,
 sal+NVL(comm,0)
FROM
 emp

查看每个人的绩效情况
若该员工有绩效则显示为"有绩效",为NULL的
则显示为"没有绩效"

NVL2(a1,a2,a3)
当a1不为NULL时,函数返回a2
当a1为NULL时,函数返回a3

SELECT 
 ename,comm,NVL2(comm,'有奖金','没有奖金')
FROM 
 emp

SELECT 
  ename,sal+NVL2(comm,comm,0)
FROM
  emp






