package parkinglot;

import common.CustomException;
import common.InputCenter;

public class Controller {

	InputCenter inputCall = new InputCenter();
	ParkingOperation parkCall = new ParkingOperation();
	private int floor = 0;
	// private int spot = 0;

	public void setSpot(int floor,int spot,Spot spotCall) {

//		System.out.println("Please Enter Number Of VehicleType");
//		int length = inputCall.getInt();
//		for(int i = 0; i < length; i++)
//		{
//			System.out.println("Please Enter VehicleType");
//			String vehicleType = inputCall.getString();
//			System.out.println("Please Enter NoOfSpot " + vehicleType);
//			int numberOfSpot = inputCall.getInt();
//			System.out.println("Do You Want ChargePort: Yes/No"); 
//			String check = inputCall.getString();
//			boolean flag = false;
//			if(check.equalsIgnoreCase("Yes"))
//			{
//				flag = true;
//			}
//			parkCall.addSpotDetails(floor, numberOfSpot, vehicleType, spotCall, flag);
//		}
		
		parkCall.addSpotDetails(floor, spot, "Compact", spotCall, false);
		parkCall.addSpotDetails(floor, spot, "Large", spotCall, false);
		parkCall.addSpotDetails(floor, spot, "Handicapped", spotCall, false);
		parkCall.addSpotDetails(floor, spot, "MotorCycle", spotCall, false);
		parkCall.addSpotDetails(floor, spot, "ElectricCar", spotCall, true);
		this.floor = floor;
		// this.spot = spot;
	}

	public CustomerInfo createCustomerPortal() throws CustomException {
		CustomerInfo cusCall = new CustomerInfo();
		System.out.println("Enter Name");
		cusCall.setName(inputCall.getString());
		cusCall.setPortalId(parkCall.newportalId());
		System.out.println("Enter Your Wallet");
		cusCall.setWallet(inputCall.getDouble());
		parkCall.addCustomerPortal(cusCall.getPortalId(), cusCall);
		System.out.println("Your PortalId: " + cusCall.getPortalId());
	return cusCall;	
	}

