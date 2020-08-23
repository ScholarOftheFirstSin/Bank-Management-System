package bank.View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import bank.Controller.LoginController;
import bank.Controller.ProfileController;

public class MainSideView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton loginButton;
	private JButton registerButton;
	
	
	public MainSideView()
	{
		//custListButton = new JButton("Customer List");
		//loanListButton = new JButton("Loan List to Approve");
		loginButton = new JButton("Login ");
		registerButton = new JButton("Register");
		
		this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
	    		
        this.add(loginButton, gbc);
		this.add(registerButton, gbc);
		
		
		initialize();
	}
	
	private void initialize()
	{
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 LoginController loginController = new LoginController();	
				 
				 
			}
		});
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	    	
				ProfileController proController = new ProfileController();
				proController.setNew(true);	   
				proController.showNewUser();
			}
		});
		
		
	}
}
