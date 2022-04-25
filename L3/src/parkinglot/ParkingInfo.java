package parkinglot;

public class ParkingInfo 
{
	private int nofFloors;
	private int avaiSpaceFloor;
	
	public int getNofFloors() {
		return nofFloors;
	}
	public void setNofFloors(int nofFloors) {
		this.nofFloors = nofFloors;
	}
	public int getAvaiSpaceFloor() {
		return avaiSpaceFloor;
	}
	public void setAvaiSpaceFloor(int avaiSpaceFloor) {
		this.avaiSpaceFloor = avaiSpaceFloor;
	}
	
	@Override
	public String toString() {
		return "ParkingInfo [nofFloors=" + nofFloors + ", avaiSpaceFloor=" + avaiSpaceFloor + "]";
	}
	
	
	
	
	
	
}
