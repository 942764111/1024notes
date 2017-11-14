
=========================================1.1. 基本查询语句================================================

1、【列别名】
--当查询的字段含有函数，表达式时，那么查询出来的结果集中该字段的名字就是该函数或表达式，
--可读性差，为此经常会为这样的列添加别名。
--使用语法是列的别名跟在列名后，中间可以加或不加一个“AS”关键字。
例 1： sal
SELECT ename,sal*12 sal FROM account_Jon

例 1： "sal"
--别名本身不去分大小写，若希望区分大小写可以使用双引号括起来。
SELECT ename,sal*12 "sal" FROM account_Jon

2、【AND】
--  AND = &&
SELECT ename,sal,job FROM account_Jon WHERE sal>1000 AND job='CLERK' 

3、【OR】
--OR = ||
SELECT ename,sal,job FROM account_Jon WHERE sal>1000 OR job='CLERK' 

--AND，OR 区别
AND，OR 用来链接多个条件，AND优先级高于OR，可以使用括号来提高优先级。
SELECT ename,sal,job FROM account_Jon WHERE sal>1000 AND (job='CLERK' OR job='SALESMAN')

4、【LIKE】（模糊查询）
--当用户在执行查询时，不能完全确定某些信息的查询条件，或者只知道信息的一部分，可以借助LIKE来实现模糊查询。
--LIKE需要借助两个通配符：
--%：表示0到多个字符
--_：标识单个字符
--这两个通配符可以配合使用，构造灵活的匹配条件。

例 ： 例如查询职员姓名中第二个字符是‘A’的员工信息：
SELECT ename,job FROM account_Jon WHERE ename LIKE '_A%'
SELECT ename,joB FROM account_Jon WHERE ename LIKE '_c%t_'

5、【NOT IN】非(10,20)
--NOT IN(X[....])变长参数   NOT IN ！= x[...]  
SELECT ename,job,depton FROM account_Jon WHERE depton NOT IN (10,20);

6、【IN】是(10,20)
-- IN  IN(X[....])变长参数   IN = x[...]  
SELECT ename,job,depton FROM account_Jon WHERE depton IN (10,20);

7、【BETWEEN…AND…】范围查询
 -- BETWEEN…AND…   操作符用来查询符合某个值域范围条件的数据，最常见的是使用在数字类型的数据范围上，但对字符类型和日期类型数据也同样适用。
 例如查询薪水在1500-3000之间的职员信息：
    SELECT ename, sal FROM account_Jon
    WHERE sal BETWEEN 1500 AND 3000  AND depton IN (10,20) AND ENAME LIKE '__A%';
    
    
  8、  【IS NULL】【IS NOT NULL】
 --使用IS NULL(是空)和IS NOT NULL（非空）
 --空值NULL是一个特殊的值，比较的时候不能使用”=”号，必须使用IS NULL，否则不能得到正确的结果。
 例如查询哪些职员的奖金数据为NULL：
  SELECT ename, sal, comm FROM account_Jon
  WHERE comm IS NOT NULL;
  
  9、【ANY】任一 【ALL】全部
--在比较运算符中，可以出现ALL和ANY，表示“全部”和“任一”，但是ALL和ANY不能单独使用，需要配合单行比较操作符>、>=、<、<=一起使用。
--其中：
--> ANY : 大于最小
--< ANY：小于最大
--> ALL：大于最大
--< ALL：小于最小
  例：查询薪水比职位是“SALESMAN”的人高的员工信息，比任意一个SALESMAN高都行：
  SELECT ename, job, sal, depton FROM account_Jon WHERE 
  sal> ANY (SELECT sal FROM account_Jon WHERE job = 'SALESMAN');
  
 10、查询条件中使用表达式和函数 
 
-- 当查询需要对选出的字段进行进一步计算，可以在数字列上使用算术表达式(+、-、*、/)。表达式符合四则运算的默认优先级，如果要改变优先级可以使用括号。
--算术运算主要是针对数字类型的数据，对日期类型的数据可以做加减操作，表示在一个日期值上加或减一个天数。
--查询条件中使用字符串函数UPPER，将条件中的字符串变大写后再参与比较：
例 1：
SELECT ename, sal, job FROM account_Jon WHERE ename = UPPER('FORD');

