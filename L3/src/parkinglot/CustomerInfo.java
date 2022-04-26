package parkinglot;

public class CustomerInfo {
	private long portalId;
	private String name;
	private double storedPay;

	public long getPortalId() {
		return portalId;
	}
	public void setPortalId(long portalId) {
		this.portalId = portalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getStoredPay() {
		return storedPay;
	}
	public void setStoredPay(double storedPay) {
		this.storedPay = storedPay;
	}
	
	@Override
	public String toString() {
		return "CustomerInfo [portalId=" + portalId + ", name=" + name + ", storedPay=" + storedPay + "]";
	}
	
}
