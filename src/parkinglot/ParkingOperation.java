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
	Map<Integer, Map<String, List<Spot>>> occupiedSpot = new HashMap<>();

//	List<Spot> emptySpot = new ArrayList<>();
//	List<Spot> occupiedSpot = new ArrayList<>();
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

	public TokenDetails showTokenDetails(long tokenNumber) {
		TokenDetails tokenCall = tokenMap.get(tokenNumber);
		return tokenCall;
	}

	public void addCustomerPortal(long portalId, CustomerInfo cusCall) throws CustomException {
		nullCheckObject(cusCall);
		cusMap.put(portalId, cusCall);
	}

	public double getWallet(long portalId) {
		CustomerInfo cusCall = cusMap.get(portalId);
		return cusCall.getWallet();
	}

	public void addSpotDetails(int floor, int spot, String vehicleType, Spot spotCall, boolean chargePort) {
		Map<String, List<Spot>> newEmpty = new HashMap<>();
		List<Spot> spotList = new ArrayList<>();
		for (int i = 0; i < floor; i++) {
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

	public String getSpot(int floor, String vehicleType) {
		Map<String, List<Spot>> dummyMap = emptySpot.get(floor);
		List<Spot> spotList = dummyMap.get(vehicleType);
		String saved = "";
		Spot spotCall;
		for (int i = 0; i < spotList.size(); i++) {
			spotCall = spotList.get(i);
			saved += spotCall + "\n";
		}
		return saved;
	}

	public String currentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:MM:SS");
		Date time = new Date(System.currentTimeMillis());
		return formatter.format(time);
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

	public String checkSpot(int floor, String vehicleType) {
		Map<String, List<Spot>> dummyMap = emptySpot.get(floor);
		List<Spot> spotList = dummyMap.get(vehicleType);
		Spot SpotCall = spotList.get(0);
		spotList.remove(0);
		Map<String, List<Spot>> tempMap = new HashMap<>();
		List<Spot> newList = new ArrayList<>();
		newList.add(SpotCall);
		tempMap.put(vehicleType, newList);
		occupiedSpot.put(floor, tempMap);
		return SpotCall == null ? "Fully " + vehicleType + " SpotOccupied" : "We have Spot " + vehicleType;
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

//public List<VehicleType> addVehicleTypes(VehicleType typeCall)
//{
//	typeList.add(typeCall);
//return typeList;	
//}

//public Object checkSpace1(String vehicleNumber,int avilSpacefFloor)
//{
//	VehicleInfo vehiCall = vehicleMap.get(vehicleNumber);
//	ParkingInfo parkCall = parkMap.get(avilSpacefFloor);
//	if(vehiCall.isEntryOrExit() == true)
//	{
//		parkCall.setAvailableSpace(parkCall.getAvailableSpace() - 1);
//		if(parkCall.getAvailableSpace() == 0)
//		{
//			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor())
//			{
//				if(parkCall.getAvailableSpace() == 0)
//				{
//					return "No Space Spot";
//				}
//			}
//			parkCall = new ParkingInfo();
//			parkCall.setNofFloors(5);
//			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
//			parkCall.setAvailableSpace(2);
//			
//			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
//		}
//	}
//	else
//	{
//		parkCall.setAvailableSpace(parkCall.getAvailableSpace() + 1);
//	}
//return parkMap;
//}

//public Object getCompact(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
//{
//	if(vehiCall.isEntryOrExit() == true)
//	{
//		typeCall.setCompact(typeCall.getCompact() - 1);
//		if(typeCall.getCompact() == 0)
//		{
//			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getCompact() == 0)
//			{
//				return "No Space for Compact Spot";
//			}
//			parkCall = new ParkingInfo();
//			parkCall.setNofFloors(5);
//			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
//			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
//		}
//	}
//	else
//	{
//		typeCall.setCompact(typeCall.getCompact() + 1);
//	}
//return parkMap;	
//}
//
//public Object getLarge(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
//{
//	if(vehiCall.isEntryOrExit() == true)
//	{
//		typeCall.setLarge(typeCall.getLarge() - 1);
//		if(typeCall.getLarge() == 0)
//		{
//			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getLarge() == 0)
//			{
//				return "No Space for Large Spot";
//			}
//			parkCall = new ParkingInfo();
//			parkCall.setNofFloors(5);
//			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
//			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
//		}
//	}
//	else
//	{
//		typeCall.setLarge(typeCall.getLarge() + 1);
//	}
//return parkMap;	
//}
//
//public Object getHandicapped(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
//{
//	if(vehiCall.isEntryOrExit() == true)
//	{
//		typeCall.setHandicapped(typeCall.getHandicapped() - 1);
//		if(typeCall.getHandicapped() == 0)
//		{
//			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getHandicapped() == 0)
//			{
//				return "No Space for Handicapped Spot";
//			}
//			parkCall = new ParkingInfo();
//			parkCall.setNofFloors(5);
//			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
//			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
//		}	
//	}
//	else
//	{
//		typeCall.setHandicapped(typeCall.getHandicapped() + 1);
//	}
//return parkMap;	
//}
//
//public Object getMotorCycle(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
//{
//	if(vehiCall.isEntryOrExit() == true)
//	{
//		typeCall.setMotorCycle(typeCall.getMotorCycle() - 1);
//		if(typeCall.getMotorCycle() == 0)
//		{
//			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getMotorCycle() == 0)
//			{
//				return "No Space for MotorCycle Spot";
//			}
//			parkCall = new ParkingInfo();
//			parkCall.setNofFloors(5);
//			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
//			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
//		}
//	}
//	else
//	{
//		typeCall.setMotorCycle(typeCall.getMotorCycle());
//	}
//return parkMap;	
//}
//
//
//public Object getElectricCar(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
//{
//	if(vehiCall.isEntryOrExit() == true)
//	{
//		typeCall.setElectricCar(typeCall.getElectricCar() - 1);
//		if(typeCall.getElectricCar() == 0)
//		{
//			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getElectricCar() == 0)
//			{
//					return "No Space for ElectricCar Spot";
//			}
//			parkCall = new ParkingInfo();
//			parkCall.setNofFloors(5);
//			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
//			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
//		}
//	}
//	else
//	{
//		typeCall.setElectricCar(typeCall.getElectricCar());
//	}
//return parkMap;	
//}
//
//public Object checkSpace(int number,VehicleType typeCall,String vehicleNumber,int avilSpacefFloor)
//{
//	VehicleInfo vehiCall = vehicleMap.get(vehicleNumber);
//	ParkingInfo parkCall = parkMap.get(avilSpacefFloor);
//	Object saved = null;
//	switch(number)
//	{
//		case 1:
//		{
//			saved = getCompact(vehiCall, parkCall, typeCall, avilSpacefFloor);
//			break;
//		}
//		case 2:
//		{
//			saved = getLarge(vehiCall, parkCall, typeCall, avilSpacefFloor);
//			break;
//		}
//		case 3:
//		{
//			saved = getHandicapped(vehiCall, parkCall, typeCall, avilSpacefFloor);
//			break;
//		}
//		case 4:
//		{
//			saved = getMotorCycle(vehiCall, parkCall, typeCall, avilSpacefFloor);
//			break;
//		}
//		case 5:
//		{
//			saved = getElectricCar(vehiCall, parkCall, typeCall, avilSpacefFloor);
//			break;
//		}
//	}
//return saved;	
//}
//
//public VehicleInfo showVehicleDetails(String vehicleNumber)
//{
//	VehicleInfo vehicall = vehicleMap.get(vehicleNumber);
//return vehicall;	
//}

}
