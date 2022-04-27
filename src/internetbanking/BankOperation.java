package internetbanking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.CustomException;
import common.HelperUtil;

public class BankOperation {
	static Map<Long, CustomerInfo> custMap = new HashMap<>();
	static Map<Long, Map<Long, AccountInfo>> accMap = new HashMap<>();
	static Map<Long, AccountInfo> accountMap = new HashMap<>();
	static Map<Long, List<TransactionInfo>> transMap = new HashMap<>();
	static Map<Long,LoanInfo> loanMap = new HashMap<>();
	List<TransactionInfo> newList;
	int count=0;
	
	
	public void nullCheckCustMap(long customerId) throws CustomException {
		if (custMap.get(customerId) == null) {
			throw new CustomException("customerId Invalid");
		}
	}

	public void nullCheckAccMap(long customerId) throws CustomException {
		if (accMap.get(customerId) == null) {
			throw new CustomException("customerId Invalid");
		}
	}

	public void nullCheckAccountMap(long accountId) throws CustomException {
		if (accountMap.get(accountId) == null) {
			throw new CustomException("accountId Invalid");
		}
	}

	public Map<Long, CustomerInfo> addCustomerInfo(long customerId, CustomerInfo custCall) throws CustomException {
		HelperUtil.nullCheckObject(custCall);
		custMap.put(customerId, custCall);
		return custMap;
	}

	public Map<Long, Map<Long, AccountInfo>> addAccountInfo(long customerId, long accountId, AccountInfo accCall)
			throws CustomException {
		Map<Long, AccountInfo> custIdMap = accMap.get(customerId);
		nullCheckCustMap(customerId);

		if (custIdMap == null) {
			custIdMap = new HashMap<>();
			accMap.put(customerId, custIdMap);
		}
		custIdMap.put(accountId, accCall);
		accountMap.put(accountId, accCall);
		return accMap;
	}

	public double getBalance(long accountId) throws CustomException {
		nullCheckAccountMap(accountId);
		AccountInfo accCall = accountMap.get(accountId);
		return accCall.getBalance();
	}

	public AccountInfo showAccountDetails(long accountId) throws CustomException {
		nullCheckAccountMap(accountId);
		AccountInfo accCall = accountMap.get(accountId);
		return accCall;
	}

	public String showTransactionDetails(long accountId) throws CustomException {
		nullCheckAccountMap(accountId);
		List<TransactionInfo> list = transMap.get(accountId);
		String saved = "";
		for (int i = list.size() - 1; i >= 0; i--) 
		{
			TransactionInfo transCall = (TransactionInfo) list.get(i);
			saved += transCall.toString()+"\n";
		}
		return saved;
	}

	public boolean moneyTransfer(long fromAccountId, long toAccountId, double amount) throws CustomException {
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
		if (fromBalance == fromaccCall.getBalance() && toBalance == toaccCall.getBalance()) {
			flag = true;
		}
		return flag;
	}

	public void transactionDetails(long fromAccountId, long toAccountId, double amount) {

		TransactionInfo transCall = new TransactionInfo();
		
		if(count == 0)
		{
			newList=new ArrayList<>();
			transCall.setFromAccount(fromAccountId);
			transCall.setToAccount(toAccountId);
			transCall.setAmount(amount);
			transCall.setTransactionId(AutoGenerate.addTransactionId());
			transCall.getTransactionId();
			transCall.setTransactionType('D');

			long millis = System.currentTimeMillis();

			java.util.Date date = new java.util.Date(millis);

			transCall.setDateAndTime(date);

			newList.add(transCall);

			transMap.put(fromAccountId, newList);
			count++;
		}
		else
		{
			transCall.setFromAccount(fromAccountId);
			transCall.setToAccount(toAccountId);
			transCall.setAmount(amount);
			transCall.setTransactionId(AutoGenerate.addTransactionId());
			transCall.getTransactionId();
			transCall.setTransactionType('D');

			long millis = System.currentTimeMillis();

			java.util.Date date = new java.util.Date(millis);

			transCall.setDateAndTime(date);

			newList.add(transCall);

			transMap.put(fromAccountId, newList);
		}	
	}
	
	public String checkLogin(long userId,String password,Map<Long,OpenAccount> open)
	{
		
		OpenAccount userIdMap = open.get(userId);
	 	if(userIdMap.getPhoneNumber() == userId && userIdMap.getPassword().equals(password) && userIdMap.isRole() == false)
	 	{
	 		count = 0;
	 		return "user";
	 	}
	 	else if(userIdMap.getPhoneNumber() == userId && userIdMap.getPassword().equals(password) && userIdMap.isRole() == true)
	 	{
	 		return "admin";
	 	}
	return "wrong"; 	
	}
	
	public void addLoanDetails(long accountId,LoanInfo loanCall)
	{
		loanMap.put(accountId, loanCall);
	}
	
	public Map<Long,LoanInfo> showApplayLoanDetails()
	{
		return loanMap;
	}
	
	public LoanInfo approve(long accountId)
	{
		LoanInfo loanCall = loanMap.get(accountId);
		loanCall.setApprove(true);
		loanCall.setProcessingStatus("Approved");
	return loanCall;	
	}
	
}