	public String getVehicleType(int number) throws CustomException {
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
		default: {
			throw new CustomException("Enter the Vaild Number");
		}
		}
		return saved;
	}

	public void showPortalDetails() throws CustomException {
		System.out.println("Enter PortalId");
		System.out.println(parkCall.showPortalDetails(inputCall.getLong()));
	}

	public void tokenDetails() throws CustomException {
		TokenDetails tokenCall = new TokenDetails();
		tokenCall.setTokenNumber(parkCall.newTokenNumber());
		System.out.println("Enter VehicleNumber");
		tokenCall.setVehicleNumber(inputCall.getString());
		System.out.println("Enter PhoneNumber");
		tokenCall.setPhoneNumber(inputCall.getLong());
		if (floor == 1) {
			tokenCall.setFloor(1);
		} else {
			System.out.println("Enter Floor");
			tokenCall.setFloor(inputCall.getInt());
		}
		System.out.println("Enter VehicleType");
		System.out.println("1.Compact(Car,Van)\n2.Large(Truck)\n3.Handicapped\n4.MotorCycle\n5.ElectricCar");
		int number = inputCall.getInt();
		tokenCall.setVehicleType(getVehicleType(number));
		Object token = parkCall.getVehicleNumber(tokenCall.getVehicleNumber(), tokenCall.getPhoneNumber());
		if (token.equals("")) {
			System.out.println(parkCall.checkVehicleNumber(tokenCall.getVehicleNumber()));
			CustomerInfo cusCall = createCustomerPortal();
			cusCall.setPhoneNumber(tokenCall.getPhoneNumber());
			tokenCall.setPortalId(cusCall.getPortalId());
//			System.out.println("Enter VehicleType");
//			System.out.println("1.Compact(Car,Van)\n2.Large(Truck)\n3.Handicapped\n4.MotorCycle\n5.ElectricCar");
//			int number = inputCall.getInt();
//			tokenCall.setVehicleType(getVehicleType(number));
			// System.out.println(parkCall.checkFloor(floor, spot,
			// tokenCall.getTokenNumber()));	
			// System.out.println(parkCall.getSpot(tokenCall.getFloor(),
			// tokenCall.getVehicleType()));
//			System.out.println("You have PortalId:Yes/No");
//			String saved = inputCall.getString();
//			if (saved.equalsIgnoreCase("Yes")) {
//				System.out.println("Enter PortalId");
//				long portalId = inputCall.getLong();
//				parkCall.checkPortalId(portalId);
//				tokenCall.setPortalId(portalId);
//			} else {
//				tokenCall.setPortalId(0);
//			}
		}
		parkCall.addTokenDetails(tokenCall.getTokenNumber(), tokenCall);
		System.out.println(parkCall.checkSpot(tokenCall.getTokenNumber()));
		tokenCall.setEntryTime(parkCall.currentTime());
		System.out.println("Your Floor: " + tokenCall.getFloor() + " Your Spot: " + tokenCall.getSpot());
		System.out.println("Your TokenNumber :" + tokenCall.getTokenNumber());
	}

	public void exit() throws CustomException {
		System.out.println("Enter TokenNumber");
		long tokenNumber = inputCall.getLong();
		TokenDetails tokenCall = parkCall.showTokenDetails(tokenNumber);
		System.out.println(tokenCall);
		String time = parkCall.currentTime();
		time = time.replaceAll(":", "");
		String entryTime = tokenCall.getEntryTime();
		entryTime = entryTime.replaceAll(":", "");
		int diffTime = Math.abs(Integer.parseInt(time) - Integer.parseInt(entryTime));
		if (tokenCall.getPortalId() == 0) {
			System.out.println("Pay Option:\n1.Cash\n2.Card");
			int number = inputCall.getInt();
			switch (number) {
			case 1: {
				System.out.println(parkCall.checkAmountBalance(diffTime));
				System.out.println("Payment Successful");
				parkCall.checkExitSpot(tokenNumber);
				break;
			}
			case 2: {
				System.out.println("Your Card Number");
				long card = inputCall.getLong();
				String saved = String.valueOf(card);
				if (saved.length() == 16 && card != 0000000000000000 && saved.charAt(0) - '0' >= 4) {
					System.out.println(parkCall.checkAmountBalance(diffTime));
					parkCall.checkExitSpot(tokenNumber);
					System.out.println("Payment Successful");
				} else {
					System.out.println("Payment Failed");
					System.out.println(parkCall.checkAmountBalance(diffTime));
					System.out.println("Payment Successful");
					parkCall.checkExitSpot(tokenNumber);
				}
				break;
			}
			default: {
				throw new CustomException("Enter the Vaild Number");
			}
			}
		} else {
			double balance = parkCall.checkAmountPortal(diffTime, parkCall.getWallet(tokenCall.getPortalId()));

			if (balance <= 0) {
				System.out.println("Your Pay Balance :" + Math.abs(balance));
				balance = 0;
				parkCall.setWallet(tokenCall.getPortalId(), balance);
				System.out.println("Payment Successful");
				parkCall.checkExitSpot(tokenNumber);
			} else {
				parkCall.checkExitSpot(tokenNumber);
				System.out.println("Payment Successful");
			}
		}
	}

	public static void main(String[] args) {

		InputCenter inputCall = new InputCenter();
		Controller conCall = new Controller();
		boolean flag = false;
		Spot spotCall = new Spot();
		System.out.println("Enter Number Of Floor");
		int floor = inputCall.getInt();
		System.out.println("Compact\nLarge\nHandicapped\nMotorCycle\nElectricCar");
		System.out.println("Enter Number Of Spot Each VehicleType");
		int spot = inputCall.getInt();
		conCall.setSpot(floor,spot,spotCall);

		while (!flag) {
			System.out.println("Please Enter Your Choice");
			System.out.println("-------------1.Entry Vehicle-------------");
			System.out.println("-------------2.Exit Vehicle--------------");
			System.out.println("-------------3.Create CustomerPortal-----");
			System.out.println("-------------4.CustomerPortalDetails-----");
			System.out.println("-------------5.LogOut--------------------");
			int choice = inputCall.getChoice();

			switch (choice) {
			case 1: {
				try {
					System.out.println("one Hour $4 Fee Two Hour and Three Hour $7.5 Fee Remaining Hour $.10 Fee");
					conCall.tokenDetails();
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				try {
					System.out.println("one Hour $4 Fee Two Hour and Three Hour $7.5 Fee Remaining Hour $.10 Fee");
					conCall.exit();
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 3: {
				try {
					conCall.createCustomerPortal();
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 4: {
				try {
					conCall.showPortalDetails();
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 5: {
				flag = true;
				break;
			}
			default: {
				System.out.println("Enter the Vaild Number");
				break;
			}
			}
		}
	}
}