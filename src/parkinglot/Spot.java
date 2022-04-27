package parkinglot;

public class Spot 
{
	private int floor;
	private int spot;
	private String vehicleType;
	private boolean chargePort;
	
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
	
	@Override
	public String toString() {
		return "Spot [floor=" + floor + ", spot=" + spot + ", vehicleType=" + vehicleType + ", chargePort=" + chargePort
				+ "]";
	}
	
	
}