例 2： 查询条件中使用算数表达式，查询年薪大于1000元的员工记录：
SELECT ename, sal, job FROM account_Jon WHERE sal * 12 >100;

11、【DISTINCT】过滤重复
--使用DISTINCT过滤重复
--数据表中有可能存储相同数据的行，当执行查询操作时，默认情况会显示所有行，不管查询结果是否有重复的数据。
--当重复数据没有实际意义，经常会需要去掉重复值，使用DISTINCT实现。
例：查询员工的部门编码，去掉重复值：
SELECT DISTINCT depton FROM account_Jon;

例 2：【多列去重,会将这些字段值的组合相同的去除】
--DISTINCT后面的列可以组合查询，下例查询每个部门的职位，去掉重复值。
SELECT DISTINCT depton, job FROM account_Jon;

=========================================1.2. 基本排序语句================================================
  1、【ORDER BY】
--  对查询出的数据按一定规则进行排序操作，使用ORDER BY子句
例1：
SELECT ename, sal
FROM emp
ORDER BY sal;

2、【ASC】升序【DESC】降序 
排序时默认按升序排列，即由小及大，ASC用来指定升序排序，DESC用来指定降序排序。
因为NULL值视作最大，则升序排列时，排在最后，降序排列时，排在最前。如果不写ASC或DESC，默认是ASC，升序排列。

例 1 【ASC】 默认为 ASC：
    SELECT empno, ename, mgr FROM account_Jon
    WHERE depton = 10 ORDER BY mgr;
    
例 2【DESC】    
    SELECT empno, ename, mgr FROM account_Jon
    WHERE depton = 10 ORDER BY mgr DESC
    
例 3【多个列排序】  
--当以多列作为排序标准时，首先按照第一列进行排序，
--如果第一列数据相同，再以第二列排序，以此类推。
--多列排序时，不管正序还是倒序，每个列需要单独设置排序方式。
SELECT ename, depton, sal FROM account_Jon
    ORDER BY depton , sal DESC;
    
  
=========================================1.3. 聚合函数语句================================================
1、【什么是聚合函数】  
--查询时需要做一些数据统计，比如：查询职员表中各部门职员的平均薪水，各部门的员工人数。

2、【MAX】【MIN】用来取得列或表达式的最大、最小值
--用来取得列或表达式的最大、最小值，可以用来统计任何数据类型，包括数字、字符和日期。

例 1： 获取机构下的最高薪水和最低薪水，参数是数字：
SELECT MAX(sal) max_sal, MIN(sal) min_sal
FROM account_Jon;

例 2：计算最早和最晚的入职时间，参数是日期：
SELECT MAX(hiredate) max_hire, MIN(hiredate) min_hire
FROM account_Jon;


3、【AVG】平均值 【SUM】值
--AVG和SUM函数用来统计列或表达式的平均值和和值，这两个函数只能操作数字类型，并忽略NULL值。

例 1：例如获得机构下全部职员的平均薪水和薪水总和：
SELECT AVG(sal) avg_sal, SUM(sal)  sum_sal  FROM account_Jon;


4、【COUNT】计算表中的记录条数
--COUNT函数用来计算表中的记录条数，同样忽略NULL值。

例 1：例如获取职员表中一共有多少名职员记录：
SELECT COUNT(*) total_num  FROM account_Jon;

例 2： 获得职员表中有多少人是有职位的（忽略没有职位的员工记录）
SELECT COUNT(job) jon_num  FROM account_Jon;


=========================================1.4. 分组==========================================================
1、【 GROUP BY 子句】
--可以将结果集按照给定字段值一样的记录看作一组
--当SELECT子句中含有聚合函数时,凡不在聚合函数中的单独字段都要出现在GROUP BY 字句中.

例 1：查看每个部门的最高工资是多少
SELECT MAX(SAL),depton FROM account_Jon GROUP BY depton

例 2： GROUP BY 可以按照多字段分组,
      分组原则是这些字段值都一样的记录被看做一组。
      
      查看同部门同职位的员工工资总合
      
      SELECT SUM(SAL),job,depton FROM account_Jon GROUP BY job,depton
      


2、【HAVING 字句】
--HAVING子句用来对分组后的结果进一步限制，比如按部门分组后，得到每个部门的最高薪水，可以继续限制输出结果。

例： 查看部门的平均工资,前提是该部门的平均工资要高于2000

