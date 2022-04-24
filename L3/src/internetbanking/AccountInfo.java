package internetbanking;

public class AccountInfo 
{
	private long accountId;
	private String accountType;
	private double balance;
	private String branch;
	private long customerId;
	
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "AccountInfo [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance
				+ ", branch=" + branch + ", customerId=" + customerId + "]";
	}
	
	
}
