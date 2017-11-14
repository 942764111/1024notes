package day02;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 使用该类完成数据库操作
 * @author soft01
 *
 */
public class DBUtil {
	/**
	 *连接池
	 */
	private static BasicDataSource dataSource;
	
	private static ThreadLocal<Connection> tl;
	
	static{
		try {
			tl = new ThreadLocal<Connection>();
			
			Properties prop = new Properties();
			prop.load(new FileInputStream("config.properties"));
			
			String driver = prop.getProperty("driver");
			String host = prop.getProperty("host");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			/**
			 * 最大链接数
			 */
			int maxactive = Integer.parseInt("maxactive");
			/**
			 * 同步阻塞时间
			 */
			int maxwait = Integer.parseInt("maxwait");
			/**
			 * 初始化连接池
			 */
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(host);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			dataSource.setMaxActive(maxactive);
			dataSource.setMaxWait(maxwait);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection conn =  dataSource.getConnection();
		System.out.println("与数据库建立链接！");
		tl.set(conn);
		return conn;
	}
	public static void closeConnection(){
		try {
			if(tl.get()!=null){
				tl.get().close();
			}
			tl.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			DBUtil.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
