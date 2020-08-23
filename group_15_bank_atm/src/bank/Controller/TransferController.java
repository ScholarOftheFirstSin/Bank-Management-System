package bank.Controller;

import bank.*;
import bank.View.TransferView;

public class TransferController {
    private TransferView transferView;

    public TransferController() {
        transferView = new TransferView();
        initController();
        transferView.setVisible(true);
        PanelData.setParentPanel(transferView);
    }

    public void initController()
    {
        transferView.getSaveButton().addActionListener(l -> transfer());

    }

    public void transfer() {


        //LoggedUser.getProfile().depositAmount(01, 1, receiverAccountNumber, receiverRoutingNumber)
        for (int i = 0; i < Data.getBank().getCustomerAccounts().size(); i++) {
            for (CheckingAccount acc : Data.getBank().getCustomerAccounts().get(i).getCheckingAccounts()) {


                if (acc.equals(transferView.getAccNameDd().getSelectedItem())) {
                    if (Float.parseFloat(transferView.getAmountTextField().getText()) <= 0) {
                        transferView.setMsgLabel("Your transaction is not allowed (negative number)");
                    } else if (LoggedUser.getProfile().withdrawTransferAmount(Float.parseFloat(transferView.getAmountTextField().getText()), new Currency("USD"), LoggedUser.getProfile().getCheckingAccounts().get(0).getAccountNumber(), LoggedUser.getProfile().getCheckingAccounts().get(0).getRoutingNumber(), acc.getAccountNumber(), acc.getRoutingNumber())) {
                        Data.getBank().getCustomerAccounts().get(i).depositTransferAmount(Float.parseFloat(transferView.getAmountTextField().getText()), new Currency("USD"), LoggedUser.getProfile().getCheckingAccounts().get(0).getAccountNumber(), LoggedUser.getProfile().getCheckingAccounts().get(0).getRoutingNumber(), acc.getAccountNumber(), acc.getRoutingNumber());
                        transferView.setMsgLabel("Your transaction is successful");
                    } else {
                        transferView.setMsgLabel("Your transaction is not allowed (Not enough fund)");
                    }

                }
            }

            for (SavingsAccount acc : Data.getBank().getCustomerAccounts().get(i).getSavingsAccounts()) {


                if (acc.equals(transferView.getAccNameDd().getSelectedItem())) {

                    if (Float.parseFloat(transferView.getAmountTextField().getText()) <= 0) {
                        transferView.setMsgLabel("Your transaction is not allowed (negative number)");
                    } else if (LoggedUser.getProfile().withdrawTransferAmount(Float.parseFloat(transferView.getAmountTextField().getText()), new Currency("USD"), LoggedUser.getProfile().getCheckingAccounts().get(0).getAccountNumber(), LoggedUser.getProfile().getCheckingAccounts().get(0).getRoutingNumber(), acc.getAccountNumber(), acc.getRoutingNumber())) {
                        Data.getBank().getCustomerAccounts().get(i).depositTransferAmount(Float.parseFloat(transferView.getAmountTextField().getText()), new Currency("USD"), LoggedUser.getProfile().getCheckingAccounts().get(0).getAccountNumber(), LoggedUser.getProfile().getCheckingAccounts().get(0).getRoutingNumber(), acc.getAccountNumber(), acc.getRoutingNumber());
                        transferView.setMsgLabel("Your transaction is successful");
                    } else {
                        transferView.setMsgLabel("Your transaction is not allowed (Not enough fund)");
                    }

                }
            }


        }


    }






}
