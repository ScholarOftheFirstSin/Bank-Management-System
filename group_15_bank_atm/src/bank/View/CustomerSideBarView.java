package bank.View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import bank.Controller.*;
import bank.LoggedUser;

public class CustomerSideBarView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton profileButton;
	private JButton accListButton;
	private JButton newAccButton;
	private JButton loanListButton;
	private JButton newLoanButton;
	private JButton logOutButton;
	private JButton tradingAccountButton;
	private JButton transfer;
	private JButton boughtStock;

	
	public CustomerSideBarView()
	{
		//parentPanel = jP;
		
		profileButton = new JButton("My Profile");
		accListButton = new JButton("Account List");
		newAccButton = new JButton("Create New Account");
		loanListButton = new JButton("Loan List");
		newLoanButton = new JButton("Apply New Loan");
		tradingAccountButton = new JButton("Trading Account");
		logOutButton = new JButton("Log out");
		transfer = new JButton("Transfer");
		boughtStock = new JButton("The Bought Stock");


		
		this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
	    		
		
		this.add(profileButton, gbc);
		this.add(accListButton, gbc);
		this.add(newAccButton, gbc);
		this.add(loanListButton, gbc);
		this.add(newLoanButton, gbc);
		this.add(tradingAccountButton, gbc);
		this.add(boughtStock, gbc);
		this.add(transfer, gbc);

		this.add(logOutButton, gbc);

		initialize();
	}
	
	private void initialize()
	{
		
		
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JPanel pa =  new ProfileView();		    	
		        ProfileController proController = new ProfileController();
		        proController.showUserProfile(LoggedUser.getProfile());
				
			}
		});
		
		accListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    	
				AccountController accController = new AccountController();
		        accController.accountList();
				
			}
		});
		
		loanListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	    	
				LoanController loanController = new LoanController();
		        
			}
		});
		newAccButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountController accController = new AccountController();
		        accController.newAccount(); 
				
			}
		});
		newLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						    	
				LoanController loanController = new LoanController();
				loanController.NewLoan();
		        
				
			}
		});
		tradingAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    	
				//LoanController loanController = new LoanController();
				//loanController.NewLoan();

				StockController stockController = new StockController();
				stockController.StockList();
		        
				
			}
		});

		transfer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TransferController transferController = new TransferController();

			}
		});

		boughtStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StockController stockController = new StockController();
				stockController.ShowBoughtStock();

			}
		});



		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    	
				LoginController loginController = new LoginController();
			}
		});
	}
}
