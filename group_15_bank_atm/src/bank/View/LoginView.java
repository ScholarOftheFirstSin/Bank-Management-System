package bank.View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import bank.SpringUtilities;

import javax.swing.Spring;
import javax.swing.SpringLayout;

public class LoginView  extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JTextField fNAmeTextField;
	private JTextField lNameTextField;	
	private JButton loginButton;
	private JButton newButton;
	private JButton loginManagerButton;
	private JLabel msgLabel;
	private JLabel headerLabel;
	
	public LoginView()
	{
		headerLabel = new JLabel("Please log in");
		emailLabel = new JLabel("First Name", JLabel.TRAILING);		
		fNAmeTextField = new JTextField(20);
		emailLabel.setLabelFor(fNAmeTextField);
		passwordLabel = new JLabel("Last Name", JLabel.TRAILING);
		lNameTextField = new JTextField(20);
		passwordLabel.setLabelFor(lNameTextField);
		loginButton = new JButton("Sign In");
		newButton = new JButton("Sign Up New User");
		loginManagerButton = new JButton("Login Manager");
		msgLabel = new JLabel("");
		
		JPanel jp = new JPanel(new SpringLayout());

		this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
	    
		jp.add(emailLabel);		
		jp.add(fNAmeTextField);
		jp.add(passwordLabel);
		jp.add(lNameTextField);
		//jp.add(loginButton);
		//jp.add(msgLabel);
		
		//this.add(calcPanel);
		
		SpringUtilities.makeCompactGrid(jp, 2, 2, //rows, cols
		        6, 6, //initX, initY
		        6, 6); //xPad, yPad
		this.add(headerLabel, gbc);
		this.add(jp, gbc);
		this.add(msgLabel, gbc);
		this.add(loginButton,gbc);
		this.add(newButton,gbc);
		this.add(loginManagerButton,gbc);
		
	}
	
	
	
	public JTextField getfNAmeTextField() {
		return fNAmeTextField;
	}



	public void setfNAmeTextField(JTextField fNAmeTextField) {
		this.fNAmeTextField = fNAmeTextField;
	}



	public JTextField getlNameTextField() {
		return lNameTextField;
	}



	public void setlNameTextField(JPasswordField lNameTextField) {
		this.lNameTextField = lNameTextField;
	}



	public JLabel getEmailLabel() {
		return emailLabel;
	}


	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}


	public JLabel getPasswordLabel() {
		return passwordLabel;
	}


	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}


	


	public JLabel getMsgLabel() {
		return msgLabel;
	}

	public void setMsgLabel(String msgLabel) {
		this.msgLabel.setText(msgLabel);
	}

	


	public JButton getLoginButton() {
		return loginButton;
	}


	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getNewButton() {
		return newButton;
	}

	public void setNewButton(JButton newButton) {
		this.newButton = newButton;
	}

	public JButton getLoginManagerButton() {
		return loginManagerButton;
	}

	public void setLoginManagerButton(JButton loginManagerButton) {
		this.loginManagerButton = loginManagerButton;
	}
	
	
}
