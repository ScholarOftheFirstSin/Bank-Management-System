package bank.View;

import bank.SpringUtilities;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ManagerStockView extends JPanel {

    private JTextField nameTextField;
    private JLabel nameLabel;

    private JLabel currentAvailableShareLabel;
    private JTextField currentAvailableShareTextField;

    private JLabel totalShareLabel;
    private JTextField totalShareTextField;

    private JLabel priceLabel;
    private JTextField priceTextField;

    private JButton saveButton;
    private JLabel msgLabel;

    private JButton changeStockButton;

    private JLabel headerLabel;

    public ManagerStockView()
    {
        super(new BorderLayout());

        headerLabel = new JLabel("Set new stock");

        nameLabel = new JLabel("Stock Name", JLabel.TRAILING);
        nameTextField = new JTextField(10);
        nameLabel.setLabelFor(nameTextField);

        currentAvailableShareLabel = new JLabel("Current Available Share", JLabel.TRAILING);
        currentAvailableShareTextField = new JTextField(10);
        currentAvailableShareLabel.setLabelFor( currentAvailableShareTextField);

        totalShareLabel = new JLabel("Total Share", JLabel.TRAILING);
        totalShareTextField = new JTextField(20);
        totalShareLabel.setLabelFor(totalShareTextField);

        priceLabel = new JLabel("Price per Share", JLabel.TRAILING);
        priceTextField = new JTextField(10);
        priceLabel.setLabelFor(priceTextField);

        changeStockButton = new JButton("Change stock");

        saveButton = new JButton("Save");
        msgLabel = new JLabel();

        JPanel jp = new JPanel(new SpringLayout());

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jp.add(nameLabel);
        jp.add(nameTextField);
        jp.add(totalShareLabel);
        jp.add(totalShareTextField);
        jp.add(currentAvailableShareLabel);
        jp.add(currentAvailableShareTextField);
        jp.add(priceLabel);
        jp.add(priceTextField);


        SpringUtilities.makeCompactGrid(jp, 4, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        this.add(headerLabel, gbc);
        this.add(jp, gbc);
        this.add(saveButton,gbc);
        this.add(changeStockButton, gbc);
        this.add(msgLabel, gbc);
    }

    public JButton getChangeStockButton() {
        return changeStockButton;
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

    public JTextField getCurrentAvailableShareTextField() {
        return currentAvailableShareTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public JTextField getTotalShareTextField() {
        return totalShareTextField;
    }
}

