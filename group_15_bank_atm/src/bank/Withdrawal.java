/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

public class Withdrawal extends Transaction {

    public Withdrawal(Float amount, Currency currency, int senderAccountNumber, int senderRoutingNumber) {
        super(amount, currency, senderAccountNumber, senderRoutingNumber, -1, -1);
    }

    @Override
    public String toString() {
        return "Account: " + senderAccountNumber + " withdraw " + amount.toString() + currency.toString();
    }
}
