package internetbanking;

public class LoanInfo 
{
	private String loanType;
	private double loanAmount;
	private long loanId;
	private long aadharCard;
	private String processingStatus = "pending";
	private boolean approve = false;

	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	public long getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(long aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getProcessingStatus() {
		return processingStatus;
	}
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	
	@Override
	public String toString() {
		return "Loan [loanType=" + loanType + ", loanAmount=" + loanAmount + ", loanId=" + loanId + ", aadharCard="
				+ aadharCard + ", processingStatus=" + processingStatus + ", approve=" + approve + "]";
	}
}
