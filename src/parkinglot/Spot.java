package parkinglot;

public class Spot {
	private int floor;
	private int spot;
	private String vehicleType;
	private boolean chargePort;
	private long tokenNumber;

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public boolean isChargePort() {
		return chargePort;
	}

	public void setChargePort(boolean chargePort) {
		this.chargePort = chargePort;
	}

	public long getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(long tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	@Override
	public String toString() {
		return "Spot [floor=" + floor + ", spot=" + spot + ", vehicleType=" + vehicleType + ", chargePort=" + chargePort
				+ ", tokenNumber=" + tokenNumber + "]";
	}

}
