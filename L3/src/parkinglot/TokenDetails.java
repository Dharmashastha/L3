package parkinglot;

public class TokenDetails 
{
	private long tokenNumber;
	private String vehicleNumber;
	private String vehicleType;
	private String EntryTime;
	private int floor;
	private int spot;
	private double getPay;
	private boolean amountStatus;
	
	public long getTokenNumber() {
		return tokenNumber;
	}
	public void setTokenNumber(long tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getEntryTime() {
		return EntryTime;
	}
	public void setEntryTime(String entryTime) {
		EntryTime = entryTime;
	}
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
	public double getGetPay() {
		return getPay;
	}
	public void setGetPay(double getPay) {
		this.getPay = getPay;
	}
	public boolean isAmountStatus() {
		return amountStatus;
	}
	public void setAmountStatus(boolean amountStatus) {
		this.amountStatus = amountStatus;
	}
	
	@Override
	public String toString() {
		return "TokenDetails [tokenNumber=" + tokenNumber + ", vehicleNumber=" + vehicleNumber + ", vehicleType="
				+ vehicleType + ", EntryTime=" + EntryTime + ", floor=" + floor + ", spot=" + spot + ", getPay="
				+ getPay + ", amountStatus=" + amountStatus + "]";
	}
}