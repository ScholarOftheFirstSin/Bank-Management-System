/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

public class Deposit extends Transaction {

    public Deposit(Float amount, Currency currency, int receiverAccountNumber, int receiverRoutingNumber) {
        super(amount, currency, -1, -1, receiverAccountNumber, receiverRoutingNumber);
    }

    @Override
    public String toString() {
        return "Account: " + receiverAccountNumber + " deposited " + amount.toString() + currency.toString();
    }
}
