package service;

import java.util.List;

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserService {
	UserPojo register(UserPojo userPojo) throws ApplicationException;
	UserPojo validate(UserPojo userPojo) throws ApplicationException;
	List<UserPojo> getAllUsers() throws ApplicationException; 
	UserPojo updateUser(UserPojo userPojo) throws ApplicationException;

}
