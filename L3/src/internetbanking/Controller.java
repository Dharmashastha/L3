package internetbanking;

import common.InputCenter;

public class Controller 
{

	public static void main(String[] args) 
	{
		InputCenter inputCall = new InputCenter();
		
		int select = inputCall.getChoice();
		
		
		boolean flag = false;
		while(!flag)
		{
		switch(select)
		{
			case 0:
			{
				flag = true;
				break;
			}	
			case 1:
			{
				System.out.println("Press 1 for Sign in / Press 2 for Sign up");
				int press = inputCall.getInt();
				Login logCall = new Login();
				OpenAccount accountCall = new OpenAccount();
				switch(press)
				{
					case 1:
					{
						System.out.println("Enter Your UserId");
						String userId = inputCall.getString();
						logCall.setUserId(userId);
						System.out.println("Enter Your Password");
						String password = inputCall.getString();
						logCall.setPassword(password);
						
						break;
					}
					case 2:
					{
						System.out.println("Enter Your Name");
						accountCall.setName(inputCall.getString());
						System.out.println("Enter Your PhoneNumber");
						accountCall.setPhoneNumber(inputCall.getInt());
						System.out.println("Enter Your AccountNumber");
						accountCall.setAccountNumber(inputCall.getLong());
						System.out.println("Wait...");
						System.out.println("Enter Your UserId");
						logCall.setUserId(inputCall.getString());
						System.out.println("Enter Your Password");
						logCall.setPassword(inputCall.getString());
						break;
					}
				}
				break;
			}
			
			case 2:
			{
				
				break;
			}
			
			case 3:
			{
				
				break;
			}
			
			case 4:
			{
				
				break;
			}
			
			
		}
		}
				
	}

}
