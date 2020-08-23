package bank.View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AccountListView extends JPanel{

private static final long serialVersionUID = 1L;
	
	private JLabel headerLabel;
	private JTable table;
	private JButton transactionButton;
	private JButton newAccountButton;
	
	
	public JButton getTransactionButton() {
		return transactionButton;
	}

	public void setTransactionButton(JButton transactionButton) {
		this.transactionButton = transactionButton;
	}

	public JButton getNewAccountButton() {
		return newAccountButton;
	}

	public void setNewAccountButton(JButton newAccountButton) {
		this.newAccountButton = newAccountButton;
	}

	
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
		
		JScrollPane scrollPane = new JScrollPane(table);
		Dimension d = table.getPreferredSize();
		scrollPane.setPreferredSize(
		    new Dimension(d.width,table.getRowHeight()*6+1));
		add(scrollPane, BorderLayout.CENTER);
	}

	public AccountListView()
	{
		super(new BorderLayout());
		transactionButton = new JButton("Deposit/Withdraw");
		newAccountButton = new JButton("Create New Account");
		JPanel topPan = new JPanel(new BorderLayout());
		headerLabel = new JLabel("List of your account");		
		topPan.add(headerLabel, BorderLayout.NORTH);	
		topPan.add(Box.createVerticalStrut(10));
		topPan.add(transactionButton, BorderLayout.WEST);	
		topPan.add(newAccountButton, BorderLayout.EAST);	
		
		add(topPan, BorderLayout.NORTH);
	}
	
	
	
}
