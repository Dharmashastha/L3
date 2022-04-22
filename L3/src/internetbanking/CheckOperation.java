package internetbanking;

import java.util.Map;


public class CheckOperation 
{
	Cache cacheCall = new Cache();

	
	
public String checkLogin(long userId,String password,Map<Long,OpenAccount> open)
{
	
	OpenAccount userIdMap = open.get(userId);
 	if(userIdMap.getPhoneNumber() == userId && userIdMap.getPassword().equals(password) && userIdMap.isRole() == false)
 	{
 		return "user";
 	}
 	else if(userIdMap.getPhoneNumber() == userId && userIdMap.getPassword().equals(password) && userIdMap.isRole() == true)
 	{
 		return "admin";
 	}
return "wrong"; 	
}

}
