package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserDao {
	
	UserPojo register(UserPojo userPojo) throws ApplicationException;
	UserPojo validate(UserPojo userPojo) throws ApplicationException;
	List<UserPojo> getAllUsers() throws ApplicationException; 
	UserPojo updateUser(UserPojo userPojo) throws ApplicationException;

}
