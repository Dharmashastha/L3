package internetbanking;

public class OpenAccount 
{
	private String name;
	private long phoneNumber;
	private String eMail;
	private long accountId;
	private String password;
	private boolean role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "OpenAccount [name=" + name + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", accountId="
				+ accountId + ", password=" + password + "]";
	}
	
	
}
