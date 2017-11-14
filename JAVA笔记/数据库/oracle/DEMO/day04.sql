
=========================================1.1. 子查询================================================
--在SELECT查询中，在WHERE查询条件中的限制条件不是一个确定的值，而是来自于另外一个查询的结果。为了给查询提供数据而首先执行的查询语句叫做子查询。
--
--子查询：嵌入在其它SQL语句中的SELECT语句，大部分时候出现在WHERE子句中。
--子查询嵌入的语句称作主查询或父查询。
--主查询可以是SELECT语句，也可以是其它类型的语句比如DML或DDL语句。
--根据返回结果的不同，子查询可分为【单行子查询】、【多行子查询】及【多列子查询】。

1、【子查询在WHERE子句中】
例 1： 单行子查询：查看谁的工资高于CLARK
SELECT ename,sal FROM account_Jon WHERE SAL>(SELECT SAL FROM account_Jon WHERE ename = 'CLARK')

例 2： 多行查询：如果子查询返回多行，主查询中要使用多行比较操作符，包括IN、ALL、ANY。其中ALL和ANY不能单独使用，需要配合单行比较操作符>、>=、<、<=一起使用。
--例如查询出部门中有SALESMAN但职位不是SALESMAN的员工的信息：

SELECT empno, ename, job, sal, depton
FROM account_Jon
WHERE depton IN 
(SELECT depton FROM account_Jon WHERE job = 'SALESMAN')
AND job <> 'SALESMAN'; 


SELECT *
FROM account_Jon
WHERE sal > ALL(SELECT sal FROM account_Jon WHERE job IN('SALESMAN','CLERK'))


例 1： 单行子查询：查看谁的工资高于CLARK
SELECT ename,sal FROM account_Jon WHERE SAL>(SELECT SAL FROM account_Jon WHERE ename = 'CLARK')

2、【子查询在DDL中的应用】

--可以基于子查询的结果快速创建为一张表,若对应的子查询字段含有函数或表达式,
--那么该字段必须给别名,并且会使用该别名作为这张表对应该字段的名字。

例：
CREATE TABLE employee_QiaoJon AS
SELECT e.empno "ename", d.empno "dename"
FROM account_Jon e JOIN emp_2012 d
ON e.empno=d.empno(+);

3、【子查询在DML中的应用】

例：给SMITH所在部门员工工资上调10%
--UPDATE account_Jon SET ename = 'jon' WHERE ename = (SELECT ename FROM account_Jon WHERE ename = 'SMITH') //***

4、【EXISTS】关键字   EXISTS = true   Not EXISTS = false
--在子查询中需要引用到主查询的字段数据，使用EXISTS关键字。
--EXISTS后边的子查询至少返回一行数据，则整个条件返回TRUE。
--如果子查询没有结果，则返回FALSE。

例： 列出来那些有员工的部门信息
SELECT d.depton, d.ename FROM account_Jon d
WHERE EXISTS 
                (SELECT * FROM account_Jon e
                 WHERE d.depton = e.depton);
                 
                 
5、【子查询在HAVING部分】
--子查询不仅可以出现在WHERE子句中，还可以出现在HAVING部分。

例：例如查询列出最低薪水高于部门30的最低薪水的部门信息：
SELECT depton, MIN(sal) min_sal
FROM account_Jon
GROUP BY depton
HAVING MIN(sal) >
(SELECT MIN(sal) FROM account_Jon  WHERE depton = 30);

6、【子查询在FROM部分】
--在查询语句中，FROM子句用来指定要查询的表。如果要在一个子查询的结果中继续查询，
--则子查询出现在FROM 子句中，这个子查询也称作行内视图或者匿名视图。
--这时，把子查询当作视图对待，但视图没有名字，只能在当前的SQL语句中有效。

例 1：查询出薪水比本部门平均薪水高的员工信息：
SELECT e.depton, e.ename, e.sal
FROM account_Jon e,
(SELECT depton, AVG(sal) avg_sal FROM account_Jon GROUP BY depton) x
WHERE e.depton = x.depton AND e.sal>x.avg_sal ORDER BY e.depton;

