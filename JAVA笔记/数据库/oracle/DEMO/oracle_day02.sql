DQL ��ѯ���

��ѯ�����뺬�е������Ӿ�:
1:SELECT�Ӿ�
SELECT�Ӿ�����ָ��Ҫ��ѯ���ֶ�
2:FROM�Ӿ�
FROM�Ӿ�����ָ��������Դ�ı�

SELECT * FROM emp

SELECT ename,job,sal,deptno
FROM emp

SELECT�Ӿ���˿���ֱ��ʹ�ñ��е�
�ֶ���,�������Ǻ���,���ʽ.

�鿴ÿ��Ա������н?
SELECT ename,sal,sal*12
FROM emp


��ѯ�����Ҳ�������WHERE�Ӿ���
ָ����������.�Ӷ�ֻ������������
�ļ�¼.

�鿴ְλ��MANAGER��Ա��?
SELECT ename,job,sal,deptno
FROM emp
WHERE job='MANAGER'

��������:>,>=,<,<= �� JAVAһ��.
��Ҫ����:"="��ʾ����,"<>"��ʾ������

�鿴MANAGERְλ���������Ա��?
SELECT ename,job
FROM emp
WHERE job<>'MANAGER'


�ַ�������:

�ַ������ӷ�"||"
�ַ������Ӻ���CONCAT(c1,c2)
SELECT CONCAT(ename,sal)
FROM emp

SELECT CONCAT(CONCAT(ename,','),sal)
FROM emp

SELECT ename||','||sal
FROM emp


LENGTH(c)
�鿴�ַ����ַ�����(����)
SELECT ename,LENGTH(ename)
FROM emp

SELECT ename
FROM emp
WHERE LENGTH(ename)=6


UPPER,LOWER,INITCAP����
���ַ���ת��Ϊȫ��д,ȫСд,����ĸ
��д
SELECT UPPER('helloworld'),
       LOWER('HELLOWORLD'),
       INITCAP('HELLO WORLD')
FROM dual

dual:α��,��Ҫ��ѯ���������κα��޹�
ʱ,����ʹ��α��

SELECT ename,job,deptno
FROM emp
WHERE ename=UPPER('scott')




TRIM,LTRIM,RTRIM
ȥ���ַ�������ָ�����ظ��ַ�
LTRIM��ȥ�����,RTRIMȥ���Ҳ�

SELECT 
  TRIM('e' FROM 'eeeliteee')
FROM dual

SELECT
  LTRIM('esffesliteseseses','efs')
FROM dual

LPAD,RPAD
��λ����
LPAD(c1,n,c2)
��c1��ʾΪnλ����,����ʱ��ಹ��
����c2�Դﵽnλ����
SELECT ename,LPAD(sal,6,'$')
FROM emp



SUBSTR(c,m[,n])
��ȡ�ַ���
m��ʾ�ӵڼ����ַ���ʼ��ȡ
n��ʾ��ȡ���ٸ��ַ�,n��ָ��,��
�ǽ�ȡ���ַ���ĩβ,n�����߿��Խ�
ȡ���ַ�����Ҳ�ǽ�ȡ���ַ���ĩβ

��Ҫע��,���ݿ����±��1��ʼ.

λ����Ϊ����,���Ǵӵ���λ�ÿ�ʼȡ
SELECT 
  SUBSTR('thinking in java',-7,2)
FROM 
  dual


INSTR(c1,c2[,m[,n]])
�鿴c2��c1�е�λ��
m��ʾ�ӵڼ����ַ���ʼ����,��д���1��ʼ
n��ʾ�ڼ��γ���,��д��Ϊ1

SELECT 
 INSTR('thinking in java','in',4,2)
FROM 
 dual


��ֵ����
ROUND(n[,m])
��������
��n��������,����С�����
mλ.
m��ָ������0,��ʾ����������λ
mΪ�������Ǳ���ʮλ��������.
SELECT ROUND(45.678, 2) FROM DUAL
SELECT ROUND(45.678, 0) FROM DUAL
SELECT ROUND(45.678, -1) FROM DUAL


TRUNC����
��ȡ����,����������ROUND����һ��
SELECT TRUNC(45.678, 2) FROM DUAL
SELECT TRUNC(45.678, 0) FROM DUAL
SELECT TRUNC(45.678, -1) FROM DUAL

MOD(m,n)����,����
����ԭ�� m/n
n��Ϊ0,��ֱ�ӷ���m
SELECT ename, sal, MOD(sal, 1000) 
FROM emp


