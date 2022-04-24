package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingOperation 
{
	Map<String,VehicleInfo> vehicleMap = new HashMap<>();
	Map<Integer,ParkingInfo> parkMap = new HashMap<>();
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

public Map<Integer,ParkingInfo> checkSpace(String vehicleNumber,int avilSpacefFloor)
{
	VehicleInfo vehiCall = vehicleMap.get(vehicleNumber);
	ParkingInfo parkCall = parkMap.get(avilSpacefFloor);
	if(vehiCall.isEntryOrExit() == true)
	{
		parkCall.setAvailableSpace(parkCall.getAvailableSpace() - 1);
		if(parkCall.getAvailableSpace() == 0)
		{
			parkCall.setAvaiSpaceFloor(parkCall.getAvaiSpaceFloor()+1);
			parkCall.setAvailableSpace(30);
			parkMap.put(parkCall.getAvaiSpaceFloor(), parkCall);
		}
	}
	else
	{
		parkCall.setAvailableSpace(parkCall.getAvailableSpace() + 1);
	}
return parkMap;
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
