package bank;

import java.util.ArrayList;

public class Profiles {
	private String ProfileId;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String Address;
	private String Password;
	private String Email;
	private ArrayList<Account> AccountList;
	private ArrayList<Loan> LoanList;
	//private UserType userType;
	
	public Profiles()
	{
		
	}

	
	public String getProfileId() {
		return ProfileId;
	}


	public void setProfileId(String profileId) {
		ProfileId = profileId;
	}


	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}


	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}


	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public ArrayList<Account> getAccountList() {
		return AccountList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		AccountList = accountList;
	}
	
	public void AddAccount(Account account)
	{
		AccountList.add(account);
	}

	public ArrayList<Loan> getLoanList() {
		return LoanList;
	}

	public void setLoanList(ArrayList<Loan> loanList) {
		LoanList = loanList;
	}
	
	public void AddLoan(Loan loan)
	{
		LoanList.add(loan);
	}

/*
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	*/
	
	public String toString()
	{
		return LastName+", "+FirstName+" "+MiddleName;
	}
	
}
