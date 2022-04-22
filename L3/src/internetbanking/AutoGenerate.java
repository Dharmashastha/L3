package internetbanking;

import common.CustomException;
import common.HelperUtil;

public class AutoGenerate 
{
		static public long customerId=100000;
		static public long accountId=20000;
		static public long transactionId=1000;
public long addNewCustomerId()
{	
return ++customerId;		
}

public long addNewAccountId()
{
return ++accountId;	
}

public static long addTransactionId()
{
return ++transactionId;	
}


public double setMinBalance() throws CustomException
{
	AccountInfo account= new AccountInfo();
	HelperUtil.nullCheckFile(account);
	account.setBalance(1000.00);
return 	account.getBalance();
}
}

