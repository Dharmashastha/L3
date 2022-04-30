package railway;

public class Berth {

	private String berthType;
	private int seats;

	public String getBerthType() {
		return berthType;
	}

	public void setBerthType(String berthType) {
		this.berthType = berthType;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Berth [berthType=" + berthType + ", seats=" + seats + "]";
	}

}
