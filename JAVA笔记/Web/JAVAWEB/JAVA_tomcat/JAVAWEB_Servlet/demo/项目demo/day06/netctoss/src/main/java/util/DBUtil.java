package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 使用该类完成数据库连接的管理工作
 * @author adminitartor
 *
 */
public class DBUtil {
	private static BasicDataSource dataSource;
	private static ThreadLocal<Connection> tl;
	
	static{
		try {
			tl = new ThreadLocal<Connection>();
			Properties prop = new Properties();
			//prop.load(new FileInputStream("config.properties"));
			prop.load(DBUtil.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			String driverName = prop.getProperty("driver");
			String host = prop.getProperty("host");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			int maxActive = Integer.parseInt(
				prop.getProperty("maxactive")
			);
			int maxWait = Integer.parseInt(
				prop.getProperty("maxwait")	
			);
			
			//初始化数据库连接池
			dataSource = new BasicDataSource();
			//设置驱动名(原Class.forName()中的内容)
			dataSource.setDriverClassName(driverName);
			//设置数据库地址，用户名，密码
			dataSource.setUrl(host);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			
			dataSource.setMaxActive(maxActive);
			dataSource.setMaxWait(maxWait);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取一个数据库连接
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection conn = dataSource.getConnection();
		/*
		 * 将当前线程创建的数据库连接存入到ThreadLocal
		 * ThreadLocal的内部有一个Map，其中key是
		 * 调用set方法的线程，value是set方法传入的
		 * 当前线程要保存的值
		 */
		tl.set(conn);
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void closeConnection(){
		try {
			/*
			 * 调用ThreadLocal的get方法的线程在获取
			 * 值时，ThreadLocal会用当前这个线程作为
			 * key取内部Map中对应的value
			 */
			Connection conn = tl.get();
			if(conn!=null){
				conn.close();
			}
			tl.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 开启事务
	 * @throws SQLException
	 */
	public static void TransBegin() throws SQLException{
		Connection conn = tl.get();
		conn.setAutoCommit(false);
	}
	/**
	 * 关闭事务
	 * @throws SQLException 
	 * 
	 */
	public static void TransEnd() throws SQLException{
		Connection conn = tl.get();
		conn.setAutoCommit(true);
	}
	/**
	 * 提交事务
	 * @throws SQLException 
	 */
	public static void commit() throws SQLException{
		Connection conn = tl.get();
		conn.commit();
	}
	/**
	 * 回滚事务
	 * @throws SQLException
	 */
	public static void rollback() throws SQLException{
		Connection conn = tl.get();
		conn.rollback();
	}
	
	public static void main(String[] args) 
		throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.closeConnection();
	}
	
}





