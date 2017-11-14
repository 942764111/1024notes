package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import day01.UserInfo;
import day02.DBUtil;

/**
 * DAO 数据连接对象 data access object
 * DAO处于数据持久层
 * 用来将业务逻辑与数据操作分离。也使得业务逻辑对于
 * 数据持久操作可以面向对象化。
 * 
 * UserInfoDAO 针对用户信息的相关操作
 * @author adminitartor
 *
 */
public class UserInfoDAO {
	/**
	 * 将给定的用户信息保存
	 * @param userInfo
	 */
	public void save(UserInfo userInfo){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO userinfo "
					   + "(id,username,password,email,nickname,account) "
					   + "VALUES "
					   + "(seq_userinfo_id.NEXTVAL,?,?,?,?,?)";
			
			PreparedStatement ps
				= conn.prepareStatement(sql,new String[]{"id"});
			ps.setString(1, userInfo.getUsername());
			ps.setString(2, userInfo.getPassword());
			ps.setString(3, userInfo.getEmail());
			ps.setString(4, userInfo.getNickname());
			ps.setInt(5, userInfo.getAccount());
			
			int d = ps.executeUpdate();
			if(d>0){
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				int id = rs.getInt(1);
				userInfo.setId(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
	}
	
	/**
	 * 根据ID删除对应用户
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id){
		return false;
	}
	/**
	 * 根据给定的用户信息对其进行修改
	 * @param userInfo
	 * @return
	 */
	public boolean update(UserInfo userInfo){
		return false;
	}
	/**
	 * 根据给定ID获取对应用户信息
	 * @param id
	 * @return
	 */
	public UserInfo findById(int id){
		return null;
	}
	/**
	 * 查询所有员工信息
	 * @return
	 */
	public List<UserInfo> findAll(){
		return null;
	}
	
	/**
	 * 根据给定的用户名查找用户信息
	 * @param username
	 * @return
	 */
	public UserInfo findByUsername(String username){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT id,username,password,email,nickname,account "
					   + "FROM userinfo "
					   + "WHERE username=?";
			PreparedStatement ps
				= conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				int account = rs.getInt("account");
				UserInfo userInfo = new UserInfo(id, user, password, email, nickname, account);
				return userInfo;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
		return null;
	}
}









