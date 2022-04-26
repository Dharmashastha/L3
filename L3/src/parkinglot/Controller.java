package parkinglot;

import common.CustomException;
import common.InputCenter;

public class Controller {

	InputCenter inputCall = new InputCenter();
	public ParkingOperation parkCall = new ParkingOperation();
	
	
	public void createCustomerPortal()
	{
		CustomerInfo cusCall = new CustomerInfo();
		cusCall.setName(inputCall.getString());
		cusCall.setPortalId(parkCall.newportalId());
		cusCall.setStoredPay(inputCall.getDouble());
	}
	public String getVehicleType(int number) {
		String saved = "";
		switch (number) {
		case 1: {
			saved = "Compact";
			break;
		}
		case 2: {
			saved = "Large";
			break;
		}
		case 3: {
			saved = "Handicapped";
			break;
		}
		case 4: {
			saved = "MotorCycle";
			break;
		}
		case 5: {
			saved = "ElectricCar";
			break;
		}
		}
		return saved;
	}

	public void tokenDetails() throws CustomException {
		TokenDetails tokenCall = new TokenDetails();
		tokenCall.setTokenNumber(parkCall.newTokenNumber());
		System.out.println("Enter VehicleNumber");
		tokenCall.setVehicleNumber(inputCall.getString());
		System.out.println("Enter VehicleType");
		System.out.println("1.Compact\n2.Large\n3.Handicapped\n4.MotorCycle\n5.electricCar");
		int number = inputCall.getInt();
		tokenCall.setVehicleType(getVehicleType(number));
		System.out.println(parkCall.getSpot(tokenCall.getVehicleType()));
		System.out.println("Enter Floor");
		tokenCall.setFloor(inputCall.getInt());
		System.out.println("Enter Spot");
		tokenCall.setSpot(inputCall.getInt());
		
		tokenCall.setGetPay(0.0);
		tokenCall.setEntryTime(parkCall.currentTime());
		tokenCall.setAmountStatus(false);
		parkCall.addTokenDetails(tokenCall.getTokenNumber(), tokenCall);
		System.out.println(parkCall.checkSpot(tokenCall.getVehicleType(), tokenCall.getFloor(), tokenCall.getSpot(),
				tokenCall.isAmountStatus()));
		System.out.println("Your TokenNumber :"+ tokenCall.getTokenNumber());

	}

//public void vehicleDetails()
//{
//	VehicleInfo vehiCall = new VehicleInfo();
//	VehicleType typeCall = new VehicleType();
//	System.out.println("Enter VehicleNumber");
//	vehiCall.setVehicleNumber(inputCall.getString());
//	vehiCall.setGetPay(0);
//	vehiCall.setTokenNumber(parkCall.newTokenNumber());
//	System.out.println("Enter VehicleType");
//	System.out.println("1.Compact\n2.Large\n3.Handicapped\n4.MotorCycle\n5.electricCar");
//	int number = inputCall.getInt();
//	vehiCall.setVehicleType(getVehicleType(number));
//	System.out.println("Enter AvaiFloor");
//	vehiCall.setFloor(inputCall.getInt());
//	vehiCall.setEntryOrExit(true);
//	String time = time();
//	vehiCall.setTimeLimit(time);
//	vehiCall.setAmountStatus(false);
//	typeCall.setFloor(vehiCall.getFloor());
//	parkCall.addVehicleDetails(vehiCall.getVehicleNumber(), vehiCall);
//	System.out.println(parkCall.checkSpace(number,typeCall, vehiCall.getVehicleNumber(), vehiCall.getFloor()));
//	parkCall.vehicleTypeDetails(typeCall);
//}

	public void exit() {
		System.out.println("Enter TokenNumber");
		long tokenNumber = inputCall.getLong();
		TokenDetails tokenCall = parkCall.showTokenDetails(tokenNumber);
		System.out.println(tokenCall);
		String time = parkCall.currentTime();
		time = time.replaceAll(":", "");
		String entryTime = tokenCall.getEntryTime();
		entryTime = entryTime.replaceAll(":", "");
		int diffTime = Math.abs(Integer.parseInt(time) - Integer.parseInt(entryTime));
		System.out.println("Pay Option:\n1.Cash\n2.Card");
		int number = inputCall.getInt();
		switch (number) {
		case 1: {
			System.out.println("Payment Successful");
			System.out.println(parkCall.checkAmountStatus(tokenNumber, diffTime));
			parkCall.checkSpot(tokenCall.getVehicleType(), tokenCall.getFloor(), tokenCall.getSpot(),
					tokenCall.isAmountStatus());
			break;
		}
		case 2: {
			System.out.println("Your Card Number");
			long card = inputCall.getLong();
			String saved = String.valueOf(card);
			if (saved.length() == 16 && card != 0000000000000000 &&  saved.charAt(0) - '0' >= 4) {
				System.out.println("Payment Successful");
				System.out.println(parkCall.checkAmountStatus(tokenNumber, diffTime));
				parkCall.checkSpot(tokenCall.getVehicleType(), tokenCall.getFloor(),
						tokenCall.getSpot(), tokenCall.isAmountStatus());
			} else {
				System.out.println("Payment Failed");
			}
		}

		}
	}

	public static void main(String[] args) {

		InputCenter inputCall = new InputCenter();
		Controller conCall = new Controller();
		boolean flag = false;
		Spot spotCall = new Spot();
		ParkingOperation parkCall = new ParkingOperation();
		parkCall.addSpotDetails(spotCall,2,16);
		while (!flag) {
			System.out.println("-------------0.LogOut-----------");
			System.out.println("-------------1.Entry Vehicle----");
			System.out.println("-------------2.Exit Vehicle-----");
			int choice = inputCall.getChoice();
			System.out
					.println("one Hour \u20B9.4 Fee Two Hour and Three Hour \u20B9.8 Fee Remaining Hour \u20B9.11 Fee");
			
			switch (choice) {
			case 0: {
				flag = true;
				break;
			}
			case 1: {
				try {
					
					conCall.tokenDetails();
				} catch (CustomException e) {
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				conCall.exit();
				break;
			}
			}
		}
	}
}
