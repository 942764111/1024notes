

=========================================1.1.  视图================================================
1.1.1、【什么是视图】
视图(VIEW)也被称作虚表，即虚拟的表，是一组数据的逻辑表示,
其本质是对应于一条 SELECT 语句，结果集被赋予一个名字，即视图名字。
视图本身并不包含任何数据，它只包含映射到基表的一个查询语句，当基表数据发生变化，视图数据也随之变化。

创建视图的语法：
CREATE [OR REPLACE] VIEW view_name[(alias[, alias…])]
AS subquery ;

视图创建后，可以像操作表一样操作视图，主要是查询操作。
语法中的Subquery是 SELECT 查询语句，对应的表被称作基表。
根据视图所对应的子查询种类分为几种类型:
SELECT 语句是基于单表建立的，且不包含任何函数运算、表达式或分组函数，叫做简单视图，此时视图是基表的子集；
SELECT 语句同样是基于单表，但包含了单行函数、表达式、分组函数或GROUP BY子句，叫做复杂视图；
SELECT 语句是基于多个表的，叫做连接视图。




1.1.2、【视图的作用】

如果需要经常执行某项复杂查询，可以基于这个复杂查询建立视图，
此后查询此视图即可，简化复杂查询；
视图本质上就是一条 SELECT 语句，
所以当访问视图时，
只能访问到所对应的 SELECT 语句中涉及到的列，
对基表中的其它列起到安全和保密的作用，可以限制数据访问。




1.1.3、【授权创建视图】

创建视图的DDL语句是CREATE VIEW，用户必须有 CREATE VIEW 系统权限，才能创建视图。
如果没有权限，创建视图时会提示：权限不足。
管理员可以通过DCL语句授予用户创建视图的权限。
下例中管理员给用户tarena创建视图的权限：
例：
GRANT CREATE VIEW  TO account_Jon;





1.1.4、【创建简单视图（单表）】
例：
CREATE VIEW v_emp_JonBin
AS
SELECT empno, ename, sal, depton 
FROM account_Jon 
WHERE depton = 10;





1.1.5、【查询视图】
例 1：查看视图结构：
DESC v_emp_JonBin;

例 2：查看视图属性：
SELECT * FROM v_emp_JonBin

例 3：查看视图结构：
SELECT empno FROM v_emp_JonBin



1.1.6、【对视图进行 INSERT 操作】

视图本身并不包含数据，只是基表数据的逻辑映射。
所以当对视图执行DML操作时，实际上是对基表的DML操作。
对视图执行DML操作的基本原则：
简单视图能够执行DML操作，下列情况除外：在基表中定义了非空列，
但简单视图对应的SELECT语句并没有包含这个非空列，导致这个非空列对视图不可见，
这时无法对视图执行INSERT操作；
如果视图定义中包含了函数、表达式、分组语句、DISTINCT关键字或ROWNUM伪列，不允许执行DML操作；
DML操作不能违反基表的约束条件。

例：
INSERT INTO v_emp_JonBin 
VALUES(1234, 'DOCTOR', 4000, 10);



1.1.7、【创建具有 CHECK OPTION 约束的视图】   通过视图所做的修改，必须在视图的可见范围内

语法如下：
--CREATE [OR REPLACE] VIEW view_name[(alias[, alias…])]
--AS subquery 
--[WITHCHECKOPTION];
--
--其中：WITH CHECK OPTION短语表示，通过视图所做的修改，必须在视图的可见范围内：
--假设INSERT，新增的记录在视图仍可查看
--假设UPDATE，修改后的结果必须能通过视图查看到
--假设DELETE，只能删除现有视图里能查到的记录

例 1： 创建带有CHECK OPTION约束的视图：
CREATE OR REPLACE VIEW v_emp_JonBin
AS
SELECT empno id, ename name, sal salary, deptno 
FROM emp 
WHERE deptno = 10
WITH CHECK OPTION;

例 2：下述DML语句操作失败，因为部门20不在视图可见范围内：

