package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingOperation 
{
	Map<String,VehicleInfo> vehicleMap = new HashMap<>();
	Map<Integer,ParkingInfo> parkMap = new HashMap<>();
	List<VehicleType> typeList = new ArrayList<>();
	private long tokenNumber = 10000;

public long newTokenNumber()
{
return ++tokenNumber;
}

public void addVehicleDetails(String vehicleNumber,VehicleInfo vehiCall)
{
	vehicleMap.put(vehicleNumber, vehiCall);
}

public Map<Integer,ParkingInfo> addParkDetails(int noOfnumber,ParkingInfo parkCall)
{
	parkMap.put(noOfnumber, parkCall);
return parkMap;	
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

public void vehicleTypeDetails(VehicleType typeCall)
{
	for(int i = 0; i < 5;i++)
	{
		System.out.println( "Floor" +i+"  "+ typeCall);
	}
}


public Object getCompact(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
{
	if(vehiCall.isEntryOrExit() == true)
	{
		typeCall.setCompact(typeCall.getCompact() - 1);
		if(typeCall.getCompact() == 0)
		{
			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getCompact() == 0)
			{
				return "No Space for Compact Spot";
			}
			parkCall = new ParkingInfo();
			parkCall.setNofFloors(5);
			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
		}
	}
	else
	{
		typeCall.setCompact(typeCall.getCompact() + 1);
	}
return parkMap;	
}

public Object getLarge(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
{
	if(vehiCall.isEntryOrExit() == true)
	{
		typeCall.setLarge(typeCall.getLarge() - 1);
		if(typeCall.getLarge() == 0)
		{
			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getLarge() == 0)
			{
				return "No Space for Large Spot";
			}
			parkCall = new ParkingInfo();
			parkCall.setNofFloors(5);
			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
		}
	}
	else
	{
		typeCall.setLarge(typeCall.getLarge() + 1);
	}
return parkMap;	
}

public Object getHandicapped(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
{
	if(vehiCall.isEntryOrExit() == true)
	{
		typeCall.setHandicapped(typeCall.getHandicapped() - 1);
		if(typeCall.getHandicapped() == 0)
		{
			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getHandicapped() == 0)
			{
				return "No Space for Handicapped Spot";
			}
			parkCall = new ParkingInfo();
			parkCall.setNofFloors(5);
			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
		}	
	}
	else
	{
		typeCall.setHandicapped(typeCall.getHandicapped() + 1);
	}
return parkMap;	
}

public Object getMotorCycle(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
{
	if(vehiCall.isEntryOrExit() == true)
	{
		typeCall.setMotorCycle(typeCall.getMotorCycle() - 1);
		if(typeCall.getMotorCycle() == 0)
		{
			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getMotorCycle() == 0)
			{
				return "No Space for MotorCycle Spot";
			}
			parkCall = new ParkingInfo();
			parkCall.setNofFloors(5);
			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
		}
	}
	else
	{
		typeCall.setMotorCycle(typeCall.getMotorCycle());
	}
return parkMap;	
}


public Object getElectricCar(VehicleInfo vehiCall,ParkingInfo parkCall,VehicleType typeCall,int avilSpacefFloor)
{
	if(vehiCall.isEntryOrExit() == true)
	{
		typeCall.setElectricCar(typeCall.getElectricCar() - 1);
		if(typeCall.getElectricCar() == 0)
		{
			if(parkCall.getNofFloors() == parkCall.getAvaiSpaceFloor() && typeCall.getElectricCar() == 0)
			{
					return "No Space for ElectricCar Spot";
			}
			parkCall = new ParkingInfo();
			parkCall.setNofFloors(5);
			parkCall.setAvaiSpaceFloor(avilSpacefFloor+1);
			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
		}
	}
	else
	{
		typeCall.setElectricCar(typeCall.getElectricCar());
	}
return parkMap;	
}

public Object checkSpace(int number,VehicleType typeCall,String vehicleNumber,int avilSpacefFloor)
{
	VehicleInfo vehiCall = vehicleMap.get(vehicleNumber);
	ParkingInfo parkCall = parkMap.get(avilSpacefFloor);
	Object saved = null;
	switch(number)
	{
		case 1:
		{
			saved = getCompact(vehiCall, parkCall, typeCall, avilSpacefFloor);
			break;
		}
		case 2:
		{
			saved = getLarge(vehiCall, parkCall, typeCall, avilSpacefFloor);
			break;
		}
		case 3:
		{
			saved = getHandicapped(vehiCall, parkCall, typeCall, avilSpacefFloor);
			break;
		}
		case 4:
		{
			saved = getMotorCycle(vehiCall, parkCall, typeCall, avilSpacefFloor);
			break;
		}
		case 5:
		{
			saved = getElectricCar(vehiCall, parkCall, typeCall, avilSpacefFloor);
			break;
		}
	}
return saved;	
}

public VehicleInfo showVehicleDetails(String vehicleNumber)
{
	VehicleInfo vehicall = vehicleMap.get(vehicleNumber);
return vehicall;	
}


public VehicleInfo checkAmountStatus(String vehicleNumber,int difftime)
{
	VehicleInfo vechiCall = vehicleMap.get(vehicleNumber);
	if(vechiCall.isAmountStatus() == false)
	{
		if(difftime <= 10000)
		{
			vechiCall.setGetPay(4.0);
		}
		else if(difftime <= 30000)
		{
			vechiCall.setGetPay(8.0);
		}
		else
		{
			vechiCall.setGetPay(11.0);
		}
		vechiCall.setAmountStatus(true);
		vechiCall.setEntryOrExit(false);
	}
return vechiCall;	
}



}
