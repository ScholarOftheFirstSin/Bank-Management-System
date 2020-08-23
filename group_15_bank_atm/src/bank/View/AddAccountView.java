package bank.View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import bank.AccountType;
import bank.CurrencyType;
import bank.SpringUtilities;

public class AddAccountView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JComboBox accTypeDd;
	private JLabel accTypeLabel;
	private JComboBox currTypeDd;
	private JLabel currTypeLabel;
	private JLabel friendlyNameLable;
	private JTextField friendlyNameTextField;
	private JButton saveButton;
	private JLabel msgLabel;
	private JLabel headerLabel;

	public AddAccountView()
	{
		super(new BorderLayout());
		headerLabel = new JLabel("Add account");
		
		accTypeLabel = new JLabel("Account Type", JLabel.TRAILING);		
		accTypeDd = new JComboBox(AccountType.values());
		accTypeLabel.setLabelFor(accTypeDd);
		currTypeLabel = new JLabel("Currency", JLabel.TRAILING);		
		currTypeDd = new JComboBox(CurrencyType.values());
		currTypeLabel.setLabelFor(currTypeDd);

		friendlyNameLable = new JLabel("Friendly Name", JLabel.TRAILING);		
		friendlyNameTextField = new JTextField(10);
		friendlyNameLable.setLabelFor(friendlyNameTextField);

		saveButton = new JButton("Save");
		msgLabel = new JLabel();

		JPanel jp = new JPanel(new SpringLayout());

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jp.add(accTypeLabel);		
		jp.add(accTypeDd);
		//jp.add(currTypeLabel);		
		//jp.add(currTypeDd);
		//jp.add(friendlyNameLable);		
		//jp.add(friendlyNameTextField);
		

		SpringUtilities.makeCompactGrid(jp, 1, 2, //rows, cols
				6, 6, //initX, initY
				6, 6); //xPad, yPad
		this.add(headerLabel, gbc);
		this.add(jp, gbc);
		this.add(saveButton,gbc);
		this.add(msgLabel, gbc);
		
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

	public JComboBox getAccTypeDd() {
		return accTypeDd;
	}

	public void setAccTypeDd(JComboBox accTypeDd) {
		this.accTypeDd = accTypeDd;
	}

	public JTextField getFriendlyNameTextField() {
		return friendlyNameTextField;
	}

	public void setFriendlyNameTextField(JTextField friendlyNameTextField) {
		this.friendlyNameTextField = friendlyNameTextField;
	}

	public JComboBox getCurrTypeDd() {
		return currTypeDd;
	}

	public void setCurrTypeDd(JComboBox currTypeDd) {
		this.currTypeDd = currTypeDd;
	}
	
}
