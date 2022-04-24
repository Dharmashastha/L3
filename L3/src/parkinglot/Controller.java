package parkinglot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import common.InputCenter;

public class Controller {

	InputCenter inputCall = new InputCenter();
	ParkingOperation  parkCall = new ParkingOperation();
	ParkingInfo parCall = new ParkingInfo();
	
public String time()
{
	LocalDateTime datetime = LocalDateTime.now();
	DateTimeFormatter timeCall = DateTimeFormatter.ofPattern("HH:MM:SS");
	String time = timeCall.format(datetime);
	return time;
}
	
public void vehicleDetails()
{
	VehicleInfo vehiCall = new VehicleInfo();
	System.out.println("Enter VehicleNumber");
	vehiCall.setVehicleNumber(inputCall.getString());
	vehiCall.setGetPay(0);
	vehiCall.setTokenNumber(parkCall.newTokenNumber());
	System.out.println("Enter VehicleType");
	vehiCall.setVehicleType(inputCall.getString());
	vehiCall.setEntryOrExit(true);
	String time = time();
	vehiCall.setTimeLimit(time);
	vehiCall.setAmountStatus(false);
	parkCall.addVehicleDetails(vehiCall.getVehicleNumber(), vehiCall);
	System.out.println(parkCall.checkSpace(vehiCall.getVehicleNumber(), parCall.getAvaiSpaceFloor()));
}


public void parkingDetails()
{
	
	parCall.setNofFloors(5);
	parCall.setTimeFee("one Hour \u20B9.4 Two Hour and Three Hour \u20B9.8 Remaining Hour \u20B9.11");
	parCall.setAvailableSpace(2);
	parCall.setAvaiSpaceFloor(0);
	System.out.println(parkCall.addParkDetails(parCall.getAvaiSpaceFloor(), parCall));
}

public void exit()
{
	System.out.println("Enter VehicleNumber");
	String vehicle = inputCall.getString();
	System.out.println(parkCall.showVehicleDetails(vehicle));
	String time = time();
	time=time.replaceAll(":", "");
	System.out.println("Enter EntryTime");
	int diffTime = Integer.parseInt(time) - inputCall.getInt();
	System.out.println(parkCall.checkAmountStatus(vehicle, diffTime));
	System.out.println(parkCall.checkSpace(vehicle, parCall.getAvaiSpaceFloor()));
}

	public static void main(String[] args) {
		
		InputCenter inputCall = new InputCenter();
		Controller conCall = new Controller();
		
		boolean flag = false;
	
		while(!flag)
		{
			System.out.println("-------------0.Exit-------------");
			System.out.println("-------------1.Entry Vehicle----");
			System.out.println("-------------2.Exit Vehicle-----");
			int choice = inputCall.getChoice();
			conCall.parkingDetails();
			switch(choice)
			{
				case 0:
				{
					flag = true;
					break;
				}
				case 1:
				{
					conCall.vehicleDetails();
					break;
				}
				case 2:
				{
					conCall.exit();
					break;
				}
			}
		}
	}

}
