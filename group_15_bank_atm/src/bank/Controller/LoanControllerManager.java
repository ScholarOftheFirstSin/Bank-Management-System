package bank.Controller;

import bank.Data;
import bank.LoggedUser;
import bank.PanelData;
import bank.View.LoanListView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LoanControllerManager {
    private LoanListView loanListView;

    public LoanControllerManager() {
        loanListView = new LoanListView();
        PanelData.setParentPanel(loanListView);
        bindData();

    }

    private void bindData()
    {



            //System.out.println(LoggedUser.getProfile().getFirstName());

            String col[] = {"Loan Number","Currency","Initial Amount", "Interest (%/year)"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            for (int i = 0; i < Data.getBank().getCustomerAccounts().size(); i++) {
                for (int j = 0; j < Data.getBank().getCustomerAccounts().get(i).getLoans().size(); j++)
                {
                    Object[] objs = {
                            Data.getBank().getCustomerAccounts().get(i).getLoans().get(j).toString(),
                            Data.getBank().getCustomerAccounts().get(i).getLoans().get(j).getCurrency(),
                            Data.getBank().getCustomerAccounts().get(i).getLoans().get(j).getInitialAmountInLocalCurrency(),
                            Data.getBank().getCustomerAccounts().get(i).getLoans().get(j).getInterest()
                            //LoggedUser.getProfile().getLoans().get(i).get(),
                            //LoggedUser.getProfile().getLoanList().get(i).getStatus(),
                            //LoggedUser.getProfile().getLoanList().get(i).getStartDate(),
                            //LoggedUser.getProfile().getLoanList().get(i).getTerm()
                    };
                    tableModel.addRow(objs);
                }



            }
           JTable table = new JTable(tableModel);
           table.setFillsViewportHeight(true);
           loanListView.setTable(table);


		/*
		else if (LoggedUser.getProfile() != null && LoggedUser.getProfile().getUserType() == UserType.BankManager)
		{
			//System.out.println(LoggedUser.getProfile().getFirstName());

			String col[] = {"Requestor", "Loan Number","Loan Type","Amount", "Interest (%/year)","Collateral", "Status", "Term in Years"};
			DefaultTableModel tableModel = new DefaultTableModel(col, 0);

			for (int i = 0; i < Data.getLoanList().size(); i++)
			{
			Object[] objs = {
					Data.getLoanList().get(i).getProfile().toString(),
					Data.getLoanList().get(i).getLoanId(),
					Data.getLoanList().get(i).getType(),
					Data.getLoanList().get(i).getAmount(),
					Data.getLoanList().get(i).getInterest(),
					Data.getLoanList().get(i).getCollateral(),
					Data.getLoanList().get(i).getStatus(),
					Data.getLoanList().get(i).getTerm()
			};

			tableModel.addRow(objs);
			}

			JTable table = new JTable(tableModel);
			table.setFillsViewportHeight(true);
			((LoanListView)loanListView).setTable(table);


		}
		*/
    }

}
