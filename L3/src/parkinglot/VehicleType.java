package parkinglot;

public class VehicleType 
{
	private int floor;
	private int compact = 10;
	private int large = 4;
	private int handicapped = 2;
	private int motorCycle = 10;
	private int electricCar = 4;
	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getCompact() {
		return compact;
	}
	public void setCompact(int compact) {
		this.compact = compact;
	}
	public int getLarge() {
		return large;
	}
	public void setLarge(int large) {
		this.large = large;
	}
	public int getHandicapped() {
		return handicapped;
	}
	public void setHandicapped(int handicapped) {
		this.handicapped = handicapped;
	}
	public int getMotorCycle() {
		return motorCycle;
	}
	public void setMotorCycle(int motorCycle) {
		this.motorCycle = motorCycle;
	}
	public int getElectricCar() {
		return electricCar;
	}
	public void setElectricCar(int electricCar) {
		this.electricCar = electricCar;
	}
	
	@Override
	public String toString() {
		return "VehicleType [compact=" + compact + ", large=" + large + ", handicapped="
				+ handicapped + ", motorcycle=" + motorCycle + ", electricCar=" + electricCar + "]";
	}
	
	
	
}
