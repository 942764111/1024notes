SQL��䱾���ǲ����ִ�Сд��,����Ϊ��
��ǿ�ɶ���,ͨ���Ὣ�ؼ�����ǹؼ���
����,���йؼ��ִ�д.
SELECT SYSDATE FROM dual

DDL��� ���ݶ�������
������ɾ�����ݿ����
���ݿ����:��,��ͼ,����,����

������:
CREATE���

CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)


�鿴��ṹ
DESC table_name
��:
DESC employee

���ݿ���,�����ֶε�Ĭ��ֵ����NULL.
����ʹ��DEFAULTΪ�ֶε���ָ��Ĭ��ֵ.

�����ݿ���,�ַ�������������ʹ�õ�����
��������,�����ַ������������ִ�Сд��.

ɾ����
DROP TABLE table_name
DROP TABLE employee

NOT NULLԼ��
NOT NULLҪ��ָ���ֶα����ֵ.
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


�޸ı�
1:�޸ı���
2:�޸ı�ṹ

�޸ı���
RENAME old_name TO new_name

RENAME employee TO myemp

DESC myemp

�޸ı�ṹ
1:������ֶ�
2:�޸������ֶ�
3:ɾ���ֶ�

1:������ֶ�
ALTER TABLE myemp
ADD(
  hiredate DATE DEFAULT SYSDATE
)
��ӵ��ֶλᱻ׷�ӵ�������.
SYSDATE��ORACLE�ж�Ӧһ�����ú���,����
һ��DATE���͵ĵ�ǰϵͳʱ���ֵ.



2:�޸��ֶ�
�����޸ı��ֶε�����,����,Ĭ��ֵ,�ǿ�.

������Ҫ�ڱ��к������ݺ��޸�,���������,
��ô�������޸�����,���Ⱦ�������С,����
�����޸�ʧ��.

ALTER TABLE myemp
MODIFY(
  job VARCHAR2(40) DEFAULT 'CLERK' 
)

ɾ���ֶ�
ALTER TABLE myemp
DROP(hiredate)


DML ���ݲ�������
������,ɾ,�ı������ݵ�.

���������:INSERT���

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

�޸�����:UPDATE ���
UPDATE myemp
SET salary=8000,deptno=20
WHERE name='JACK'

UPDATE���ͨ��Ҫ���WHERE�Ӿ�,��
�޶�ֻ�޸ı�������WHERE����Ҫ���
��¼,������ȫ�����!

ɾ������:DELETE���
DELETE FROM myemp
WHERE name='JACK'

�����WHERE�Ӿ�����ձ����!




























