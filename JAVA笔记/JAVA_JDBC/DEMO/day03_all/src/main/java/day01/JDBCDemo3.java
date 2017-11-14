package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 指定DQL语句
 * @author adminitartor
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.227:1521:orcl",
				"openlab","open123"
		    );
			Statement state = conn.createStatement();
			
			/*
			 * SELECT empno,ename,job,sal,deptno
			 * FROM emp
			 */
			String sql = "SELECT empno,ename,job,sal,deptno "
					   + "FROM emp_wh ";
			
			System.out.println(sql);
			
			ResultSet rs = state.executeQuery(sql);
			/*
			 * boolean next()
			 * 使结果集指针向下移动并指向下一条记录。
			 * 若达到结果集末尾，则返回值为false
			 */
			while(rs.next()){
				/*
				 * ResultSet提供了获取不同数据类型的
				 * 指定字段值。其中参数为字段名。
				 * 也支持一个参数为数字的方法，其数字
				 * 表示第几个字段，从1开始。
				 * 例如:
				 * 结果集第一个字段为empno,是一个整数字段
				 * 那么可以用:
				 * int empno = rs.getInt("empno");
				 * 或
				 * int empno = rs.getInt(1);
				 */
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				int deptno = rs.getInt("deptno");
				System.out.println(empno+","+ename+","+sal+","+job+","+deptno);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
