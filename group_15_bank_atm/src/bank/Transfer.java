/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

public class Transfer extends Transaction {

    public Transfer(Float amount, Currency currency, int senderAccountNumber, int senderRoutingNumber, int receiverAccountNumber, int receiverRoutingNumber) {
        super(amount, currency, senderAccountNumber, senderRoutingNumber, receiverAccountNumber, receiverRoutingNumber);
    }

    @Override
    public String toString() {
        return "Account: " + senderAccountNumber + " sent " + amount.toString() + currency.toString() + " to account: " + receiverAccountNumber;
    }
}
