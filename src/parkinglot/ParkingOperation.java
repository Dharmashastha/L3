package parkinglot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.CustomException;

public class ParkingOperation {
	Map<Long, TokenDetails> tokenMap = new HashMap<>();
	Map<Integer, Map<String, List<Spot>>> emptySpot = new HashMap<>();
	Map<Long, Spot> occupiedSpot = new HashMap<>();
	Map<Long, CustomerInfo> cusMap = new HashMap<>();

	private long tokenNumber = 10000;
	private long portalId = 100;

	public long newTokenNumber() {
		return ++tokenNumber;
	}

	public long newportalId() {
		return ++portalId;
	}

	public void nullCheckObject(Object objCall) throws CustomException {
		if (objCall == null) {
			throw new CustomException("Object can't be null");
		}
	}

	public void addTokenDetails(long tokenNumber, TokenDetails tokenCall) throws CustomException {
		nullCheckObject(tokenCall);
		tokenMap.put(tokenNumber, tokenCall);
	}

	public TokenDetails showTokenDetails(long tokenNumber) throws CustomException {
		checkTokenNumberNumber(tokenNumber);
		TokenDetails tokenCall = tokenMap.get(tokenNumber);
		return tokenCall;
	}
	

	public void addCustomerPortal(long portalId, CustomerInfo cusCall) throws CustomException {
		nullCheckObject(cusCall);
		cusMap.put(portalId, cusCall);
	}
	
	public void checkPortalId(long portalId) throws CustomException
	{
		CustomerInfo cusCall = cusMap.get(portalId);
		if(cusCall == null)
		{
			throw new  CustomException("portalId Invalid");
		}
	}
	
	public void checkTokenNumberNumber(long tokenNumber) throws CustomException
	{
		TokenDetails tokenCall = tokenMap.get(tokenNumber);
		if(tokenCall == null)
		{
			throw new  CustomException("tokenNumber Invalid");
		}
	}
	
	public double getWallet(long portalId) {
		CustomerInfo cusCall = cusMap.get(portalId);
		return cusCall.getWallet();
	}
	
	public void setWallet(long portalId,double wallet) {
		CustomerInfo cusCall = cusMap.get(portalId);
		cusCall.setWallet(wallet);
	}

	public CustomerInfo showPortalDetails(long portalId) throws CustomException {
		checkPortalId(portalId);
		CustomerInfo cusCall = cusMap.get(portalId);
		return cusCall;
	}

	public void addSpotDetails(int floor, int spot, String vehicleType, Spot spotCall, boolean chargePort) {

		for (int i = 1; i <= floor; i++) {
			Map<String, List<Spot>> newEmpty = emptySpot.get(i);
			if (newEmpty == null) {
				newEmpty = new HashMap<String, List<Spot>>();
			}
			List<Spot> spotList = new ArrayList<>();
			for (int j = 1; j <= spot; j++) {
				spotCall = new Spot();
				spotCall.setSpot(j);
				spotCall.setFloor(i);
				spotCall.setVehicleType(vehicleType);
				spotCall.setChargePort(chargePort);
				spotList.add(spotCall);
			}
			newEmpty.put(vehicleType, spotList);
			emptySpot.put(i, newEmpty);
		}
	}

//	public String getSpot(int floor, String vehicleType) {
//		Map<String, List<Spot>> dummyMap = emptySpot.get(floor);
//		List<Spot> spotList = dummyMap.get(vehicleType);
//		String saved = "";
//		Spot spotCall;
//		for (int i = 0; i < spotList.size(); i++) {
//			spotCall = spotList.get(i);
//			saved += spotCall + "\n";
//		}
//		if (saved.isEmpty()) {
//			saved = "Floor " + vehicleType + " SpotOccupied";
//		}
//		return saved;
//	}

