package internetbanking;

import common.CustomException;

public class DummyValues 
{
	AutoGenerate autoCall = new AutoGenerate();
	BankOperation bankCall = new BankOperation();
	
	
public void dummyValues() throws CustomException
{
	CustomerInfo cus1 = new CustomerInfo();
	cus1.setName("dharma");
	cus1.seteMailId("dharma@gmail.com");
	cus1.setPhoneNumber(6380335964l);
	cus1.setAddress("guruvarpattai");
	cus1.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus1.getCustomerId(), cus1);
	
	AccountInfo acc1 = new AccountInfo();
	acc1.setAccountType("Student");
	acc1.setBranch("Karaikudi");
	acc1.setCustomerId(cus1.getCustomerId());
	acc1.setAccountId(autoCall.addNewAccountId());
	acc1.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus1.getCustomerId(), acc1.getAccountId(), acc1);
	
	
	CustomerInfo cus2 = new CustomerInfo();
	cus2.setName("gokul");
	cus2.seteMailId("gokul@gmail.com");
	cus2.setPhoneNumber(9087002919l);
	cus2.setAddress("chennai");
	cus2.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus2.getCustomerId(), cus2);
	
	AccountInfo acc2 = new AccountInfo();
	acc2.setAccountType("saveings");
	acc2.setBranch("chennai");
	acc2.setCustomerId(cus2.getCustomerId());
	acc2.setAccountId(autoCall.addNewAccountId());
	acc2.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus2.getCustomerId(), acc2.getAccountId(), acc2);
	
	CustomerInfo cus3 = new CustomerInfo();
	cus3.setName("Manisundar");
	cus3.seteMailId("mani2004@gmail.com");
	cus3.setPhoneNumber(6745802548l);
	cus3.setAddress("karaikudi");
	cus3.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus3.getCustomerId(), cus3);
	
	AccountInfo acc3 = new AccountInfo();
	acc3.setAccountType("Student");
	acc3.setBranch("Karaikudi");
	acc3.setCustomerId(cus3.getCustomerId());
	acc3.setAccountId(autoCall.addNewAccountId());
	acc3.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus3.getCustomerId(), acc3.getAccountId(), acc3);
	
	
	CustomerInfo cus4 = new CustomerInfo();
	cus4.setName("Ali");
	cus4.seteMailId("Ali1024@gmail.com");
	cus4.setPhoneNumber(8563589472l);
	cus4.setAddress("coimbatore");
	cus4.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus4.getCustomerId(), cus4);
	
	AccountInfo acc4 = new AccountInfo();
	acc4.setAccountType("Salary");
	acc4.setBranch("coimbatore");
	acc4.setCustomerId(cus4.getCustomerId());
	acc4.setAccountId(autoCall.addNewAccountId());
	acc4.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus4.getCustomerId(), acc4.getAccountId(), acc4);
	
	
	CustomerInfo cus5 = new CustomerInfo();
	cus5.setName("aravinth");
	cus5.seteMailId("aravinth@gmail.com");
	cus5.setPhoneNumber(8963245789l);
	cus5.setAddress("coimbatore");
	cus5.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus5.getCustomerId(), cus5);
	
	AccountInfo acc5 = new AccountInfo();
	acc5.setAccountType("Student");
	acc5.setBranch("coimbatore");
	acc5.setCustomerId(cus5.getCustomerId());
	acc5.setAccountId(autoCall.addNewAccountId());
	acc5.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus5.getCustomerId(), acc5.getAccountId(), acc5);
	
	CustomerInfo cus6 = new CustomerInfo();
	cus6.setName("suriya");
	cus6.seteMailId("suriya@gmail.com");
	cus6.setPhoneNumber(8594782564l);
	cus6.setAddress("karaikudi");
	cus6.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus6.getCustomerId(), cus6);
	
	AccountInfo acc6 = new AccountInfo();
	acc6.setAccountType("Salary");
	acc6.setBranch("Karaikudi");
	acc6.setCustomerId(cus6.getCustomerId());
	acc6.setAccountId(autoCall.addNewAccountId());
	acc6.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus6.getCustomerId(), acc6.getAccountId(), acc6);
	
	
	CustomerInfo cus7 = new CustomerInfo();
	cus7.setName("bose");
	cus7.seteMailId("bose@gmail.com");
	cus7.setPhoneNumber(7581963548l);
	cus7.setAddress("coimbatore");
	cus7.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus7.getCustomerId(), cus1);
	
	AccountInfo acc7 = new AccountInfo();
	acc7.setAccountType("Student");
	acc7.setBranch("coimbatore");
	acc7.setCustomerId(cus7.getCustomerId());
	acc7.setAccountId(autoCall.addNewAccountId());
	acc7.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus7.getCustomerId(), acc7.getAccountId(), acc7);
	
	CustomerInfo cus8 = new CustomerInfo();
	cus8.setName("Raj");
	cus8.seteMailId("raj0304@gmail.com");
	cus8.setPhoneNumber(6380335964l);
	cus8.setAddress("coimbatore");
	cus8.setCustomerId(autoCall.addNewCustomerId());
	bankCall.addCustomerInfo(cus8.getCustomerId(), cus8);
	
	AccountInfo acc8 = new AccountInfo();
	acc8.setAccountType("Student");
	acc8.setBranch("coimbatore");
	acc8.setCustomerId(cus8.getCustomerId());
	acc8.setAccountId(autoCall.addNewAccountId());
	acc8.setBalance(autoCall.setMinBalance());
	bankCall.addAccountInfo(cus8.getCustomerId(), acc8.getAccountId(), acc8);
}
}
