package bank.Controller;

import bank.Data;
import bank.LoggedUser;
import bank.PanelData;
import bank.View.AccountListView;
import bank.View.TransactionListView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TransactionController {
    private TransactionListView transactionListView;

    public TransactionController() {
        transactionListView = new TransactionListView();
    }

    public void transactionList() {
        transactionListView.setVisible(true);
        PanelData.setParentPanel(transactionListView);
        bindData();
    }

    private void bindData()
    {
            String col[] = {"Transactions"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            for(int i = 0; i < Data.getBank().getAllTransactions().size(); i++) {
                Object[] objs = {Data.getBank().getAllTransactions().get(i).toString()};
                tableModel.addRow(objs);
            }

            JTable table = new JTable(tableModel);
            table.setFillsViewportHeight(true);



            transactionListView.setTable(table);


    }

}

