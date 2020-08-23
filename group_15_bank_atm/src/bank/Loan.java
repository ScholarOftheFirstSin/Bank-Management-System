/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

public class Loan {
    private Float initialAmountInLocalCurrency;
    private Float debtInLocalCurrency;
    private Currency currency;
    private Float interest;

    public Loan(Currency currency, Float interest, float initialAmountInLocalCurrency) {
        this.debtInLocalCurrency = initialAmountInLocalCurrency;
        this.currency = currency;
        this.interest = interest;
        this.initialAmountInLocalCurrency = initialAmountInLocalCurrency;
    }

    public void changeCurrencyTo(String abbreviation){
        currency.setCurrency(abbreviation);
    }

    public void addToDebt(float amount){
        debtInLocalCurrency += amount;
    }

    public boolean deductFromDebt(float amount){
        if (amount > debtInLocalCurrency){
            return false;
        }
        debtInLocalCurrency -= amount;
        return true;
    }

    public Float getInitialAmountInLocalCurrency() {
        return initialAmountInLocalCurrency;
    }

    public Float getDebtInLocalCurrency() {
        return debtInLocalCurrency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Float getInterest() {
        return interest;
    }

    @Override
    public String toString() {
        return "Remaining Debt: " + getDebtInLocalCurrency().toString() + " " + currency.toString();
    }
}