SELECT SUM(SAL),job,depton FROM account_Jon GROUP BY job,depton HAVING SUM(sal) >2000 


【查询语句的执行顺序】
当一条查询语句中包含所有的子句，执行顺序依下列子句次序：
FROM 子句：执行顺序为从后往前、从右到左。数据量较少的表尽量放在后面。
WHERE子句：执行顺序为自下而上、从右到左。将能过滤掉最大数量记录的条件写在WHERE 子句的最右。
GROUP BY：执行顺序从左往右分组，最好在GROUP BY前使用WHERE将不需要的记录在GROUP BY之前过滤掉。
HAVING 子句：消耗资源。尽量避免使用，HAVING 会在检索出所有记录之后才对结果集进行过滤，需要排序等操作。
SELECT子句：少用*号，尽量取字段名称。ORACLE 在解析的过程中, 通过查询数据字典将*号依次转换成所有的列名, 消耗时间。
ORDER BY 子句：执行顺序为从左到右排序，消耗资源。

=========================================1.5. SQL（关联基础）================================================
1、【关联的概念】
--实际应用中所需要的数据，经常会需要查询两个或两个以上的表。
--这种查询两个或两个以上数据表或视图的查询叫做连接查询，连接查询通常建立在存在相互关系的父子表之间。
--语法如下：
例 1：
SELECT account_Jon.depton, emp_2012.deptno
FROM account_Jon, emp_2012
WHERE account_Jon.depton = emp_2012.deptno;

例 2：
SELECT account_Jon.ENAME, emp_2012.ENAME
FROM account_Jon JOIN emp_2012
ON(account_Jon.depton = emp_2012.deptno);


2、【笛卡尔积】
--笛卡尔积指做关联操作的每个表的每一行都和其它表的每一行做组合，
--假设两个表的记录条数分别是X和Y，
--笛卡尔积将返回X * Y条记录。
--当两个表关联查询时，不写连接条件，
--得到的结果即是笛卡尔积。
--N张表关联查询,至少要有N-1个链接条件
 例 ：
SELECT COUNT(*) FROM account_Jon; --18条记录
SELECT COUNT(*) FROM emp_2012; --14条记录
SELECT account_Jon.ename,emp_2012.ename FROM account_Jon, emp_2012;--  18*14 = 252


3、【等值连接】 别名
--等值连接是连接查询中最常见的一种，
--通常是在有主外键关联关系的表间建立，
--并将连接条件设定为有关系的列，
--使用等号”=”连接相关的表。
--使用两个相关的列做等值操作

例：
SELECT e.ename, e.job, d.ename
FROM account_Jon e, emp_2012 d
WHERE e.depton = d.deptno;

=========================================1.6. SQL（关联查询）================================================
1、【内连接】 返回满足连接条件的记录
--内连接返回两个关联表中所有满足连接条件的记录。

例 1：例如查询员工的名字和所在部门的名字：
SELECT account_Jon.ename, emp_2012.ename
FROM account_Jon, emp_2012
WHERE account_Jon.depton = emp_2012.deptno;

例 2：
SELECT account_Jon.depton, emp_2012.deptno
FROM account_Jon JOIN emp_2012
ON(account_Jon.depton = emp_2012.deptno);


2、【外连接】
外连接在关联查询中还可以将不满足条件的记录也查询出来。

外连接分为：左外连接,右外链接，全外链接

左外链接： 以JOIN左侧表作为驱动表,该表记录都会查询出来,
那么当左侧表某条记录不满足链接条件时,来自右侧表的字段全部为NULL值.

例 1：左外链接

SELECT e.empno, d.empno
FROM account_Jon e LEFT OUTER JOIN emp_2012 d
ON e.empno = d.empno;


例 2：右外链接：反之 右侧表某条记录不满足链接条件时,来自左侧表的字段全部为NULL值.

SELECT e.empno, d.empno
FROM account_Jon e JOIN emp_2012 d
ON e.empno=d.empno(+);

例 3： 全外连接

SELECT e.empno, d.empno
FROM account_Jon e FULL OUTER JOIN emp_2012 d
ON e.empno = d.empno;



4、【自连接】
SELECT e.ename,e.mgr,d.mgr,d.ename
FROM account_Jon e,account_Jon d
WHERE e.mgr = d.empno(+);
