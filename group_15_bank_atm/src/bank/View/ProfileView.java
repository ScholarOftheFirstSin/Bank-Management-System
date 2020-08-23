package bank.View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import bank.SpringUtilities;

import java.awt.GridLayout;

public class ProfileView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel middleNameLabel;
	private JTextField middleNameTextField;
	private JLabel AddressLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;	
	private JTextField AddressTextField;
	private JButton saveButton;
	
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;	
	private JLabel msgLabel;
	private JLabel headerLabel;
	
	public ProfileView()
	{
		super(new BorderLayout());
		headerLabel = new JLabel("Profile Detail");
		
		firstNameLabel = new JLabel("First Name", JLabel.TRAILING);		
		firstNameTextField = new JTextField(20);
		firstNameLabel.setLabelFor(firstNameTextField);
		
		middleNameLabel = new JLabel("Middle Name" , JLabel.TRAILING);		
		middleNameTextField = new JTextField(10);
		middleNameLabel.setLabelFor(middleNameTextField);
		
		lastNameLabel = new JLabel("Last Name", JLabel.TRAILING);
		lastNameTextField = new JTextField(20);
		lastNameLabel.setLabelFor(lastNameTextField);
		
		AddressLabel = new JLabel("Address", JLabel.TRAILING);
		AddressTextField = new JTextField(50);
		AddressLabel.setLabelFor(AddressTextField);
		
		emailLabel = new JLabel("Email", JLabel.TRAILING);		
		emailTextField = new JTextField(20);
		emailLabel.setLabelFor(emailTextField);
		
		passwordLabel = new JLabel("Password", JLabel.TRAILING);		
		passwordTextField = new JPasswordField(20);
		passwordLabel.setLabelFor(passwordTextField);
		
		saveButton = new JButton("Sign Up ");
		msgLabel = new JLabel();
		
       
        JPanel jp = new JPanel(new SpringLayout());

		this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
	    
        //jp.add(emailLabel);		
		//jp.add(emailTextField);
		jp.add(firstNameLabel);		
		jp.add(firstNameTextField);
		//jp.add(middleNameLabel);
		//jp.add(middleNameTextField);
		jp.add(lastNameLabel);		
		jp.add(lastNameTextField);
		//jp.add(AddressLabel);
		//jp.add(AddressTextField);
		//jp.add(passwordLabel);
		//jp.add(passwordTextField);
		
		SpringUtilities.makeCompactGrid(jp, 2, 2, //rows, cols
		        6, 6, //initX, initY
		        6, 6); //xPad, yPad
		
		
		
		this.add(headerLabel, gbc);
		this.add(jp, gbc);
		this.add(saveButton,gbc);
		this.add(msgLabel, gbc);
	}
	
	public void setMsgLabel(String msgLabel) {
		this.msgLabel.setText(msgLabel);
	}

	public JLabel getFirstNameLabel() {
		return firstNameLabel;
	}

	public void setFirstNameLabel(JLabel firstNameLabel) {
		this.firstNameLabel = firstNameLabel;
	}

	public JLabel getLastNameLabel() {
		return lastNameLabel;
	}

	public void setLastNameLabel(JLabel lastNameLabel) {
		this.lastNameLabel = lastNameLabel;
	}

	public JLabel getAddressLabel() {
		return AddressLabel;
	}

	public void setAddressLabel(JLabel addressLabel) {
		AddressLabel = addressLabel;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(String firstNameTextField) {
		this.firstNameTextField.setText(firstNameTextField);
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(String lastNameTextField) {
		this.lastNameTextField.setText(lastNameTextField);
	}

	public JTextField getMiddleNameTextField() {
		return middleNameTextField;
	}

	public void setMiddleNameTextField(String middleNameTextField) {
		this.middleNameTextField.setText(middleNameTextField);
	}

	public JTextField getAddressTextField() {
		return AddressTextField;
	}

	public void setAddressTextField(String addressTextField) {
		AddressTextField.setText(addressTextField);
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(String emailTextField) {
		this.emailTextField.setText(emailTextField);
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(String passwordTextField) {
		this.passwordTextField.setText(passwordTextField);
	}


	public void setMiddleNameTextField(JTextField middleNameTextField) {
		this.middleNameTextField = middleNameTextField;
	}

	public void setFirstNameTextField(JTextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public void setLastNameTextField(JTextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}
	
	

}