INSERT INTO v_emp_JonBin VALUES(1008,'donna',5500, 20); 
UPDATE v_emp_JonBin SET deptno = 20 WHERE id = 7782;




1.1.8、【创建具有 READ ONLY 约束的视图】 声明为只读

--对简单视图进行DML操作是合法的，但是不安全的。
--如果没有在视图上执行 DML 操作的必要，
--在建立视图时声明为只读来避免这种情况，
--保证视图对应的基表数据不会被非法修改。
--加入READ ONLY约束的视图语法如下：
--
--CREATE [OR REPLACE] VIEW view_name[(alias[, alias…])]
--AS subquery 
--[WITHREAD ONLY];

例 ： 创建视图，带有READ ONLY约束：

CREATE OR REPLACE VIEW v_JonBin_READ
AS
SELECT empno, ename, sal, depton FROM account_Jon 
WHERE depton = 10
WITH READ ONLY;

例 ： 此时对只读视图执行DML操作，将会失败：

INSERT INTO v_JonBin_READ 
VALUES(1258, 'DONNA', 3000, 10);

1.1.9、【通过查询 USER_VIEWS 获取相关信息】



1.1.10、【创建复杂视图（多表关联）】

=========================================1.2.  序列================================================

1.2.1、【什么是序列】

--序列(SEQUENCE)是一种用来生成唯一数字值的数据库对象。
--序列的值由Oracle程序按递增或递减顺序自动生成，
--通常用来自动产生表的主键值，是一种高效率获得唯一键值的途径。
--序列是独立的数据库对象，和表是独立的对象，序列并不依附于表。
--通常情况下，一个序列为一个表提供主键值，但一个序列也可以为多个表提供主键值。



1.2.2、【创建序列】

--创建序列的语法：
--CREATE SEQUENCE [schema.]sequence_name
--    [ START WITH i ] [ INCREMENT BY j ]
--    [ MAXVALUE m | NOMAXVALUE ]
--    [ MINVALUE n | NOMINVALUE ]
--    [ CYCLE | NOCYCLE ][ CACHE p | NOCACHE ]
--其中：
--sequence_name是序列名，将创建在schema方案下
--序列的第一个序列值是i，步进是j
--如果j是正数，表示递增，如果是负数，表示递减
--序列可生成的最大值是m，最小值是n
--如果没有设置任何可选参数，序列的第一个值是1，步进是1
--CYCLE表示在递增至最大值或递减至最小值之后是否继续生成序列号，默认是NOCYCLE
--CACHE用来指定先预取p个数据在缓存中，以提高序列值的生成效率，默认是20

1.2.3. 【使用序列】

--举例说明，创建一个序列，起始数据是100，步进是10：
--CREATE SEQUENCE emp_seq 
--    START WITH 100
--    INCREMENT BY 10;
--    
--当序列被创建后，第一个序列值将是100，将要生成的序列号分别是110、120、130等。
--序列中有两个伪列：
--
--NEXTVAL：获取序列的下个值
--CURRVAL：获取序列的当前值(最后一个)
--
例 1：【创建】创建一个序列，起始数据是100，步进是10：

CREATE SEQUENCE JonBin_seq 
    START WITH 100
    INCREMENT BY 10;
    
例 2：【查看】当序列创建以后，必须先执行一次 NEXTVAL ，之后才能使用 CURRVAL。
获取序列的第一个值，并且使用序列值为JonBin_seq表插入新的记录：    

  SELECT JonBin_seq.NEXTVAL FROM DUAL;
                
例 3：【插入】       

 INSERT INTO account_Jon(empno, ename)      
                VALUES(JonBin_seq.NEXTVAL, 'donna');
                
                
例 4【查询刚刚生成的记录】   

SELECT * FROM account_Jon WHERE ename = 'donna';

】
例 5【查询刚刚生成的记录】   

SELECT JonBin_seq.CURRVAL FROM DUAL;


1.2.4. 【删除序列】

--删除序列的语法如下：
--  DROP SEQUENCE sequence_name;
  
例 ：删除序列emp_seq：
  DROP SEQUENCE JonBin_seq;

=========================================1.3.  索引================================================

