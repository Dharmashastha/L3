package parkinglot;

public class ParkingInfo 
{
	private int nofFloors;
	private String timeFee;
	private int availableSpace;
	private int avaiSpaceFloor;
	
	public int getNofFloors() {
		return nofFloors;
	}
	public void setNofFloors(int nofFloors) {
		this.nofFloors = nofFloors;
	}
	public String getTimeFee() {
		return timeFee;
	}
	public void setTimeFee(String timeFee) {
		this.timeFee = timeFee;
	}
	public int getAvailableSpace() {
		return availableSpace;
	}
	public void setAvailableSpace(int availableSpace) {
		this.availableSpace = availableSpace;
	}
	public int getAvaiSpaceFloor() {
		return avaiSpaceFloor;
	}
	public void setAvaiSpaceFloor(int avaiSpaceFloor) {
		this.avaiSpaceFloor = avaiSpaceFloor;
	}
	
	@Override
	public String toString() {
		return "ParkingInfo [nofFloors=" + nofFloors + ", timeFee=" + timeFee + ", availableSpace=" + availableSpace
				+ ", avaiSpaceFloor=" + avaiSpaceFloor + "]";
	}
	
	
	
	
	
	
}
