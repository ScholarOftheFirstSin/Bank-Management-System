/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

public class CheckingAccount extends Account {
    private Float transferFee;
    private Float withdrawalFee;

    public CheckingAccount(Float amountInLocalCurrency, int routingNumber, int accountNumber, boolean active, Currency currency,
                           Float closingCharge, Float openingCharge, Float transferFee, Float withdrawalFee) {
        super(amountInLocalCurrency, routingNumber, accountNumber, active, currency, closingCharge, openingCharge);
        this.transferFee = transferFee;
        this.withdrawalFee = withdrawalFee;
    }

    // If the parent class reassures us that the money asked to withdraw exist, if the account is a checking account we have
    // to ensure that there exist enough money to deduct the withdraw fee as well, otherwise return that the transaction could
    // not be performed
    @Override
    public boolean withdrawAmount(Float amount){
        if (super.withdrawAmount(amount)){
            if (withdrawalFee > balanceInLocalCurrency){
                balanceInLocalCurrency += amount;
                return false;
            }
            balanceInLocalCurrency -= withdrawalFee;
            return true;
        }
        return false;
    }

    // If the parent class reassures us that the money asked to deduct for a transfer exist, if the account is a checking account we have
    // to ensure that there exist enough money to deduct the transfer fee as well, otherwise return that the transaction could
    // not be performed
    @Override
    public boolean withdrawAmountToTransfer(int amount){
        if (super.withdrawAmountToTransfer(amount)){
            if (transferFee > balanceInLocalCurrency){
                balanceInLocalCurrency += amount;
                return false;
            }
            balanceInLocalCurrency -= transferFee;
            return true;
        }
        return false;
    }

    public Float getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(Float transferFee) {
        this.transferFee = transferFee;
    }

    public Float getWithdrawalFee() {
        return withdrawalFee;
    }

    public void setWithdrawalFee(Float withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

    public Boolean checkIfBalanceSufficientForTransfer(Float amount, int targetAccountN, int targetRoutingN){
        if (accountNumber == targetAccountN && routingNumber == targetRoutingN){
            if (amount + transferFee <= balanceInLocalCurrency){
                return true;
            }else{
                return false;
            }
        }
        return null;
    }
}
