package bank.View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import bank.Account;
import bank.LoggedUser;
import bank.SpringUtilities;
import bank.TransactionType;

public class DepositWithdrawView extends JPanel{

	private JComboBox transTypeDd;
	private JLabel transTypeLabel;
	private JComboBox<Account> accNameDd;
	private JLabel accNameLabel;

	private JLabel amountLabel;
	private JFormattedTextField amountTextField;
	private JButton saveButton;
	private JLabel msgLabel;
	
	private DecimalFormatSymbols dfs;
	private DecimalFormat dFormat;

	public DepositWithdrawView()
	{
		super(new BorderLayout());
		
		dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.'); //separator for the decimals
		dfs.setGroupingSeparator(','); //separator for the thousands
		dFormat = new DecimalFormat ("#0.##", dfs);


		transTypeLabel = new JLabel("Transaction Type", JLabel.TRAILING);		
		transTypeDd = new JComboBox(TransactionType.values());
		transTypeLabel.setLabelFor(transTypeDd);

		accNameLabel = new JLabel("Account Name", JLabel.TRAILING);		
		accNameDd = new JComboBox<Account>();
		accNameLabel.setLabelFor(accNameDd);
		for (var acc : LoggedUser.getProfile().getCheckingAccounts()) {
			accNameDd.addItem(acc);
		}
		for (var acc : LoggedUser.getProfile().getSavingsAccounts()) {
			accNameDd.addItem(acc);
		}

		amountLabel = new JLabel("Amount", JLabel.TRAILING);		
		amountTextField = new JFormattedTextField(dFormat);
		amountLabel.setLabelFor(amountTextField);

		saveButton = new JButton("Save");
		msgLabel = new JLabel();

		JPanel jp = new JPanel(new SpringLayout());

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jp.add(accNameLabel);		
		jp.add(accNameDd);
		jp.add(transTypeLabel);		
		jp.add(transTypeDd);		
		jp.add(amountLabel);		
		jp.add(amountTextField);

		SpringUtilities.makeCompactGrid(jp, 3, 2, //rows, cols
				6, 6, //initX, initY
				6, 6); //xPad, yPad

		this.add(jp, gbc);
		this.add(saveButton,gbc);
		this.add(msgLabel, gbc);
	}

	public JComboBox getTransTypeDd() {
		return transTypeDd;
	}

	public void setTransTypeDd(JComboBox transTypeDd) {
		this.transTypeDd = transTypeDd;
	}

	public JComboBox getAccNameDd() {
		return accNameDd;
	}

	public void setAccNameDd(JComboBox accNameDd) {
		this.accNameDd = accNameDd;
	}

	public JFormattedTextField getAmountTextField() {
		return amountTextField;
	}

	public void setAmountTextField(JFormattedTextField amountTextField) {
		this.amountTextField = amountTextField;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JLabel getMsgLabel() {
		return msgLabel;
	}

	public void setMsgLabel(String msgLabel) {
		this.msgLabel.setText(msgLabel);
	}
	
	
}
