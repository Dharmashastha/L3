package internetbanking;

public class CheckOperation 
{
	Login logCall = new Login();
	OpenAccount accountCall = new OpenAccount();
	Cache cacheCall = new Cache();

public void checkLogin(String userId,String password)
{
 	cacheCall.login.put(userId,password);
 	
}

}
