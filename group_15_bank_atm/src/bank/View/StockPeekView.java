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

import bank.*;

public class StockPeekView extends JPanel{



    private JComboBox stockBoughtc;
    private JLabel stockBoughtl;

    private JLabel amountLabel;
    private JFormattedTextField amountTextField;
    private JButton saveButton;
    private JLabel msgLabel;

    private DecimalFormatSymbols dfs;
    private DecimalFormat dFormat;

    public StockPeekView()
    {
        super(new BorderLayout());

        dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.'); //separator for the decimals
        dfs.setGroupingSeparator(','); //separator for the thousands
        dFormat = new DecimalFormat ("#0.##", dfs);




        stockBoughtl = new JLabel("The stock you bought", JLabel.TRAILING);
        stockBoughtc = new JComboBox();
        stockBoughtl.setLabelFor(stockBoughtc);
//        for (var acc : LoggedUser.getProfile().getCheckingAccounts()) {
//            accNameDd.addItem(acc);
//        }
//        for (var acc : LoggedUser.getProfile().getSavingsAccounts()) {
//            accNameDd.addItem(acc);
//        }
        /*for (BoughtStock bs : LoggedUser.getProfile().getSecurityAccount().getBoughtStocks()) {
            stockBoughtc.addItem(bs.getStock().getName());
        }*/

        for (int i = 0; i< LoggedUser.getProfile().getSecurityAccount().getBoughtStocks().size(); i++) {
            stockBoughtc.addItem(LoggedUser.getProfile().getSecurityAccount().getBoughtStocks().get(i).getStock().getName());
        }

        amountLabel = new JLabel("Amount", JLabel.TRAILING);
        amountTextField = new JFormattedTextField(dFormat);
        amountLabel.setLabelFor(amountTextField);

        saveButton = new JButton("See possible profit");
        msgLabel = new JLabel();

        JPanel jp = new JPanel(new SpringLayout());

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jp.add(stockBoughtl);
        jp.add(stockBoughtc);

        jp.add(amountLabel);
        jp.add(amountTextField);

        SpringUtilities.makeCompactGrid(jp, 2, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        this.add(jp, gbc);
        this.add(saveButton,gbc);
        this.add(msgLabel, gbc);
    }

    public JComboBox getStockBoughtc() {
        return stockBoughtc;
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