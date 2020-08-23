package bank;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LoanAppilcationView extends JPanel {

	private JComboBox loanTypeDd;
	private JLabel loanTypeLabel;

	private JLabel amountLabel;
	private JTextField amountTextField;
	
	private JLabel colateralLabel;
	private JTextField colateralTextField;
	
	private JLabel termLabel;
	private JTextField termTextField;
	
	private JButton saveButton;
	private JLabel msgLabel;
	
	private JLabel headerLabel;

	public LoanAppilcationView()
	{
		super(new BorderLayout());
		
		headerLabel = new JLabel("Apply for new loan");

		loanTypeLabel = new JLabel("Loan Type", JLabel.TRAILING);		
		loanTypeDd = new JComboBox(LoanType.values());
		loanTypeLabel.setLabelFor(loanTypeDd);

		amountLabel = new JLabel("Amount", JLabel.TRAILING);		
		amountTextField = new JTextField(10);
		amountLabel.setLabelFor(amountTextField);
		
		colateralLabel = new JLabel("Colateral", JLabel.TRAILING);		
		colateralTextField = new JTextField(20);
		colateralLabel.setLabelFor(colateralTextField);
		
		termLabel = new JLabel("Term in years", JLabel.TRAILING);		
		termTextField = new JTextField(10);
		termLabel.setLabelFor(termTextField);

		saveButton = new JButton("Save");
		msgLabel = new JLabel();

		JPanel jp = new JPanel(new SpringLayout());

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
//		jp.add(loanTypeLabel);
//		jp.add(loanTypeDd);
		jp.add(amountLabel);		
		jp.add(amountTextField);
//		jp.add(termLabel);
//		jp.add(termTextField);
//		jp.add(colateralLabel);
//		jp.add(colateralTextField);
		

		SpringUtilities.makeCompactGrid(jp, 1, 2, //rows, cols
				6, 6, //initX, initY
				6, 6); //xPad, yPad

		this.add(headerLabel, gbc);
		this.add(jp, gbc);
		this.add(saveButton,gbc);
		this.add(msgLabel, gbc);
	}

	public JComboBox getLoanTypeDd() {
		return loanTypeDd;
	}

	public void setLoanTypeDd(JComboBox loanTypeDd) {
		this.loanTypeDd = loanTypeDd;
	}

	public JLabel getLoanTypeLabel() {
		return loanTypeLabel;
	}

	public void setLoanTypeLabel(JLabel loanTypeLabel) {
		this.loanTypeLabel = loanTypeLabel;
	}

	public JLabel getAmountLabel() {
		return amountLabel;
	}

	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}

	public JTextField getAmountTextField() {
		return amountTextField;
	}

	public void setAmountTextField(JTextField amountTextField) {
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


	public JTextField getColateralTextField() {
		return colateralTextField;
	}

	public void setColateralTextField(JTextField colateralTextField) {
		this.colateralTextField = colateralTextField;
	}
	

	public JTextField getTermTextField() {
		return termTextField;
	}

	public void setTermTextField(JTextField termTextField) {
		this.termTextField = termTextField;
	}

	
	

}
