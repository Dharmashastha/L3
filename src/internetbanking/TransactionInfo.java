package internetbanking;

public class TransactionInfo 
{
	private long transactionId;
	private long fromAccount;
	private long toAccount;
	private Object dateAndTime;
	private double amount;
	private char transactionType;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public Object getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Object dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public char isTransactionType() {
		return transactionType;
	}
	public void setTransactionType(char transactionType) {
		this.transactionType = transactionType;
	}
	
	
	@Override
	public String toString() {
		return "TransactionInfo [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", dateAndTime=" + dateAndTime + ", amount=" + amount + ", transactionType="
				+ transactionType + "]";
	}
	
	
	
	
}