CEIL,FLOOR
����ȡ��������ȡ��
SELECT CEIL(45.678) FROM DUAL; --46?
SELECT FLOOR(45.678) FROM DUAL;--45


������عؼ���
SYSDATE,SYSTIMESTAMP
��Ӧ���ú���,���ص�ǰϵͳʱ��

SELECT SYSDATE FROM dual
SELECT SYSTIMESTAMP FROM dual

����ת������
TO_DATE()
��һ���ַ�������Ϊһ��DATE����ֵ
SELECT 
 TO_DATE('2008-08-08 20:08:08',
         'YYYY-MM-DD HH24:MI:SS')
FROM dual

DATE�����ݿ����ǿ����������
��һ��DATEֵ�Ӽ�һ������,��ͬ�ڼӼ���
��������֮����м���,��Ϊ������
���ڼ���ԱȽϴ�С,Խ���Խ��

SELECT SYSDATE+1
FROM dual

�鿴ÿ��Ա����ְ�����������?
SELECT ename,SYSDATE-hiredate
FROM emp

���ڸ�ʽ�ַ����з�����Ӣ��,����,���ֵ�
�����ַ���Ҫʹ��˫����������
SELECT 
 TO_DATE('2008��08��08�� 20:08:08',
         'YYYY"��"MM"��"DD"��" HH24:MI:SS')
FROM dual


TO_CHAR����
��������DATEת��Ϊһ���ַ���

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
���ظ������������µ��µ�����

�鿴�����µ�?
SELECT LAST_DAY(SYSDATE)
FROM dual


ADD_MONTHS(date,i)
�Ը������ڼ���ָ������,��iΪ�������Ǽ�ȥ

�鿴ÿ��Ա����ְ20���������
SELECT 
 ename,ADD_MONTHS(hiredate,12*20)
FROM
 emp

MONTHS_BETWEEN(d1,d2)
������������֮��������

�鿴ÿ��Ա����ְ������ٸ�����?
SELECT 
 ename,MONTHS_BETWEEN(SYSDATE,hiredate)
FROM
 emp


NEXT_DAY(date,i)
���ظ������ڵڶ��쿪ʼһ���ڵ��ܼ�
����Ӧ������
i�ķ�Χ1-7,�ֱ��ʾ����,��һ...����

SELECT NEXT_DAY(SYSDATE,3)
FROM dual


LEAST��GREATEST
��Сֵ�����ֵ

SELECT 
 LEAST(SYSDATE, TO_DATE('2008-10-10','YYYY-MM-DD')) 
FROM dual




EXTRACT(date FROM datetime)
��ȡ������������Ӧʱ�������ֵ

�鿴1980����ְ��Ա������Щ?
SELECT ename,hiredate
FROM emp
WHERE EXTRACT(YEAR FROM hiredate)=1980



CREATE TABLE student(
  id NUMBER(4), 
  name CHAR(20), 
  gender CHAR(1) NOT NULL
);

INSERT INTO student VALUES(1000, '��Ī��', 'F');

INSERT INTO student VALUES(1001, '��ƽ֮', NULL);

INSERT INTO student(id, name) VALUES(1002, '���޼�');

SELECT * FROM student


���³�NULL
UPDATE student
SET gender=NULL

SELECT * FROM student

ɾ���Ա�ΪNULL�ļ�¼
DELETE FROM student
WHERE gender IS NULL


NULL���ַ�������,�������ʲô��û��.
NULL����������,���ΪNULL.

�鿴ÿ��Ա�����������(����+��Ч)
SELECT ename,sal,comm,sal+comm
FROM emp


��ֵ����
NVL(a1,a2)
��a1ΪNULLʱ,��������a2��ֵ
��a1��ΪNULLʱ,��������a1����
���Ըú����������ǽ�NULLֵ�滻Ϊ��NULLֵ

SELECT 
 ename,sal,comm,
 sal+NVL(comm,0)
FROM
 emp

�鿴ÿ���˵ļ�Ч���
����Ա���м�Ч����ʾΪ"�м�Ч",ΪNULL��
����ʾΪ"û�м�Ч"

NVL2(a1,a2,a3)
��a1��ΪNULLʱ,��������a2
��a1ΪNULLʱ,��������a3

SELECT 
 ename,comm,NVL2(comm,'�н���','û�н���')
FROM 
 emp

SELECT 
  ename,sal+NVL2(comm,comm,0)
FROM
  emp






