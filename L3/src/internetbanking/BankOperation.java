package internetbanking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import common.CustomException;
import common.HelperUtil;


public class BankOperation 
{
	Map<Long,CustomerInfo> custMap = new HashMap<>();
	Map<Long,Map<Long,AccountInfo>> accMap = new HashMap<>();
	Map<Long,AccountInfo> accountMap = new HashMap<>();
	Map<Long,TransactionInfo> transMap = new HashMap<>();
	
	
	
public void nullCheckCustMap(long customerId) throws CustomException
{
	if(custMap.get(customerId) == null)
	{
		throw new CustomException("customerId Invalid");
	}
}

public void nullCheckAccMap(long customerId) throws CustomException
{
	if(accMap.get(customerId) == null)
	{
		throw new CustomException("customerId Invalid");
	}
}

public void nullCheckAccountMap(long accountId) throws CustomException
{
	if(accountMap.get(accountId) == null)
	{
		throw new CustomException("accountId Invalid");
	}
}
	
public Map<Long,CustomerInfo> addCustomerInfo(long customerId,CustomerInfo custCall) throws CustomException
{
	HelperUtil.nullCheckObject(custCall);
	custMap.put(customerId, custCall);
return custMap;	
}

public Map<Long,Map<Long,AccountInfo>> addAccountInfo(long customerId,long accountId,AccountInfo accCall) throws CustomException
{
	Map<Long,AccountInfo> custIdMap = accMap.get(customerId);
	nullCheckCustMap(customerId);
	
	if(custIdMap == null)
	{
		custIdMap = new HashMap<>();
		accMap.put(customerId, custIdMap);
	}
	custIdMap.put(accountId, accCall);
	accountMap.put(accountId, accCall);
return accMap;	
}

public double getBalance(long accountId) throws CustomException
{
	nullCheckAccountMap(accountId);
	AccountInfo accCall = accountMap.get(accountId);
return accCall.getBalance();	
}

public AccountInfo showAccountDetails(long accountId) throws CustomException
{
	nullCheckAccountMap(accountId);
	AccountInfo accCall = accountMap.get(accountId);
return accCall;	
}

public TransactionInfo showTransactionDetails(long accountId) throws CustomException
{
	nullCheckAccountMap(accountId);
	TransactionInfo transCall = transMap.get(accountId);
return transCall;	
}

public boolean moneyTransfer(long fromAccountId,long toAccountId,double amount) throws CustomException
{
	nullCheckAccountMap(fromAccountId);
	nullCheckAccountMap(toAccountId);
	boolean flag = false;
	AccountInfo fromaccCall = accountMap.get(fromAccountId);
	AccountInfo toaccCall = accountMap.get(toAccountId);
	double fromBalance = fromaccCall.getBalance();
	double toBalance = toaccCall.getBalance();
	fromBalance -= amount;
	toBalance += amount;
	fromaccCall.setBalance(fromBalance);
	toaccCall.setBalance(toBalance);
	transactionDetails(fromAccountId, toAccountId, amount);
	if(fromBalance == fromaccCall.getBalance() && toBalance == toaccCall.getBalance())
	{
		flag = true;
	}
return flag;	
}

public void transactionDetails(long fromAccountId,long toAccountId,double amount)
{
	
	TransactionInfo transCall = new TransactionInfo();
	
	transCall.setFromAccount(fromAccountId);
	transCall.setToAccount(toAccountId);
	transCall.setAmount(amount);
	transCall.setTransactionId(AutoGenerate.addTransactionId());
	long transaction = transCall.getTransactionId();
	transCall.setTransactionType('D');
	
	LocalDateTime dateTime = LocalDateTime.now();
	
	DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("DD-MM-YYYY HH:MM:SS");	
	
	String date = dateTime.format(dateTimeFormat);
	
	transCall.setDateAndTime(date);
	
	transMap.put(transaction, transCall);	
}

}
