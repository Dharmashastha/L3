package internetbanking;

public class CustomerInfo 
{
	private String name;
	private String eMailId;
	private long phoneNumber;
	private String Address;
	private long customerId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMailId() {
		return eMailId;
	}
	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "CustomerInfo [name=" + name + ", eMailId=" + eMailId + ", phoneNumber=" + phoneNumber + ", Address="
				+ Address + ", customerId=" + customerId + "]";
	}
	
}
