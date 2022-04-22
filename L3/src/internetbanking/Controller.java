package internetbanking;

import java.util.HashMap;
import java.util.Map;

import common.CustomException;
import common.InputCenter;

public class Controller 
{
	
	CheckOperation operationCall = new CheckOperation();
	BankOperation bankCall = new BankOperation();
	AutoGenerate autoCall = new AutoGenerate();
	Map<Long,OpenAccount> openAccount = new HashMap<>();
	InputCenter inputCall = new InputCenter();

public void customerDetails() throws CustomException
{
	CustomerInfo custCall = new CustomerInfo();
	System.out.println("Enter Your Name");
	custCall.setName(inputCall.getString());
	System.out.println("Enter Your E-MailId");
	custCall.seteMailId(inputCall.getString());
	System.out.println("Enter Your PhoneNumber");
	custCall.setPhoneNumber(inputCall.getLong());
	System.out.println("Enter Your Address");
	custCall.setAddress(inputCall.getString());
	long customerId = autoCall.addNewCustomerId();
	custCall.setCustomerId(customerId);
	bankCall.addCustomerInfo(customerId, custCall);
	System.out.println("Don\'t forget Your CustomerId");
	System.out.println(customerId);
}
	
	
	
public void accountDetails() throws CustomException
{
		AccountInfo accCall = new AccountInfo();
		System.out.println("Enter Your CustomerId");
		long customerId = inputCall.getLong();
		long accountId = autoCall.addNewAccountId();
		accCall.setAccountId(accountId);
		System.out.println("Enter Your AccountType");
		accCall.setAccountType(inputCall.getString());
		accCall.setBalance(autoCall.setMinBalance());
		System.out.println("Enter your Branch");
		accCall.setBranch(inputCall.getString());
		bankCall.addAccountInfo(customerId, accountId, accCall);
		System.out.println("Don\'t forget Your AccountId");
		System.out.println(accountId);
}

public void existingUser() throws CustomException
{
	System.out.println("Enter the UserId");
	long userId = inputCall.getLong();
	System.out.println("Enter the Password");
	String password = inputCall.getString();
	String check = operationCall.checkLogin(userId, password, openAccount);
	if(check.equals("user"))
	{
		System.out.println("Login Successful");
		System.out.println("-----------0.Logout--------------------");
		System.out.println("-----------1.Balance Enquiry-----------");
		System.out.println("-----------2.Add New Account-----------");
		System.out.println("-----------3.Account History-----------");
		System.out.println("-----------4.Apply for Loan------------");
		System.out.println("-----------5.Money Transfer------------");
		OpenAccount accountCall = openAccount.get(userId);
		boolean flag = false;
		while(!flag)
		{
			int choice = inputCall.getChoice();
			switch(choice)
			{
				case 0:
				{
					flag = true;
					break;
				}
				case 1:
				{
					System.out.println(bankCall.getBalance(accountCall.getAccountId()));
					break;
				}
				case 2:
				{
					accountDetails();
					break;
				}
				case 3:
				{
					System.out.println(bankCall.showAccountDetails(accountCall.getAccountId()));
					System.out.println(bankCall.showTransactionDetails(accountCall.getAccountId()));
					break;
				}
				case 4:
				{
					
					break;
				}
				case 5:
				{
					System.out.println("Enter Your ToAccountNumber");
					long toAccId = inputCall.getLong();
					System.out.println("Enter Your Amount");
					double amount = inputCall.getDouble();
					boolean checking = bankCall.moneyTransfer(accountCall.getAccountId(), toAccId, amount);
					if(checking)
					{
						System.out.println("Transaction Successful");
					}
					else
					{
						System.out.println("Transaction Failed");
					}
					break;
				}
			}
		}
	}
	else if(check.equals("admin"))
	{
		System.out.println("-----------Welcome Admin---------------");
		System.out.println("-----------0.Logout--------------------");
		System.out.println("-----------1.Balance Enquiry-----------");
		System.out.println("-----------2.Add NetBank Account-------");
		System.out.println("-----------3.Account History-----------");
		System.out.println("-----------4.Check for Loan------------");
		System.out.println("-----------5.Money Transfer------------");
		boolean flag = false;
		while(!flag)
		{
			int choice = inputCall.getChoice();
			switch(choice)
			{
				case 0:
				{
					flag = true;
					break;
				}
				case 1:
				{
					
					break;
				}
				case 2:
				{
					OpenAccount accountCall = new OpenAccount();
					newUser(accountCall);
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
				case 5:
				{
					
					break;
				}
			}
		}
	}	
	else
	{
		System.out.println("UserId & Password Incorrected");
	}
}

public void newUser(OpenAccount accountCall)
{
	System.out.println("Enter Your Name");
	accountCall.setName(inputCall.getString());
	System.out.println("Enter Your PhoneNumber(Your UserID)");
	accountCall.setPhoneNumber(inputCall.getLong());
	long userId = accountCall.getPhoneNumber();				
	System.out.println("Enter Your E-Mail");
	accountCall.seteMail(inputCall.getString());
	System.out.println("Enter Your AccountId");
	accountCall.setAccountId(inputCall.getLong());
	System.out.println("Enter Your Password");
	accountCall.setPassword(inputCall.getString());
	accountCall.setRole(false);
	openAccount.put(userId, accountCall);
	System.out.println("New Account Created");
}

public void netBankingAccount() throws CustomException
{
	System.out.println("------------1.Existing User------------");
	System.out.println("------------2.New User-----------------");
	System.out.println("Enter Your Press Key");
	int press = inputCall.getInt();
	OpenAccount accountCall = new OpenAccount();
	accountCall.setPhoneNumber(1000);
	long adminId = accountCall.getPhoneNumber();  
	accountCall.setPassword("Admin@001");
	accountCall.setRole(true);
	openAccount.put(adminId, accountCall);
	switch(press)
	{
		case 1:
		{
			existingUser();
			break;
		}
		case 2:
		{
			newUser(accountCall);
			break;
		}
	}
}

	public static void main(String[] args) 
	{
		InputCenter inputCall = new InputCenter();

		
		
		boolean flag = false;
		while(!flag)
		{
			System.out.println("Enter Your Choice");
			int select = inputCall.getChoice();
		switch(select)
		{
			case 0:
			{
				flag = true;
				break;
			}
			case 1:
			{
				System.out.println("Do You have CustomerId:Yes/No");
				String check=inputCall.getString();
				if(check.contains("Yes"))
				{
					
				}		
				else if(check.contains("No"))
				{
					
				}
				else
				{
					System.out.println("ENTER THE VALID Yes/No");
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
			
			case 5:
			{
				
				break;
			}
			
			
		}
		}
				
	}

}
