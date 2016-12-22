package com.servince.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.ano.Service;

import org.apache.tomcat.util.digester.SetRootRule;

import com.servince.model.CertType;
import com.servince.model.City;
import com.servince.model.Province;
import com.servince.model.User;
import com.servince.model.UserType;

public class UserDAOImp implements UserDAO {
	private static Connection conn;

	@SuppressWarnings("static-access")
	public UserDAOImp(Connection conn) {
		this.conn = conn;
	}

	public UserDAOImp() {
	}

	@Override
	public void saveUser(User user) {
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("insert into tab_user values (seq_user.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRule());
			ps.setString(4, user.getRealname());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getCity().getCityID());
			ps.setInt(7, user.getCert_type().getId());
			ps.setString(8, user.getCert());
			ps.setDate(9, user.getBirthday());
			ps.setInt(10, user.getUser_type().getId());
			ps.setString(11, user.getContent());
			ps.setString(12, user.getStatus());
			ps.setString(13, user.getLogin_ip());
			ps.setString(14, user.getImage_path());

			// execute
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUser(String username) {
		try {
			String sql = "delete from tab_user where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
			System.out.println("Delete successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User login(String username, String password) {
		User LoginUser = new User();
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			String sql = "select t_user.*,city.city cityname,ct.content certtype,ut.content usertype,pro.provinceId province "
					+ "from tab_user t_user,tab_city city,tab_certtype ct,tab_province pro,tab_usertype ut "
					+ "  where t_user.city = city.cityID and t_user.cert_type = ct.id and t_user.user_type = ut.id "
					+ "and city.father = pro.provinceID and username = ? and password = ? and status = 1";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			result = ps.executeQuery();
			while (result.next()) {
						LoginUser.setUsername(result.getString("username"));
						LoginUser.setPassword(result.getString("password"));
						LoginUser.setRule(result.getString("rule"));
						LoginUser.setRealname(result.getString("realname"));
						LoginUser.setSex(result.getString("sex"));
						
						City city = new City();
						Province provinces = new Province();
						city.setCity(result.getString("cityname"));
						provinces.setProvinceID(result.getString("province"));
						city.setPro(provinces);
						LoginUser.setCity(city);
						
						CertType certty = new CertType();
						certty.setContent(result.getString("certtype"));
						LoginUser.setCert_type(certty);
						
						LoginUser.setCert(result.getString("cert"));
						LoginUser.setBirthday(result.getDate("birthday"));
						
						UserType userty = new UserType();
						userty.setContent(result.getString("usertype"));
						LoginUser.setUser_type(userty);
						
						LoginUser.setContent(result.getString("content"));
						LoginUser.setStatus(result.getString("status"));
						LoginUser.setLogin_ip(result.getString("login_ip"));
						LoginUser.setImage_path(result.getString("image_path"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
				System.out.println("DateBase Close!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return LoginUser;
	}

	@Override
	public void modifyUserDate(String username) {
		
	}

	@Override
	public List<User> seleteUserDate(User user) {
		List<User> listUser = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			StringBuffer sql_sb = new StringBuffer();
			sql_sb.append ("select t_user.*,ct.content certtype,ut.content usertype ");
			sql_sb.append (" from tab_user t_user,tab_certtype ct,tab_usertype ut ");
			sql_sb.append ( "  where t_user.cert_type = ct.id and t_user.user_type = ut.id ");
			sql_sb.append (" and t_user.status = 1");
			
			if (user.getRealname() != null){
				sql_sb.append(" and t_user.realname = ?");
			}
			if (user.getSex() != null){
				sql_sb.append(" and t_user.sex = ?");
			}
			if(user.getCert_type() != null){
					sql_sb.append(" and t_user.cert_type = ?");
			}
			if(user.getCert() != null) {
				sql_sb.append(" and t_user.cert = ?");
			}
			if(user.getUser_type() != null){
					sql_sb.append(" and t_user.user_type = ?");
			}
			
			ps = conn.prepareStatement(sql_sb.toString());
			int flag =1;
			if (user.getRealname() != null){
				ps.setString(flag++, user.getRealname());
			}
			if (user.getSex() != null){
				ps.setString(flag++, user.getSex());
			}
			if (user.getCert_type() != null){
					ps.setInt(flag++, user.getCert_type().getId());
			}
			if (user.getCert() != null){
				ps.setString(flag++, user.getCert());
			}
			if (user.getUser_type() != null){
					ps.setInt(flag++, user.getUser_type().getId());
			}
			
			result = ps.executeQuery();
			while (result.next()) {
				user.setUsername(result.getString("username"));
				user.setRealname(result.getString("realname"));
				user.setSex(result.getString("sex"));
				
				CertType certty = new CertType();
				certty.setContent(result.getString("certtype"));
				user.setCert_type(certty);
				
				user.setCert(result.getString("cert"));		
				user.setBirthday(result.getDate("birthday"));
				
				UserType userty = new UserType();
				userty.setContent(result.getString("usertype"));
				user.setUser_type(userty);
				
				System.out.println("Select end!");
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (result != null) {
					result.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
				System.out.println("DateBase Close!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listUser;
	}

}
