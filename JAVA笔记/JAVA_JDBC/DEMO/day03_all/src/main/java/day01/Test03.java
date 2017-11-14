package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 要求用户输入每页查询的条目数，以及查询的第几页
 * 然后将emp表中对应部分的数据分页查询出来
 * @author adminitartor
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入每页显示的条目数:");
			int pageSize = Integer.parseInt(scanner.nextLine());
			
			System.out.println("请输入页数:");
			int page = Integer.parseInt(scanner.nextLine());
			
			int start = (page-1)*pageSize+1;
			int end = pageSize*page;
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.227:1521:orcl",
				"openlab","open123"
		    );
			Statement state = conn.createStatement();
			
			/*
			 * SELECT * 
			 * FROM(SELECT ROWNUM rn,t.*
			 * 		FROM (SELECT empno,ename,job,sal,deptno
			 *       	  FROM emp) t
			 * 		WHERE ROWNUM<=10)
			 * WHERE rn>=5      
			 */
			String sql = "SELECT * "
					   + "FROM(SELECT ROWNUM rn,t.* "
					   + "	   FROM (SELECT empno,ename,job,sal,deptno "
					   + "			 FROM emp_wh"
					   + "			 ORDER BY sal DESC) t "
					   + "	   WHERE ROWNUM<="+end+") "
					   + "WHERE rn>="+start;
			 	
			System.out.println(sql);
			
			ResultSet rs = state.executeQuery(sql);

			while(rs.next()){
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
