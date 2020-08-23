/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */

/*
 A very basic clarification here is the balanceInLocalCurrency. In every account the balance is always kept in this value.
 This value is the representation of the account's balance in USD. However, every account may be in different currency,
 the currency of each account is specified by the currency member variable. So for example if the balanceInLocalCurrency is 100
 and the currency is USD the toString method will print 100USD. On the other hand, if the balance is again 100 but the currency is EUR
 then the toString method will print 91EUR because one dollar is 0.91 euros, so the conversion that takes place in the toString for example is
 balanceInLocalCurrency * rateOfUSDtoRespectiveCurrentCurrency. Hope that helps, if not text aflpd@bu.edu for further help, it is very important
 that this is clear for everyone to avoid logistics bugs.
 */
package bank;

public abstract class Account {
    //private static int accountUniqueID = 0;
    protected Float balanceInLocalCurrency;
    protected int routingNumber;
    protected int accountNumber;
    private boolean active;
    private Currency currency;
    protected Float openingCharge;
    protected Float closingCharge;

    public Account(Float balanceInLocalCurrency, int routingNumber, int accountNumber, boolean active, Currency currency, Float closingCharge, Float openingCharge) {
        this.balanceInLocalCurrency = balanceInLocalCurrency;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.active = active;
        this.currency = currency;
        this.closingCharge = closingCharge;
        this.openingCharge = openingCharge;
    }

    public Float getOpeningCharge() {
        return openingCharge;
    }

    public Float getClosingCharge() {
        return closingCharge;
    }

    // Returns the base balance
    public Float getBalanceInLocalCurrency() {
        return balanceInLocalCurrency;
    }

    // Sets the base balance
    public void setBalanceInLocalCurrency(Float balanceInLocalCurrency) {
        this.balanceInLocalCurrency = balanceInLocalCurrency;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // For example to change currency to euro call this method changeCurrencyTo(EUR)
    public void changeCurrencyTo(String abbreviation){
        currency.setCurrency(abbreviation);
    }

    public void chargeOpeningCharge(){
        balanceInLocalCurrency -= openingCharge;
    }

    public void chargeClosingCharge(){
        balanceInLocalCurrency -= closingCharge;
    }

    public boolean withdrawAmount(Float amount){
        if (amount > balanceInLocalCurrency){
            return false;
        }
        balanceInLocalCurrency -= amount;
        return true;
    }

    // Method that is strictly used as the first part of a transfer. A transfer consists from a deduct from account A
    // and a deposit to account B. This is the first part.
    public boolean withdrawAmountToTransfer(int amount){
        if (amount > balanceInLocalCurrency){
            return false;
        }
        balanceInLocalCurrency -= amount;
        return true;
    }

    // Method that is strictly used as the second part of a transfer. A transfer consists from a deduct from account A
    // and a deposit to account B. This is the second part.
    public void depositAmountFromTransfer(Float amount){
        balanceInLocalCurrency += amount;
    }

    public void depositAmount(Float amount){
        balanceInLocalCurrency += amount;
    }

//    public static int getNewAccountUniqueNumber(){
//        return accountUniqueID++;
//    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + " balance: " + balanceInLocalCurrency*Currency.getRate(currency.toString()) + currency.toString();
    }

    public Currency getCurrency() {
        return currency;
    }

    // This method was used as a helper method for a transfer. A transfer consists from two parts, the withdraw and the deposit part.
    // However if the withdraw part succeeds and the deposit part for some reason fails this is the method that returns the
    // deducted money to the first account
    public void reimbursement(Float amount){
        balanceInLocalCurrency += amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
//    public boolean equals(Account o) {
//		if (o.accountUniqueID == accountUniqueID )
//			return true;
//
//		return false;
//	}
}
