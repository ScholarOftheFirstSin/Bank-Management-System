package bank.View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LoanListView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel headerLabel;
	private JButton newLoanButton;
	JTable table;

	public LoanListView()
	{
		super(new BorderLayout());

		newLoanButton = new JButton("Request New Loan");
		JPanel topPan = new JPanel(new BorderLayout());
		//if (LoggedUser.getProfile() != null && LoggedUser.getProfile().getUserType() == UserType.Customer)
		//{
		//	headerLabel = new JLabel("List of your loan");		
		//}else
		//{
			headerLabel = new JLabel("List of loan");
		//}

		topPan.add(headerLabel, BorderLayout.NORTH);	
		topPan.add(Box.createVerticalStrut(10));
		//if (LoggedUser.getProfile() != null && LoggedUser.getProfile().getUserType() == UserType.Customer)
		//	topPan.add(newLoanButton, BorderLayout.WEST);	
		add(topPan, BorderLayout.NORTH);
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

	public JButton getNewLoanButton() {
		return newLoanButton;
	}

	public void setNewLoanButton(JButton newLoanButton) {
		this.newLoanButton = newLoanButton;
	}


}
