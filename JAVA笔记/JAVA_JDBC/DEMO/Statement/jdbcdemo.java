package day01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * 1、JDBC执行SQL语句后是默认提交数据的
 * 
 * JDBC java数据库链接
 * JDBC是一套标准的接口，规定了链接数据库的相关步骤和功能。不同数据库厂商都实现了一套该接口
 * 实现类用于操作其数据库。这套实现类也称为该数据库的驱动。
 * JDBC 中主要接口：
 * DriverManager:用于加载驱动，建立链接Connection
 * Connection: 表示与数据库的一个会话链接，用来管理事物，创建执行语句对象 Statement
 * Statement：用来执行SQL语句
 * ResultSet：若执行的是DQL语句，则会获得结果集
 * @author soft01
 * 访问数据库的大致步骤：
 * 1：加载驱动(Class.forName())
 * 2：建立链接(DriverManager.getConnection())
 * 3:创建执行语句对象(Statement)
 * 4:执行SQL
 * 5:处理结果集(ResultSet),前提是执行的DQL语句
 * 6:关闭链接释放资源
 *
 */
public class jdbcdemo {            
	static String Type = "查找表值";
	static String TableName = "userinfo_JONBIN";
	static String SEQUENCEName = "seq_userinfo_JONBIN_id";
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1不同数据库，启动名不同
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/*
			 * 2建立链接
			 * DriverManager.getConnection()
			 * 该方法有三个参数：
			 * 1：数据库地址（不同数据库格式不完全一样）
			 * 2：数据库用户名
			 * 3：数据库密码
			 */
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.201.229:1521:orcl",
					"openlab", "open123");
			System.out.println("与数据库建立链接！");
			//3
			Statement state = conn.createStatement();
		
			/**
			 * 执行SQL语句
			 * 
			 * int executeupdate(String sql)
			 * 专门用来指定DML语句,返回值为执行后影响了表中的记录数
			 * 
			 * ResultSetrs executeQuery(String sql)
			 * 执行DQL语句，返回结果集
			 * 
			 * boolean execute(String sql)
			 * 任何SQL都可以用来执行,但是由于DML，DQL有
			 * 专门的方法,所以该方法通常用来执行DDL语句。
			 * 返回值为TRUE时说明执行SQL语句后有查询结果集
			 * 
			 */
			switch (Type) {
			case "创建表":
				test01(state);
				break;
			case "创建序列":
				test02(state);
				break;
			case "插入值":
				JDBCDemo2(state,"'阿达'", 789, "'942764111@qq.com'", "'天道抽请'");
				break;
			case "查找表值":
				SELECTDEMO(state);
				break;
			case "添加列名":
				AddKey(state,"sal NUMBER(7,2)");
				break;
			case "查看表结构":
				FindkeysType(state);
				break;
			case "分页查询":
				test04(state,1,3);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 创建表 userinfo
	 * 字段:
	 * id QLException NUMBER（5）
	 * username VARHAR2(30)
	 * password VARHAR2(30)
	 * emmail VARHAR2(50)
	 * nickname VARHAR2(30)
	 * account NUMBER(17,2)
	 */
//===============================指定DDL语句================================
	// DDL execute
	static void test01(Statement state) throws SQLException{

		String createsql = "CREATE TABLE userinfo_JONBIN( "+
				"id NUMBER(5), "+
				"username VARCHAR2(30), "+
				 "password VARCHAR2(30), "+
				 "emmail VARCHAR2(50), "+
				 "nickname VARCHAR2(30), "+
				 "account NUMBER(17,2) "
				 + ")";
		//1.execute方法，如果执行的sql是查询语句且有结果集则返回true，如果是非查询语句或者没有结果集，返回false
		state.execute(createsql);
		println(createsql);
	}
	/**
	 * 创建序列  seq_userinfo_id_xxxx
	 * 从1开始,步长为1
	 * @throws SQLException 
	 */
	static void test02(Statement state) throws SQLException{
		String sql = "CREATE SEQUENCE seq_userinfo_JONBIN_id "+
					 " START WITH 1 "+
					 " INCREMENT BY 1 ";
			state.execute(sql);
			println(sql);
	}
	
	/**
	 * 添加列名
	 * @throws SQLException 
	 * 
	 */
	static void AddKey(Statement state,String key) throws SQLException{
		//ALTER TABLE TABLENAME ADD((字段列名key) hiredate DATE DEFAULT SYSDATE)

		String sql = "ALTER TABLE "+TableName+" ADD("+key+")";
		state.execute(sql);
		println(sql);
	}
	/**
	 * 查看表key结构
	 * @throws SQLException 
	 */
	static void FindkeysType(Statement state) throws SQLException{
		String sql = "DESC "+TableName;
		state.execute(sql); 
		println(sql);
		state.close();
	}
//===============================指定DML语句================================
	// DML executeUpdate
	/**
	 * 插入
	 * @param state
	 * @throws SQLException
	 */
	static void JDBCDemo2(Statement state,String username,int password,String emmail,String nickname) throws SQLException{
		String sql = "INSERT INTO "+TableName+
				"(id,username,password,emmail,nickname) VALUES "+
				"("+SEQUENCEName+".NEXTVAL,"+username+","+password+","+emmail+","+nickname+")";
		
		int len = state.executeUpdate(sql);
		if(len>0){
			println(sql);
		}
		state.close();
	}
	/**
	 * 要求用户输入用户名,密码,邮箱,昵称
	 * 然后将该用户插入到userinfo表中,其中ID用序列生成,账户金额5000
	 */
	static void test03(){
		
	}
	
//===============================指定DQL语句================================
	//DQL executeQuery();
	/**
	 *  查看表值
	 * @throws SQLException 
	 */
	static void SELECTDEMO(Statement state) throws SQLException{
		String sql = "select * from "+TableName;
		ResultSet rs = state.executeQuery(sql);
		
		if(rs.getFetchSize()>0){
			println(sql);
			while (rs.next()) {
			    System.out.println(rs.getInt("id")+","
			       +rs.getString("username")+","+rs.getString("password")+","+rs.getString("emmail")+","+rs.getString("nickname")+","+rs.getInt("account")+","+rs.getInt("sal") );
			}
		}
		state.close();
	} 
	
/**
 * 分页查询
 * @param state
 * @param page 返回第几页
 * @param pageSize 返回多少行
 * @throws SQLException 
 */
	static void test04(Statement state,int page,int pageSize) throws SQLException{
		  int begin = (page - 1) * pageSize + 1;
		  int end = begin + pageSize - 1;
		  String sql = "SELECT * FROM("
		  		+ "SELECT ROWNUM rn,t.* "
		  		+ "FROM("
		  		+ "SELECT empno,ename,job,sal,depton "
		  		+ "FROM account_Jon ORDER BY sal DESC) t "
				+  "WHERE ROWNUM<="+end+") WHERE rn>="+begin;
		  ResultSet rs = state.executeQuery(sql);
			
			if(rs.getFetchSize()>0){
				println(sql);
				while (rs.next()) {
				    System.out.println(rs.getString("empno")+","
				    +rs.getString("ename")+","+rs.getString("job")+","+rs.getInt("sal")+","+rs.getString("depton"));
				}
			}
			state.close();
	}
	
	static void println(String sql){
		System.out.println("SQL语句：【"+sql+"】   执行成功");
	}
}
