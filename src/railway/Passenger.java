package railway;

public class Passenger {

	private long ticketNumber;
	private String name;
	private int age;
	private String gender;
	private String berthType;

	public long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBerthType() {
		return berthType;
	}

	public void setBerthType(String berthType) {
		this.berthType = berthType;
	}

	@Override
	public String toString() {
		return "Passenger [ticketNumber=" + ticketNumber + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", berthType=" + berthType + "]";
	}

}
