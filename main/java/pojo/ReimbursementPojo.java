package pojo;

import java.sql.Date;

public class ReimbursementPojo {
	int reimbursementId;
	int requesterId;
	int resolverId;
	Date date;
	String certification;
	String reimbursementAmount;
	String status;

	public ReimbursementPojo() {
	}

	public ReimbursementPojo(int reimbursementId, int requesterId, int resolverId, Date date, String certification,
			String reimbursementAmount, String status) {
		super();

		this.reimbursementId = reimbursementId;
		this.requesterId = requesterId;
		this.resolverId = resolverId;
		this.date = date;
		this.certification = certification;
		this.reimbursementAmount = reimbursementAmount;
		this.status = status;

	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(String reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeePojo [reimbursementId=" + reimbursementId + ", requesterId=" + requesterId + ", resolverId="
				+ resolverId + ", date=" + date + ", certification=" + certification + ", reimbursementAmount="
				+ reimbursementAmount + ", status=" + status + "]";
	}
	
	
}