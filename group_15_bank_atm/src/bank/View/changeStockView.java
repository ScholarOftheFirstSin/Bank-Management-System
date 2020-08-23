package bank.View;

import bank.Data;
import bank.SpringUtilities;
import bank.Stock;
import bank.StockMarket;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class changeStockView extends JPanel {

    private JComboBox stockComboBox;
    private JLabel stockLabel;

    private JLabel currentLabel;
    private JTextField currentTextField;

    private JLabel totalShareLabel;
    private JTextField totalShareTextField;

    private JLabel priceLabel;
    private JTextField priceTextField;

    private JButton saveButton;
    private JLabel msgLabel;

    private JLabel headerLabel;

    public changeStockView()
    {
        super(new BorderLayout());

        headerLabel = new JLabel("Change stock attributes");

        stockLabel = new JLabel("Stock", JLabel.TRAILING);
        stockComboBox = new JComboBox();
        stockLabel.setLabelFor(stockComboBox);

        for (int i = 0; i < Data.getStockMarket().getStocks().size(); i++) {

                stockComboBox.addItem(Data.getStockMarket().getStocks().get(i).getName());


        }

        currentLabel = new JLabel("New Current Available Share", JLabel.TRAILING);
        currentTextField = new JTextField(10);
        currentLabel.setLabelFor(currentTextField);

        totalShareLabel = new JLabel("New Total Share", JLabel.TRAILING);
        totalShareTextField = new JTextField(20);
        totalShareLabel.setLabelFor(totalShareTextField);

        priceLabel = new JLabel("New price", JLabel.TRAILING);
        priceTextField = new JTextField(10);
        priceLabel.setLabelFor(priceTextField);

        saveButton = new JButton("Save");
        msgLabel = new JLabel();

        JPanel jp = new JPanel(new SpringLayout());

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jp.add(stockLabel);
        jp.add(stockComboBox);
        jp.add(currentLabel);
        jp.add(currentTextField);
        jp.add(totalShareLabel);
        jp.add(totalShareTextField);
        jp.add(priceLabel);
        jp.add(priceTextField);


        SpringUtilities.makeCompactGrid(jp, 4, 2, //rows, cols
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

    public JComboBox getStockComboBox() {
        return stockComboBox;
    }

    public JTextField getTotalShareTextField() {
        return totalShareTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public JTextField getCurrentTextField() {
        return currentTextField;
    }
}