1、【索引的原理】
--加快索引效率  此索引对 【LIKE】（模糊查询） 没用

1.3.2. 【创建索引】
--创建索引的语法：
--CREATE [UNIQUE] INDEX index_name
--        ON table(column[, column…]);
--其中：
--index_name表示索引名称
--table表示表名
--column表示列名，可以建立单列索引或复合索引
--UNIQUE表示唯一索引

例 1【创建】：

CREATE INDEX idx_account_Jon_ename ON account_Jon(ename);

例 2 【复合索引 = 多列索引】

CREATE INDEX idx_account_Jon_sal ON emp(job, sal);

例 3 【查询】 当做下面的查询时，会自动应用索引idx_emp_job_sal

SELECT empno, ename, sal, job FROM account_Jon 
ORDER BY job, sal;


1.3.3.、【创建基于函数的索引】

例 1：如果需要在 TABLE 表的ename列上执行大小写无关搜索，可以在此列上建立一个基于UPPER函数的索引:

    CREATE INDEX emp_ename_upper_idx 
    ON account_Jon(UPPER(ename));
    
    
    当做下面的查询时，会自动应用刚刚建立的索引:
    SELECT * FROM account_Jon 
        WHERE UPPER(ename) = 'KING';



1.3.4. 【修改和删除索引】

--如果经常在索引列上执行DML操作，需要定期重建索引，提高索引的空间利用率，语法如下：
--    ALTER INDEX index_name REBUILD;

例 1：重建索引idx_emp_ename：

    ALTER INDEX emp_ename_upper_idx REBUILD;
   
    
例 2：删除索引：
    DROP INDEX idx_account_Jon_ename;
    
    
1.3.5. 【合理使用索引提升查询效率】

2、为经常出现在WHERE子句中的列创建索引--建议加
3、为经常出现在ORDER BY、DISTINCT后面的字段建立索引。如果建立的是复合索引，索引的字段顺序要和这些关键字后面的字段顺序一致--建议加
4、为经常作为表的连接条件的列上创建索引--建议加
5、不要在经常做DML操作的表上建立索引--不建议加
6、不要在小表上建立索引--不建议加
7、限制表上的索引数目，索引并不是越多越好--建议
8、删除很少被使用的、不合理的索引    --建议
9、此索引对 【LIKE】（模糊查询） 没用 --建议


=========================================1.4.  约束================================================

2.1. 【约束概述】

2.1.1【约束的作用】

2.1.2【约束的类型】



2.2  【非空约束】非空约束 = 列级约束

  非空约束用于确保字段值不为空。
  默认情况下，任何列都允许有空值，
  但业务逻辑可能会要求某些列不能取空值。
  当某个字段被设置了非空约束条件，这个字段中必须存在有效值，即：
  ------
  当执行 INSERT 操作时，必须提供这个列的数据
  当执行 UPDATE 操作时，不能给这个列的值设置为NULL
  
2.2.1. 【建表时添加非空约束】
例：建表时添加非空约束：

CREATE TABLE employees_jonnull (
eid NUMBER(6),
name VARCHAR2(30) NOT NULL,
salary NUMBER(7, 2),
hiredate DATE 
      CONSTRAINT employees_jonnull_hiredate_nn NOT NULL
);

2.2.2. 【修改表时添加非空约束】

可以在建表之后，通过修改表的定义，添加非空约束：

ALTER TABLE employees_jonnull 
MODIFY (eid NUMBER(6) NOT NULL);

2.2.3. 【取消非空约束】重置列名类型为 null

例： 如果业务要求取消某列的非空约束，可以采用重建表或者修改表的方式：

ALTER TABLE employees_jonnull 
MODIFY (eid NUMBER(6) null);



2.3. 【唯一性约束】
2.3.1. 【什么是唯一性约束】

唯一性(Unique)约束条件用于保证字段或者字段的组合不出现重复值。
当给表的某个列定义了唯一约束条件，该列的值不允许重复，但允许是NULL值。
唯一性约束条件可以在建表同时建立，也可以在建表以后再建立。

