package parkinglot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import common.InputCenter;

public class Controller {

	InputCenter inputCall = new InputCenter();
	public ParkingOperation  parkCall = new ParkingOperation();
	ParkingInfo parCall = new ParkingInfo();
	
	
public String time()
{
	LocalDateTime datetime = LocalDateTime.now();
	DateTimeFormatter timeCall = DateTimeFormatter.ofPattern("HH:MM:SS");
	String time = timeCall.format(datetime);
return time;
}

public String getVehicleType(int number)
{
	String saved = null;
	switch(number)
	{
		case 1:
		{
			saved = "Compact";
			break;
		}
		case 2:
		{
			saved = "Large";
			break;
		}
		case 3:
		{
			saved = "Handicapped";
			break;
		}
		case 4:
		{
			saved = "MotorCycle";
			break;
		}
		case 5:
		{
			saved = "ElectricCar";
			break;
		}
	}
return saved;	
}

public void vehicleDetails()
{
	VehicleInfo vehiCall = new VehicleInfo();
	VehicleType typeCall = new VehicleType();
	System.out.println("Enter VehicleNumber");
	vehiCall.setVehicleNumber(inputCall.getString());
	vehiCall.setGetPay(0);
	vehiCall.setTokenNumber(parkCall.newTokenNumber());
	System.out.println("Enter VehicleType");
	System.out.println("1.Compact\n2.Large\n3.Handicapped\n4.MotorCycle\n5.electricCar");
	int number = inputCall.getInt();
	vehiCall.setVehicleType(getVehicleType(number));
	System.out.println("Enter AvaiFloor");
	vehiCall.setFloor(inputCall.getInt());
	vehiCall.setEntryOrExit(true);
	String time = time();
	vehiCall.setTimeLimit(time);
	vehiCall.setAmountStatus(false);
	typeCall.setFloor(vehiCall.getFloor());
	parkCall.addVehicleDetails(vehiCall.getVehicleNumber(), vehiCall);
	System.out.println(parkCall.checkSpace(number,typeCall, vehiCall.getVehicleNumber(), vehiCall.getFloor()));
	parkCall.vehicleTypeDetails(typeCall);
}


public void parkingDetails()
{
	parCall.setNofFloors(5);
	parCall.setAvaiSpaceFloor(0);
	System.out.println(parkCall.addParkDetails(parCall.getAvaiSpaceFloor(), parCall));
}



public void exit()
{
	VehicleType typeCall = new VehicleType();
	System.out.println("Enter VehicleNumber");
	String vehicle = inputCall.getString();
	System.out.println(parkCall.showVehicleDetails(vehicle));
	String time = time();
	time=time.replaceAll(":", "");
	System.out.println("Enter EntryTime");
	int diffTime = Math.abs(Integer.parseInt(time) - inputCall.getInt());
	System.out.println("Pay Option:\n1.Cash\n2.Card");
	int number = inputCall.getInt();
	switch(number)
	{
		case 1:
		{
			System.out.println("Payment Successful");
			System.out.println(parkCall.checkAmountStatus(vehicle, diffTime));
			System.out.println("Enter FloorNumber");
			System.out.println(parkCall.checkSpace(number,typeCall, vehicle, inputCall.getInt()));
			break;
		}
		case 2:
		{
			System.out.println("Your Card Number");
			long card = inputCall.getLong();
			String saved = String.valueOf(card); 
			if(saved.length() == 16 && card != 0000000000000000 && saved.charAt(0) - '0' <= 4)
			{
				System.out.println("Payment Successful");
				System.out.println(parkCall.checkAmountStatus(vehicle, diffTime));
				System.out.println("Enter FloorNumber");
				System.out.println(parkCall.checkSpace(number,typeCall, vehicle, inputCall.getInt()));
			}
			else
			{
				System.out.println("Payment Failed");
			}
			
			
		}
		
	}
}

	public static void main(String[] args) {
		
		InputCenter inputCall = new InputCenter();
		Controller conCall = new Controller();
		int count = 0;
		boolean flag = false;
	
		while(!flag)
		{
			System.out.println("-------------0.LogOut-----------");
			System.out.println("-------------1.Entry Vehicle----");
			System.out.println("-------------2.Exit Vehicle-----");
			int choice = inputCall.getChoice();
			if(count == 0)
			{	
				conCall.parkingDetails();
				count = 1;
			}
			
			System.out.println("one Hour \u20B9.4 Fee Two Hour and Three Hour \u20B9.8 Fee Remaining Hour \u20B9.11 Fee");
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
