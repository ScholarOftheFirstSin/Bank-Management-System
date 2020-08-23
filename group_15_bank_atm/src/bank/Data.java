package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Data {

	private static Bank bank;
	private static StockMarket stockMarket;

	public static StockMarket getStockMarket() {
		return stockMarket;
	}

	public static void setStockMarket(StockMarket stockMarket) {
		Data.stockMarket = stockMarket;
	}

	public static Bank getBank() {
		return bank;
	}

	public static void setBank(Bank bank) {
		Data.bank = bank;
	}
	
	
	//private static ArrayList<Transaction> transactionList;
	//private static ArrayList<Loan> loanList;

	/*
	public static ArrayList<Profiles> getProfileList() {
		return profileList;
	}

	public void setProfileList(ArrayList<Profiles> profileList) {
		this.profileList = profileList;
	}
	
	public static void AddProfile(Profiles pro)
	{
		profileList.add(pro);
	}
	
	
	public static ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public static void setTransactionList(ArrayList<Transaction> transactionList) {
		Data.transactionList = transactionList;
	}
	
	public static void AddTransaction(Transaction transaction) {
		Data.transactionList.add(transaction);
	}
	
	public  static void  InitTransaction()
	{
		transactionList = new ArrayList<Transaction>();
		loanList = new ArrayList<Loan>();
	}

	public  static void  InitProfileList()
	{
		profileList = new ArrayList<Profiles>();
		Profiles pro = new Profiles();
		pro.setProfileId(UUID.randomUUID().toString());
		pro.setUserType(UserType.BankManager);
		pro.setFirstName("Manager");
		pro.setLastName("Bank");
		pro.setMiddleName("M");
		pro.setAddress("Boston");
		pro.setEmail("manager@google.com");
		pro.setPassword("Password");		
		profileList.add(pro);
		
		for (int i = 0; i < 3; i++)
		{
			pro = new Profiles();
			pro.setProfileId(UUID.randomUUID().toString());
			pro.setUserType(UserType.Customer);
			pro.setFirstName("Jhon"+i);
			pro.setLastName("Doe"+i);
			pro.setMiddleName("M");
			pro.setAddress("Boston");
			pro.setEmail(i+"john@google.com");
			pro.setPassword("Password");
			ArrayList<Account> accList = new ArrayList<Account>();
			ArrayList<Loan> loanList = new ArrayList<Loan>();
			pro.setAccountList(accList);
			pro.setLoanList(loanList);			
			AddAccount(pro);
			AddLoan(pro);
			profileList.add(pro);
		}
	}
	
	private static void AddAccount(Profiles pro)
	{
		Account acc = new Account();
		acc.setAccountId(UUID.randomUUID().toString());
		acc.setAmount(1000 * new Random().nextInt(10));
		acc.setType(AccountType.Checking);
		acc.setFriendlyName("My Friendly Account");
		acc.setCurrency(CurrencyType.USD);
		pro.AddAccount(acc);
		
	}

	private static void AddLoan(Profiles pro)
	{
		Loan l = new Loan();
		l.setAmount(1000 * new Random().nextInt(10));
		l.setLoanId(UUID.randomUUID().toString());
		l.setStartDate(new Date());
		l.setSRP(3.5);
		l.setInterest(3.5);
		l.setCollateral("A house in Miami beach");
		l.setStatus(LoanStatus.Approved);
		l.setType(LoanType.Auto);
		l.setTerm(10);
		pro.AddLoan(l);			
	}

	public static ArrayList<Loan> getLoanList() {
		return loanList;
	}

	public static void setLoanList(ArrayList<Loan> loanList) {
		Data.loanList = loanList;
	}
	
	public static void AddLoanList(Loan loan) {
		Data.loanList.add(loan);
	}
	
	*/
	
}