2.3.2. 【添加唯一性约束】

例 1： 在建表employees的同时，在eid、email列上创建唯一约束条件，
DROP TABLE employees_Jon;
CREATE TABLE employees_Jon (
eid NUMBER(6) UNIQUE,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7, 2),
hiredate DATE,
CONSTRAINT employees_Jon_email_uk UNIQUE(email)
 );
 
 
 例 2 在建表后在name列上建立一个名为employees_name_uk的唯一约束条件：：
 -- ADD
ALTER TABLE employees_Jon 
ADD CONSTRAINT employees_name_uk UNIQUE(name);


--INSERT INTO 
INSERT INTO employees_Jon 
(eid,name,email)
VALUES
(1,'jon','942764111')


2.4. 【主键约束】
2.4.1. 【主键的意义】 非空（NOT NULL）且唯一（UNIQUE）
--主键(Primary Key)约束条件从功能上看相当于非空（NOT NULL）且唯一（UNIQUE）的组合。
--主键字段可以是单字段或多字段组合，即：在主键约束下的单字段或者多字段组合上不允许有空值，也不允许有重复值。
--主键可以用来在表中唯一的确定一行数据。一个表上只允许建立一个主键，而其它约束条件则没有明确的个数限制。

2.4.2. 【主键选取的原则】

1、主键应是对系统无意义的数据
2、永远也不要更新主键，让主键除了唯一标识一行之外，再无其他的用途
3、主键不应包含动态变化的数据，如时间戳
4、主键应自动生成，不要人为干预，以免使它带有除了唯一标识一行以外的意义
5、主键尽量建立在单列上

2.4.3. 【添加主键约束】

例 1：在建表时添加主键约束条件：

DROP TABLE employees_Jon
CREATE TABLE employees_Jon (
eid NUMBER(6) PRIMARY KEY,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7, 2),
hiredate DATE
);


例 2：建表后创建主键约束条件，并自定义约束条件名称：

DROP TABLE employees_Jon
CREATE TABLE employees_Jon (
eid NUMBER(6),
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7, 2),
hiredate DATE
);
ALTER TABLE employees_Jon 
ADD CONSTRAINT 
         employees_Jon_eid_pk PRIMARY KEY (eid);
         

2.5. 【外键约束】
2.5.1	【外键约束的意义】

2.5.1	【	添加外键约束】

2.5.3	【外键约束对一致性的维护】

--外键约束条件包括两个方面的数据约束：
--1、从表上定义的外键的列值，必须从主表被参照的列值中选取，或者为NULL；
--2、当主表参照列的值被从表参照时，主表的该行记录不允许被删除。

2.5.4 【外键约束对性能的降低】

--如果在一个频繁DML操作的表上建立外键，
--每次DML操作，都将导致数据库自动对外键所关联的对应表做检查，
--产生开销，如果已在程序中控制逻辑，这些判断将增加额外负担，可以省去。
--另外外键确定了主从表的先后生成关系，有时会影响业务逻辑。

2.5.5	【关联不一定需要外键约束】

--如果业务逻辑要求保证数据完整性，可由程序或触发器控制，不一定需要外键约束。
--另外为了简化开发，维护数据时不用考虑外键约束，以及大量数据DML操作时不需考虑外键耗费时间。


2.6.【检查约束】
 2.6.1	【什么是检查约束】
 检查(Check)约束条件用来强制在字段上的每个值都要满足Check中定义的条件。
 当定义了Check约束的列 【新增】 或 【修改】 数据时，数据必须符合Check约束中定义的条件。
 
 
2.6.2	【添加检查约束】
例 1：员工的薪水必须大于2000元，增加检查约束：
ALTER TABLE employees_Jon
ADD CONSTRAINT employees_Jon_salary_check CHECK (salary > 2000);

例 2：当插入大于2000的数据，操作成功：
INSERT INTO employees_Jon(eid, name, salary) 
VALUES(1236, 'donna noble', 2500);

例 3：试图修改职员的薪水为1500元，更新失败：
UPDATE employees_Jon SET salary = 1500
 WHERE eid = 1236;