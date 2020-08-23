package bank.Controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import bank.*;
import bank.View.AccountListView;
import bank.View.AddAccountView;
import bank.View.DepositWithdrawView;

public class AccountController {
	private JPanel accountListView;
	private JPanel depositWView;
	private JPanel addAccountView;


	public AccountController() {
		accountListView = new AccountListView();
		addAccountView = new AddAccountView();
		depositWView = new DepositWithdrawView();
		initController();
	}

	public void accountList()
	{
		accountListView.setVisible(true);
		PanelData.setParentPanel(accountListView);
		bindData();	
	}


	public void initController()
	{
		((AccountListView)accountListView).getNewAccountButton().addActionListener(l -> newAccount());
		((AccountListView)accountListView).getTransactionButton().addActionListener(l -> newTransaction());
		((AddAccountView)addAccountView).getSaveButton().addActionListener(l -> AddNewAccount());
		((DepositWithdrawView)depositWView).getSaveButton().addActionListener(l -> AddTransaction());
	}

	public void newAccount() {
		System.out.print("masuk");
		addAccountView.setVisible(true);
		PanelData.setParentPanel(addAccountView);
	}
	private void newTransaction() {
		//if (LoggedUser.getProfile() != null && LoggedUser.getProfile().getAccountList() != null)
		//{
		System.out.print("masuk");
		depositWView.setVisible(true);
		PanelData.setParentPanel(depositWView);
		//}
	}

	private void AddTransaction() {

		boolean isAllowed = true;
		Float amount = Float.parseFloat(((DepositWithdrawView)depositWView).getAmountTextField().getText());
		if(amount > 0) {
			for (Account acc : LoggedUser.getProfile().getCheckingAccounts()) {

				//System.out.println(((DepositWithdrawView)depositWView).getAccNameDd().getSelectedItem());



				if (acc.equals(((DepositWithdrawView)depositWView).getAccNameDd().getSelectedItem()))
				{
					if (((DepositWithdrawView)depositWView).getTransTypeDd().getSelectedItem() == TransactionType.Deposit)
					{
						if (!LoggedUser.getProfile().depositAmount(Float.parseFloat(((DepositWithdrawView)depositWView).getAmountTextField().getText()),
								new Currency("USD"), acc.getAccountNumber(), acc.getRoutingNumber())) {
									isAllowed = false;
									((DepositWithdrawView)depositWView).setMsgLabel("Your transaction is not allowed (Not enough fund)");
						}
						//acc.de(acc.getAmount() +
						//		Float.parseFloat(((DepositWithdrawView)depositWView).getAmountTextField().getText()));
					}else
					{
						if (!LoggedUser.getProfile().withdrawAmount(Float.parseFloat(((DepositWithdrawView)depositWView).getAmountTextField().getText()),
								new Currency("USD"), acc.getAccountNumber(), acc.getRoutingNumber())) {
							((DepositWithdrawView)depositWView).setMsgLabel("Your transaction is not allowed (Not enough fund)");
							isAllowed = false;
						}
					}
					if (isAllowed)
					{
						//Transaction trans = new Transaction();
						//trans.setAmount(Long.parseLong(((DepositWithdrawView)depositWView).getAmountTextField().getText()));
						//trans.setTransactionDate(new Date());
						//trans.setTransactionBy(LoggedUser.getProfile());
						//trans.setTransactionId(UUID.randomUUID().toString());
						//trans.setType((TransactionType)((DepositWithdrawView)depositWView).getTransTypeDd().getSelectedItem());
						//trans.setAccountUsed((Account)((DepositWithdrawView)depositWView).getAccNameDd().getSelectedItem());
						//Data.AddTransaction(trans);
						//acc.addTransactionList(trans);

						((DepositWithdrawView)depositWView).setMsgLabel("Your transaction is successfull");
					}

					break;
				}
			}

			for (Account acc : LoggedUser.getProfile().getSavingsAccounts()) {

				System.out.println(((DepositWithdrawView)depositWView).getAccNameDd().getSelectedItem());
				if (acc.equals(((DepositWithdrawView)depositWView).getAccNameDd().getSelectedItem()))
				{
					if (((DepositWithdrawView)depositWView).getTransTypeDd().getSelectedItem() == TransactionType.Deposit)
					{
						if (!LoggedUser.getProfile().depositAmount(Float.parseFloat(((DepositWithdrawView)depositWView).getAmountTextField().getText()),
								new Currency("USD"), acc.getAccountNumber(), acc.getRoutingNumber())) {
								((DepositWithdrawView)depositWView).setMsgLabel("Your transaction is not allowed (not enough fund)");
								isAllowed = false;
						}
						//acc.de(acc.getAmount() +
						//		Float.parseFloat(((DepositWithdrawView)depositWView).getAmountTextField().getText()));
					}else
					{
						if (!LoggedUser.getProfile().withdrawAmount(Float.parseFloat(((DepositWithdrawView)depositWView).getAmountTextField().getText()),
								new Currency("USD"), acc.getAccountNumber(), acc.getRoutingNumber())) {
								((DepositWithdrawView)depositWView).setMsgLabel("Your transaction is not allowed (not enough fund)");
								isAllowed = false;
						}
					}
					if (isAllowed)
					{
						//Transaction trans = new Transaction();
						//trans.setAmount(Long.parseLong(((DepositWithdrawView)depositWView).getAmountTextField().getText()));
						//trans.setTransactionDate(new Date());
						//trans.setTransactionBy(LoggedUser.getProfile());
						//trans.setTransactionId(UUID.randomUUID().toString());
						//trans.setType((TransactionType)((DepositWithdrawView)depositWView).getTransTypeDd().getSelectedItem());
						//trans.setAccountUsed((Account)((DepositWithdrawView)depositWView).getAccNameDd().getSelectedItem());
						//Data.AddTransaction(trans);
						//acc.addTransactionList(trans);

						((DepositWithdrawView)depositWView).setMsgLabel("Your transaction is successfull");
					}

					break;
				}
			}

		}
		else {
			((DepositWithdrawView)depositWView).setMsgLabel("Your transaction is not allowed (invalid amount)");
		}






	}