例 2：查看每个部门的最高工资是谁：
SELECT e.depton, e.ename, e.sal
FROM account_Jon e,
(SELECT depton, MAX(sal) MAX_sal FROM account_Jon GROUP BY depton) x
WHERE e.depton = x.depton AND e.sal = ANY(x.MAX_sal) ORDER BY e.depton;

7、【子查询在SELECT部分】
--把子查询放在SELECT子句部分，可以认为是外连接的另一种表现形式，使用更灵活：

例：
SELECT e.ename, e.sal, e.depton,
           (SELECT d.depton FROM account_Jon d 
            WHERE d.depton = e.depton)  depton
FROM account_Jon e

=========================================1.2. 分页查询================================================

1、【ROWNUM】返回标识行数据列号
--ROWNUM被称作伪列，用于返回标识行数据顺序的数字。

例 1 ：ROWNUM 语法：
SELECT ROWNUM, empno, ename, sal
FROM account_Jon;

例 2 ： 在使用 ROWNUM 对结果编译行号的过程中不能使用 ROWNUM>1 以上的数字进行过滤否则编译无效。
下面的查询语句将没有结果：

SELECT ROWNUM, empno, ename, sal
FROM account_Jon
WHERE ROWNUM>1;

例 3 ： 如果利用 ROWNUM 截取结果集中的部分数据，需要用到行内视图： 也就是将ROWNUM先作为行内视图的一个列，在主查询中就可以使用这个列值作为条件。

SELECT ROWNUM rn FROM 
  (SELECT  ROWNUM rn , e.* FROM account_Jon e )  
 WHERE rn BETWEEN 8 AND 10;
 

2、【使用子查询进行分页】
  PageN: (n - 1) * pageSize + 1 至 n * pageSize
  
  page:页数
  pageSize:没页显示的条目数
  
  page = 2 pageSize = 5
  start:(page-1)*pageSize+1
  end:pageSize*page
  
3、【分页与 ORDER BY】
                                                                                                                                                              
例：按薪水倒序排列，取出结果集中第8到第10条的记录：
1、
SELECT * FROM (SELECT 
    ROWNUM rn,t.* FROM(SELECT e.* FROM account_Jon e  ORDER BY sal DESC) t)  
 WHERE rn BETWEEN 8 AND 10;
 
 2、
 SELECT * FROM (SELECT 
    ROWNUM rn,t.* FROM(SELECT e.* FROM account_Jon e  ORDER BY sal DESC) t
     WHERE ROWNUM<=10
    )  
 WHERE rn <=8;

=========================================1.3. DECODE 函数================================================
1、【DECODE函数基本语法】
--DECODE函数的语法如下：
--DECODE (expr, search1, result1[, search2, result2…][, default]) 是变长参数  前提是最少有三个参数
--
--它用于比较参数 expr 的值，如果匹配到哪一个 search1 条件，就返回对应的result结果，
--可以有多组 search1 和 result 的对应关系，
--如果任何一个search条件都没有匹配到，则返回最后default的值。
--default参数是可选的，如果没有提供default参数值，当没有匹配到时，将返回NULL。

例 1：查询职员表，根据职员的职位计算奖励金额，当职位分别是’MANAGER’、’ANALYST’、’SALESMAN’时，
奖励金额分别是薪水的1.2倍、1.1倍、1.05倍，如果不是这三个职位，则奖励金额取薪水值：

SELECT ename, job, sal,
DECODE(job, 'MANAGER', sal * 1.2,
               'ANALYST', sal * 1.1,
              'SALESMAN', sal * 1.05,
null
     ) bonus
FROM account_Jon;

例 2： 和DECODE函数功能相似的有CASE语句，实现类似于if-else的操作。

SELECT ename, job, sal,
     CASE job WHEN 'MANAGER' THEN sal * 1.2
      WHEN 'ANALYST' THEN sal * 1.1
     WHEN 'SALESMAN' THEN sal * 1.05
                    ELSE null END
bonus
FROM account_Jon;

2、【DECODE函数在分组查询中的应用】

