package parkinglot;

public class CustomerInfo {
	private long portalId;
	private String name;
	private double wallet;

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
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "CustomerInfo [portalId=" + portalId + ", name=" + name + ", wallet=" + wallet + "]";
	}
	
}
