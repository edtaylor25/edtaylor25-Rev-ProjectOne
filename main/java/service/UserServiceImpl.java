package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import dao.UserDao;
import dao.UserDaoJdbcImp;
import exception.ApplicationException;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	UserDao userDao; 
	public UserServiceImpl() {
		this.userDao = new UserDaoJdbcImp();
		
	}

	
	@Override
	public UserPojo register(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered register() in service.");
		UserPojo returnUserPojo = this.userDao.register(userPojo);
		logger.info("Exited register() in service.");
		return returnUserPojo;	
	}


	@Override
	public UserPojo validate(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered validateUser() in service.");
		UserPojo returnUserPojo = this.userDao.validate(userPojo);
		logger.info("Exited validateUser() in service.");
		return returnUserPojo;	
	}

	@Override
	public List<UserPojo> getAllUsers() throws ApplicationException {
		logger.info("Entered getAllUsers() in service.");
		List<UserPojo>getAllUsers = this.userDao.getAllUsers();
		logger.info("Exited getAllUsers() in service.");
		return getAllUsers;	
	}

	@Override
	public UserPojo updateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered updateUser() in service.");
		UserPojo returnUserPojo = this.userDao.updateUser(userPojo);
		logger.info("Exited updateUser() in service.");
		return returnUserPojo;	
	}


}
