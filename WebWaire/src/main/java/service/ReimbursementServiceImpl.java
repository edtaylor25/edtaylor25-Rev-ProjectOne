package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import dao.ReimbursementDao;
import dao.ReimbursementDaoJbdcImp;
import exception.ApplicationException;
import pojo.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService {

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ReimbursementServiceImpl.class);
	
	ReimbursementDao reimbursementDao;
	
	public ReimbursementServiceImpl() {
		this.reimbursementDao = new ReimbursementDaoJbdcImp();
	}

	public ReimbursementPojo addReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered addReimbursement() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.addReimbursement(reimbursementPojo);
		logger.info("Exited addReimbursement() in service.");
		return returnReimbursementPojo;
	}
	public List<ReimbursementPojo> getEmployeePendingReimbursements(int requesterId) throws ApplicationException {
		logger.info("Entered pendingReimbursement() in service.");
		List<ReimbursementPojo> pendingReimbursement = this.reimbursementDao.getEmployeePendingReimbursements(requesterId);
		logger.info("Exited pendingReimbursement() in service.");
		return pendingReimbursement;
	}
	public List<ReimbursementPojo> getEmployeeResolvedReimbursements(int requesterId) throws ApplicationException {
		logger.info("Entered resolvedReimbursement() in service.");
		List<ReimbursementPojo> resolvedReimbursement = this.reimbursementDao.getEmployeeResolvedReimbursements(requesterId);
		logger.info("Exited resolvedReimbursement() in service.");
		return resolvedReimbursement;
	}

	public List<ReimbursementPojo> allReimbursements() throws ApplicationException {
		logger.info("Entered allReimbursements() in service.");
		List<ReimbursementPojo> allReimbursements = this.reimbursementDao.allReimbursements();
		logger.info("Exited resolvedReimbursement() in service.");
		return allReimbursements;
	}
	public List<ReimbursementPojo> viewAllPendingReimbursements() throws ApplicationException {
		logger.info("Entered viewAllpendingReimbursement() in service.");
		List<ReimbursementPojo> viewAllPendingReimbursements = this.reimbursementDao.viewAllPendingReimbursements();
		logger.info("Exited viewAllPendingReimbursement() in service.");
		return viewAllPendingReimbursements;
	}

	public List<ReimbursementPojo> viewAllResolvedReimbursements() throws ApplicationException {
		logger.info("Entered viewAllResolvedReimbursements() in service.");
		List<ReimbursementPojo> viewAllResolvedReimbursements = this.reimbursementDao.viewAllResolvedReimbursements();
		logger.info("Exited viewAllResolvedReimbursements() in service.");
		return viewAllResolvedReimbursements;
	}

	@Override
	public ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursmentPojo) throws ApplicationException {
		logger.info("Entered updateReimbursement() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.updateReimbursement(reimbursmentPojo);
		logger.info("Exited updateReimbursement() in service.");
		return returnReimbursementPojo;
	}


	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		reimbursementDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
		
	}

	


}