	private void AddNewAccount()
	{
		if (LoggedUser.getProfile() != null)
		{
			if ((AccountType)((AddAccountView)addAccountView).getAccTypeDd().getSelectedItem() == AccountType.Checking)
			{
				LoggedUser.getProfile().addNewCheckingAccount(Bank.getNewUniqueAccountNum());
			}else if ((AccountType)((AddAccountView)addAccountView).getAccTypeDd().getSelectedItem() == AccountType.Saving)
			{
				LoggedUser.getProfile().addNewSavingsAccount(Bank.getNewUniqueAccountNum());
			}
			((AddAccountView)addAccountView).setMsgLabel("Your account is successfully created");
		}

	}

	private void bindData()
	{

		if (LoggedUser.getProfile() != null )
		{
			//System.out.println(LoggedUser.getProfile().getFirstName());

			String col[] = {"Account Number","Friendly Name","Account Type","Currency","Amount"};
			DefaultTableModel tableModel = new DefaultTableModel(col, 0);


			if (LoggedUser.getProfile().getCheckingAccounts() != null)
			{
				for (int i = 0; i < LoggedUser.getProfile().getCheckingAccounts().size(); i++)
				{
					Object[] objs = {LoggedUser.getProfile().getCheckingAccounts().get(i).getAccountNumber(),
							LoggedUser.getProfile().getCheckingAccounts().get(i).toString(), 
							"Checking Account", 
							LoggedUser.getProfile().getCheckingAccounts().get(i).getCurrency(),
							LoggedUser.getProfile().getCheckingAccounts().get(i).getBalanceInLocalCurrency()};
					tableModel.addRow(objs);
				}
			}

			if (LoggedUser.getProfile().getSavingsAccounts() != null)
			{
				for (int i = 0; i < LoggedUser.getProfile().getSavingsAccounts().size(); i++)
				{
					Object[] objs = {LoggedUser.getProfile().getSavingsAccounts().get(i).getAccountNumber(),
							LoggedUser.getProfile().getSavingsAccounts().get(i).toString(), 
							"Saving Account", 
							LoggedUser.getProfile().getSavingsAccounts().get(i).getCurrency(),
							LoggedUser.getProfile().getSavingsAccounts().get(i).getBalanceInLocalCurrency()};
					tableModel.addRow(objs);
				}
			}

			JTable table = new JTable(tableModel);
			table.setFillsViewportHeight(true);

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent event) {
					if (table.getSelectedRow() > -1) {
						// print first column value from selected row
						String id = table.getValueAt(table.getSelectedRow(), 0).toString();
						//TransactionController tc = new TransactionController();
						//tc.transactionList(id);
						//ShowCustomerProfile(id);

					}
				}
			});

			((AccountListView)accountListView).setTable(table);


		}

	}
}
