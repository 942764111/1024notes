package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC java数据库连接
 * JDBC是一套标准的接口，规定了连接数据库的
 * 相关步骤和功能。不同的数据库厂商都实现了
 * 一套该接口的实现类用于操作其数据库。这套
 * 实现类也称为该数据库的驱动。
 * JDBC中主要接口:
 * DriverManager:用于加载驱动，建立连接Connection
 * Connection:表示与数据库的一个会话连接，用来管理
 * 事物，创建执行语句对象Statement
 * Statement:用来执行SQL语句
 * ResultSet:若执行的是DQL语句，则会获得结果集。
 *      
 * 访问数据库的大致步骤:
 * 1:加载驱动(Class.forName())
 * 2:建立连接(DriverManager.getConnection())
 * 3:创建执行语句对象(Statement)          
 * 4:执行SQL
 * 5:处理结果集(ResultSet),前提是执行的DQL语句          
 * 6:关闭连接释放资源          
 * @author adminitartor
 *
 */
public class JDBCDemo1 {
	public static void main(String[] args) {
		
		try {
			//1 不同数据库，驱动名不同
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			/*
			 * 2建立连接
			 * DriverManager.getConnection()
			 * 该方法有三个参数
			 * 1:数据库地址(不同数据库格式不完全一样)
			 * 2:数据库用户名
			 * 3:数据库密码
			 *  
			 */
			Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.227:1521:orcl",
				"openlab","open123"
		    );
			System.out.println("与数据库建立连接!");
			
			//3
			Statement state = conn.createStatement();
			
			/*
			 * 4 执行SQL语句
			 * 
			 * int executeUpdate(String sql)
			 * 专门用来指定DML语句，返回值为执行后影响了
			 * 表中的记录数
			 * 
			 * ResultSet executeQuery(String sql)
			 * 专门用来执行DQL语句，返回值为查询的结果集
			 * 
			 * boolean execute(String sql)
			 * 任何SQL都可以用来执行，但是由于DML,DQL有
			 * 专门的方法，所以该方法通常用来执行DDL语句。
			 * 返回值为true时说明执行SQL语句后有查询结果集。
			 */
			/*
			 * 创建表userinfo
			 * 字段:
			 * id NUMBER(5)
			 * username VARCHAR2(30)
			 * password VARCHAR2(30)
			 * email VARCHAR2(50)
			 * nickname VARCHAR2(30)
			 * account NUMBER(17,2)
			 * 
			 * CREATE TABLE userinfo(
			 * 	id NUMBER(5),
			 * 	username VARCHAR2(30),
			 * 	password VARCHAR2(30),
			 * 	email VARCHAR2(50),
			 * 	nickname VARCHAR2(30),
			 * 	account NUMBER(17,2)
			 * )
			 */
			String sql = "CREATE TABLE userinfo( "+
						 " 	id NUMBER(5), "+
			             "	username VARCHAR2(30), "+
			             " 	password VARCHAR2(30), "+
			             "  email VARCHAR2(50), "+
			             "  nickname VARCHAR2(30), "+
			             "  account NUMBER(17,2) "+
			             ")";
			System.out.println(sql);
			state.execute(sql);
			System.out.println("执行SQL完毕！");
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







