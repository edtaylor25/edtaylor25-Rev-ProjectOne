package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.UserPojo;

public class UserDaoJdbcImp implements UserDao {
	
	private static final Logger logger = LogManager.getLogger(UserDaoJdbcImp.class);

	public UserPojo register(UserPojo userPojo) throws ApplicationException {
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into user_details(username, password, first_name, last_name, email, role)" 
					+ "values('"+userPojo.getUsername()+"','"+userPojo.getPassword()
					+"','"+userPojo.getFirstName()+"','"+userPojo.getLastName()
					+"','"+userPojo.getEmail()+"','"+userPojo.getRole()+"') returning user_id";
			
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			userPojo.setUserId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited register() in dao.");
		return userPojo;
	}

	public UserPojo validate(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered validateUser() in dao");
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from user_details where username='"+userPojo.getUsername()
							+"' and password='"+userPojo.getPassword()+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				userPojo.setUsername(rs.getString(2));
				userPojo.setPassword(rs.getString(3));
				userPojo.setFirstName(rs.getString(4));
				userPojo.setLastName(rs.getString(5));
				userPojo.setEmail(rs.getString(6));
				userPojo.setRole(rs.getInt(7));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited validateUser() in dao.");
		return userPojo;
	}

	public List<UserPojo> getAllUsers() throws ApplicationException {
		logger.info("Entered getAllUsers() in dao.");
		List<UserPojo> allUsers = new ArrayList<UserPojo>();
		
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from user_details where role=2";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				UserPojo userPojo = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				allUsers.add(userPojo);
			}
		}catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllUsers() in dao.");
		return allUsers;
	}

	public UserPojo updateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered updateUser() in dao.");
		
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update user_details set email='"+userPojo.getEmail()+"' where user_id="+userPojo.getUserId();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited updateUser() in dao.");
		return userPojo;
	}

}
