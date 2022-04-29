package parkinglot;

public class CustomerInfo {
	private long portalId;
	private String name;
	private double wallet;
	private String vehicleNumber;
	private long phoneNumber;

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
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerInfo [portalId=" + portalId + ", name=" + name + ", wallet=" + wallet + ", vehicleNumber="
				+ vehicleNumber + ", phoneNumber=" + phoneNumber + "]";
	}

}