例 1：
SELECT DECODE(job, 'ANALYST', 'VIP', 
                       'MANAGER', 'VIP', 
                       'OPERATION') job,
COUNT(1) job_cnt
FROM account_Jon
GROUP BY DECODE(job, 'ANALYST', 'VIP', 
                     'MANAGER', 'VIP', 
                     'OPERATION');
                     
例 2：DECODE函数也可以按字段内容排序，例如：Dept表中按”研发部”、“市场部”、“销售部”排序，用普通的select语句，无法按照字面数据排序：
      
SELECT  depton
FROM account_Jon
ORDER BY 
      DECODE(depton, 20,2,10,1,30,3), null;
      
=========================================1.4. 排序函数====================================================
--排序函数：
--排序函数可以对结果集按照给定字段分组
--然后在组内按照给定字段排序，
--并生成组内编号
          
1、【ROW_NUMBER()】生成组内连续且唯一的数字

ROW_NUMBER() OVER(
          PARTITION BY col1 ORDER BY col2)
          
--表示根据col1分组，在分组内部根据col2排序。
--此函数计算的值就表示每组内部排序后的顺序编号，组内连续且唯一。

例：按照部门编码分组显示，每组内按职员编码排序，并赋予组内编码

SELECT depton, ename, empno,
 ROW_NUMBER()
   OVER (PARTITION BY depton ORDER BY empno) AS emp_id
   FROM account_Jon;






2、【RANK()】

RANK函数的语法如下：
RANK() OVER(
          PARTITION BY col1 ORDER BY col2)
--表示根据col1分组，在分组内部根据col2给予等级标识，即排名，相同的数据返回相同排名。
--特点是跳跃排序，如果有相同数据，则排名相同，比如并列第二，则两行数据都标记为2，但下一位将是第四名。
--和ROW_NUMBER的区别是有结果有重复值，而ROW_NUMBER没有。

例： 按照部门编码分组，同组内按薪水倒序排序，相同薪水则按奖金数正序排序，并给予组内等级，用Rank_ID表示
   
SELECT depton, ename, empno,
 RANK()
   OVER (PARTITION BY depton ORDER BY empno) AS emp_id
   FROM account_Jon; --*** demo
   
   
   
   
   
   
3、【DENSE_RANK】

DENSE_RANK函数的语法如下：
DENSE_RANK() OVER(
          PARTITION BY col1 ORDER BY col2)
          
--表示根据col1分组，在分组内部根据col2给予等级标识，即排名，相同的数据返回相同排名。
--特点是连续排序，如果有并列第二，下一个排序将是三，
--这一点是和RANK的不同，RANK是跳跃排序。


SELECT depton, ename, empno,
 DENSE_RANK()
   OVER (PARTITION BY depton ORDER BY empno) AS emp_id
   FROM account_Jon; 



=========================================1.5. 高级分组函数================================================

SELECT a,b,c,SUM(d) FROM account_Jon GROUP BY ROLLUP(a,b,c);

CREATE TABLE sales_JonBin (
year_id   NUMBER NOT NULL,
month_id   NUMBER NOT NULL,
day_id   NUMBER NOT NULL,
sales_value NUMBER(10,2) NOT NULL
);
INSERT INTO sales_JonBin
SELECT TRUNC(DBMS_RANDOM.value(2010,2012)) AS year_id,
TRUNC(DBMS_RANDOM.value(1,13)) AS month_id,
TRUNC(DBMS_RANDOM.value(1,32)) AS day_id,
ROUND(DBMS_RANDOM.value(1,100), 2) AS sales_value
FROM   dual
CONNECT BY level <= 1000;

COMMIT;



--ROLLUP、CUBE 和 GROUPING SETS 运算符是 GROUP BY 子句的扩展，
--可以生成与使用 UNION ALL 来组合单个分组查询时相同的结果集，
--用来简化和高效的实现统计查询。语法形式如下：

--GROUP BY ROLLUP(a, b, c)
--GROUP BY CUBE(a, b, c)
--GROUP BY GROUPING SETS ( (a), (b))

