/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

public class SavingsAccount extends Account {
    private Float interest;
    public SavingsAccount(Float amountInLocalCurrency, int routingNumber, int accountNumber, boolean active, Currency currency,
                          Float closingCharge, Float openingCharge, Float interest) {
        super(amountInLocalCurrency, routingNumber, accountNumber, active, currency, closingCharge, openingCharge);
        this.interest = interest;
    }

    // Method that when called increases the the balance by the agreed interest percentage
    public void payInterest(){
        setBalanceInLocalCurrency(balanceInLocalCurrency + balanceInLocalCurrency * interest/100);
    }

    public Float getInterest() {
        return interest;
    }

    public Boolean checkIfBalanceSufficientForTransfer(Float amount, int targetAccountN, int targetRoutingN){
        if (accountNumber == targetAccountN && routingNumber == targetRoutingN){
            if (amount <= balanceInLocalCurrency){
                return true;
            }else{
                return false;
            }
        }
        return null;
    }
}