	public String currentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:MM:SS");
		Date time = new Date(System.currentTimeMillis());
		return formatter.format(time);
	}

	public String checkVehicleNumber(String vehicleNumber) throws CustomException {
		for (long i = tokenNumber; i >= 10000; i--) {
			TokenDetails tokenCall = tokenMap.get(i);
			if (tokenCall == null) {
				continue;
			}
			if (tokenCall.getVehicleNumber().equals(vehicleNumber)) {
				throw new  CustomException("Already Parked");
			}
		}
		return "";
	}
	
	public Object getVehicleNumber(String vehicleNumber,long phoneNumber) throws CustomException {
		for (long i = tokenNumber; i < i + tokenMap.size(); i++) {
			TokenDetails tokenCall = tokenMap.get(i - 1);
			if (tokenCall == null) {
				return "";
			}
			if (tokenCall.getVehicleNumber().equals(vehicleNumber)) {
				return tokenCall;
			}
			else if (tokenCall.getPhoneNumber() == phoneNumber) {
				return tokenCall;
			}
		}
		return "";
	}
	
//	for (int i = 0; i < emptySpot.size(); i++) {
//		Spot spotCall = emptySpot.get(i);
//		if (amountStatus == false) {
//			if (spotCall.getVehicleType().equals(vehicleType) && spotCall.getFloor() == floor
//					&& spotCall.getSpace() == spot) {
//				occupiedSpot.add(spotCall);
//				emptySpot.remove(i);
//				saved = "We Have Space";
//				break;
//			}
//		} else {
//			emptySpot.add(occupiedSpot.get(i));
//			occupiedSpot.remove(i);
//			saved = "We Have Space";
//			break;
//		}
//		
//	}

//	public String checkFloor(int floor, int spot,long tokenNumber) throws CustomException {
//		TokenDetails tokenCall = tokenMap.get(tokenNumber);
//		if(tokenCall == null)
//		{
//			return "We have Floor";
//		}
//		String vehicleType = tokenCall.getVehicleType();
//		Spot spotCall = occupiedSpot.get(tokenNumber);
//		if(spotCall == null)
//		{
//			return "We have Floor " + vehicleType;
//		}
//		if ((floor * spot) == spotList.size()) {
//			throw new  CustomException("Fully " + vehicleType + " FloorOccupied");
//		}
//		return "We have Floor " + vehicleType;
//	}

	public String checkSpot(long tokenNumber) throws CustomException {
		TokenDetails tokenCall = tokenMap.get(tokenNumber);
		String vehicleType = tokenCall.getVehicleType();
		Map<String, List<Spot>> dummyMap = emptySpot.get(tokenCall.getFloor());
		if(dummyMap == null)
		{
			throw new CustomException("Floor Not Found");
		}
		List<Spot> spotList = dummyMap.get(vehicleType);
		if (spotList.size() == 0) {
			throw new  CustomException("Floor " + vehicleType + " SpotOccupied");
		}
		spotList.get(0).setTokenNumber(tokenNumber);
		Spot spotCall = spotList.remove(0);	
		tokenCall.setSpot(spotCall.getSpot());
		occupiedSpot.put(tokenNumber, spotCall);
		return "We have Spot For " + vehicleType;
	}

	public void checkExitSpot(long tokenNumber) {
		TokenDetails tokenCall = tokenMap.get(tokenNumber);
		Spot spotCall = occupiedSpot.get(tokenNumber);
		Map<String, List<Spot>> tempMap = emptySpot.get(tokenCall.getFloor());
		List<Spot> tempList = tempMap.get(tokenCall.getVehicleType());
			if (spotCall.getTokenNumber() == tokenNumber) {
				tempList.add(spotCall);
				occupiedSpot.remove(tokenNumber);
		}

	}

	public String checkAmountBalance(int difftime) {
		String saved = "";
		if (difftime <= 10000) {
			saved = "Kindly Pay $4";
		} else if (difftime <= 30000) {
			saved = "Kindly Pay $7.5";
		} else {
			saved = "Kindly Pay $10";
		}
		return saved;
	}

	public double checkAmountPortal(int difftime, double wallet) {
		if (difftime <= 10000) {
			wallet -= 4;
		} else if (difftime <= 30000) {
			wallet -= 7.5;
		} else {
			wallet -= 10;
		}
		return wallet;
	}
}
