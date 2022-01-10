package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import exception.ApplicationException;
import pojo.ReimbursementPojo;

public class ReimbursementDaoJbdcImp implements ReimbursementDao{
	
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ReimbursementDaoJbdcImp.class);
	
	ReimbursementPojo reimbursementPojo;
	

	public ReimbursementPojo addReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered addReimbursements() in dao.");
		   Connection conn = DBUtil.makeConnection();
		   try {
			   Statement stmt = conn.createStatement();
			   String query = "insert into reimbursements(requester_id, date, Certification, reimbursement_amount, status)" 
			   + "values('"+reimbursementPojo.getRequesterId()+"','"+reimbursementPojo.getDate()+"','"+reimbursementPojo.getCertification()+"','"+reimbursementPojo.getReimbursementAmount()+"','"
			   		+reimbursementPojo.getStatus()+"','"
			   				+reimbursementPojo.getStatus()+"') returning reimbursement_id";
			   ResultSet rs = stmt.executeQuery(query);
			   rs.next();
			   reimbursementPojo.setReimbursementId(rs.getInt(1));
		   } catch (SQLException e) {
			   throw new ApplicationException(e.getMessage());
		   }
		   logger.info("Exited addReimbursement() in dao.");
		   return reimbursementPojo;
	}

	public List<ReimbursementPojo> getEmployeePendingReimbursements(int requesterId) throws ApplicationException {
		logger.info("Entered pendingReimbursements() in dao.");
		List<ReimbursementPojo> getEmployeePendingReimbursements = new ArrayList<ReimbursementPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursement where requester_id="+requesterId+"and status='Pending'";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				getEmployeePendingReimbursements.add(new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			
			}
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited pendingReimbursement() in dao.");
		return getEmployeePendingReimbursements;
	}

	public List<ReimbursementPojo> getEmployeeResolvedReimbursements(int requesterId) throws ApplicationException {
		logger.info("Entered resolvedReimbursements() in dao.");
		List<ReimbursementPojo> getEmployeeResolvedReimbursements = new ArrayList<ReimbursementPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursement where requester_id="+requesterId+ "and status!='Pending'";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				getEmployeeResolvedReimbursements.add(new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
				
			}
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited resolvedReimbursements() in dao.");
		return getEmployeeResolvedReimbursements;
	}


	public List<ReimbursementPojo> allReimbursements() throws ApplicationException {
		logger.info("Entered allReimbursements() in dao.");
		List<ReimbursementPojo> allReimbursements = new ArrayList<ReimbursementPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursement";
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next()) {
						ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
						
						allReimbursements.add(reimbursementPojo);
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited allReimbursements() in dao.");
		return allReimbursements;
	}


	public List<ReimbursementPojo> viewAllPendingReimbursements() throws ApplicationException {
		logger.info("Entered allPendingReimbursements() in dao.");
		List<ReimbursementPojo> allReimbursements = new ArrayList<ReimbursementPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursement where status='Pending'";
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next()) {
						ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
						allReimbursements.add(reimbursementPojo);
					}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited allPendingReimbursements() in dao.");
		return allReimbursements;
	}

	public List<ReimbursementPojo> viewAllResolvedReimbursements() throws ApplicationException {
		logger.info("Entered allResolvedReimbursements() in dao.");
		List<ReimbursementPojo> allReimbursements = new ArrayList<ReimbursementPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursement where status!='Pending'";
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next()) {
						ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
						allReimbursements.add(reimbursementPojo);
					}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited allResolvedReimbursements() in dao.");
		return allReimbursements;
	}

	@Override
	public ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered updateReimbursement() in dao.");
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			
			String query = "update reimbursement set status='"+reimbursementPojo.getStatus()
			+"' where reimbursement_id="+reimbursementPojo.getReimbursementId();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited updateReimbursement() in dao.");
		return reimbursementPojo;
	}
	

	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
		
	}

	
}
