package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.ReimbursementPojo;

public interface ReimbursementDao {
	ReimbursementPojo addReimbursement(ReimbursementPojo reimbursementPojo)throws ApplicationException;
	List<ReimbursementPojo> getEmployeePendingReimbursements(int requesterId)throws ApplicationException;
	List<ReimbursementPojo> getEmployeeResolvedReimbursements(int requesterId)throws ApplicationException;
	List<ReimbursementPojo> allReimbursements() throws ApplicationException; 
	List<ReimbursementPojo> viewAllPendingReimbursements() throws ApplicationException;
	List<ReimbursementPojo> viewAllResolvedReimbursements() throws ApplicationException;
	 ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	void exitApplication(); 
}

