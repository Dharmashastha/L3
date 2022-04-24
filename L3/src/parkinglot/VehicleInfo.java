package parkinglot;


public class VehicleInfo 
{
	private String vehicleNumber;
	private String vehicleType;
	private boolean entryOrExit;
	private String timeLimit;
	private double getPay;
	private long tokenNumber;
	private boolean amountStatus;
	
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
	public boolean isEntryOrExit() {
		return entryOrExit;
	}
	public void setEntryOrExit(boolean entryOrExit) {
		this.entryOrExit = entryOrExit;
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	public double getGetPay() {
		return getPay;
	}
	public void setGetPay(double getPay) {
		this.getPay = getPay;
	}
	public long getTokenNumber() {
		return tokenNumber;
	}
	public void setTokenNumber(long tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
	public boolean isAmountStatus() {
		return amountStatus;
	}
	public void setAmountStatus(boolean amountStatus) {
		this.amountStatus = amountStatus;
	}
	
	@Override
	public String toString() {
		return "VehicleInfo [vehicleNumber=" + vehicleNumber + ", vehicleType=" + vehicleType + ", entryOrExit="
				+ entryOrExit + ", timeLimit=" + timeLimit + ", getPay=" + getPay + ", tokenNumber=" + tokenNumber
				+ ", amountStatus=" + amountStatus + "]";
	}
	
	
	
	
	
}
