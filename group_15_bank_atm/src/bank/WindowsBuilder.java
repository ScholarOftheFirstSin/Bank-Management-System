package bank;

import javax.swing.JFrame;

import bank.Controller.LoginController;
import bank.MySql.DBManager;

import java.util.ArrayList;

public class WindowsBuilder {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public WindowsBuilder(DBManager dbManager) {
		initialize(dbManager);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBManager dbManager) {

//		Data.getStockMarket().stocks = (ArrayList<Stock>) dbManager.readStocks();
//		for(Stock stock : Data.getStockMarket().stocks){
//			System.out.println(stock.getName());
//		}
//		for(CheckingAccount checkingAccount : dbManager.readCheckingAccounts("1", "1")){
//			System.out.println(checkingAccount.getAccountNumber());
//		}
//
//		for(SavingsAccount savingsAccount : dbManager.readSavingAccounts("1", "1")){
//			System.out.println(savingsAccount.getAccountNumber());
//		}
//
//		for(SecurityAccount securityAccount : dbManager.readSecurityAccounts("1", "1")){
//			System.out.println(securityAccount.getAccountNumber());
//		}
//		for(BoughtStock boughtStock : dbManager.readBoughtStocks(new SecurityAccount(0.0f, 1,
//				10000, true, new Currency("USD"), 0.0f, 0.0f))){
//			System.out.println(boughtStock.getStock().getTotalShares());
//		}
//		for(Deposit deposit : dbManager.readDeposits()){
//			System.out.println("Deposit");
//			System.out.println(deposit.amount);
//		}
//		for(Withdrawal withdrawal : dbManager.readWithdrawals()){
//			System.out.println("Withdrawal");
//			System.out.println(withdrawal.amount);
//		}
//		for(Transfer transfer: dbManager.readTransfers()){
//			System.out.println("Transfer");
//			System.out.println(transfer.amount);
//		}





		
        frame = new JFrame();
        frame.setVisible(true);
		PanelData.InitiatePanelData(frame, dbManager);
        LoginController loginController = new LoginController();



        
	}

}