1、【ROLLUP】 全表分组
--对ROLLUP的列从右到左以一次少一列的方式进行分组直到所有列都去掉后的分组(也就是全表分组)。
--对于n个参数的ROLLUP，有n+1次分组。
例：
SELECT year_id,month_id,day_id,SUM(sales_value) 
FROM sales_JonBin 
GROUP BY ROLLUP(year_id,month_id,day_id)




2、【CUBE】
CUBE函数的语法形式：
GROUP BY CUBE(a, b, c)

对cube的每个参数，都可以理解为取值为参与分组和不参与分组两个值的一个维度，所有维度取值组合的集合就是分组后的集合。
对于n个参数的cube，有2^n次分组。
如果GROUP BY CUBE(a,b,c)，首先对(a,b,c)进行GROUP BY，然后依次是(a,b)，(a,c)，(a)，(b,c)，(b)，(c)，最后对全表进行GROUP BY操作，所以一共是2^3=8次分组。

例：
SELECT year_id, month_id,
SUM(sales_value) AS sales_value
FROM   sales_JonBin
GROUP BY CUBE (year_id, month_id)
ORDER BY year_id, month_id;



3、【GROUPING SETS】
--GROUPING SETS()允许指定分组方式,
--然后将这些分组统计的结果并在一个结果集中显示,
--该函数每个参数为一种分组方式

SELECT year_id, month_id, SUM(sales_value)  
FROM sales_JonBin
GROUP BY CUBE (year_id,month_id)
order by 1, 2; 

SELECT year_id, month_id, SUM(sales_value)  
FROM sales_JonBin
GROUP BY GROUPING SETS ((year_id), (month_id))
order by 1, 2


=========================================1.6. 集合操作====================================================

为了合并多个SELECT语句的结果，可以使用集合操作符，实现集合的并、交、差。
集合操作符包括UNION、UNION ALL、INTERSECT和MINUS。多条作集合操作的SELECT语句的列的个数和数据类型必须匹配。
ORDER BY子句只能放在最后的一个查询语句中。

集合操作的语法如下：
SELECT statement1
[UNION | UNION ALL | INTERSECT | MINUS]
SELECT statement2;

UNION和UNION ALL用来获取两个或两个以上结果集的并集：
UNION操作符会自动去掉合并后的重复记录。
UNION ALL返回两个结果集中的所有行，包括重复的行。
UNION操作符对查询结果排序，UNION ALL不排序。

1、【Union】并集  操作符会自动去掉合并后的重复记录。
--Union

例：合并职位是’MANAGER’的员工和薪水大于2500的员工集合，查看两种方式的结果差别：
SELECT ename, job, sal FROM account_Jon
WHERE job = 'MANAGER'
Union
SELECT ename, job, sal FROM account_Jon
WHERE sal> 2500;



2、【Union all】并集all  返回两个结果集中的所有行，包括重复的行
--Union all

例：合并职位是’MANAGER’的员工和薪水大于2500的员工集合，查看两种方式的结果差别：

SELECT ename, job, sal FROM account_Jon
WHERE job = 'MANAGER'
Union all
SELECT ename, job, sal FROM account_Jon
WHERE sal> 2500;


3、【 INTERSECT】交集
--INTERSECT函数获得两个结果集的交集，只有同时存在于两个结果集中的数据，才被显示输出。
--使用INTERSECT操作符后的结果集会以第一列的数据作升序排列。

例：合并职位是’MANAGER’的员工和薪水大于2500的员工集合，查看两种方式的结果差别：

SELECT ename, job, sal FROM account_Jon
WHERE job = 'MANAGER'
INTERSECT
SELECT ename, job, sal FROM account_Jon
WHERE sal> 2500;

4、【MINUS】 差集
--MINUS函数获取两个结果集的。
--只有在第一个结果集中存在，在第二个结果集中不存在的数据，才能够被显示出来。
--也就是结果集一减去结果集二的结果。

例：合并职位是’MANAGER’的员工和薪水大于2500的员工集合，查看两种方式的结果差别：

SELECT ename, job, sal FROM account_Jon
WHERE job = 'MANAGER'
MINUS
SELECT ename, job, sal FROM account_Jon
WHERE sal> 2500;
