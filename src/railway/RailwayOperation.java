package railway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RailwayOperation {

	
	Map<String,List<Berth>> berthMap = new HashMap<>();
	Map<Long,List<Passenger>> passengerMap = new HashMap<>();
	
	
	public void allocateBerth(int slot)
	{
		int split = slot / 3;
		
		for(int i = 0; i < split; i++)
		{
			
		}
	}
}
