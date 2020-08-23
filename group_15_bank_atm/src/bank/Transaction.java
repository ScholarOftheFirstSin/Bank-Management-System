/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

import java.time.LocalDateTime;

public abstract class Transaction {
    protected final Float amount;
    protected int senderAccountNumber;
    protected int senderRoutingNumber;
    protected int receiverAccountNumber;
    protected int receiverRoutingNumber;
    private final LocalDateTime date;
    protected final Currency currency;

    public Transaction(Float amount, Currency currency, int senderAccountNumber, int senderRoutingNumber, int receiverAccountNumber, int receiverRoutingNumber) {
        this.amount = amount;
        this.currency = currency;
        this.senderAccountNumber = senderAccountNumber;
        this.senderRoutingNumber = senderRoutingNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverRoutingNumber = receiverRoutingNumber;
        this.date = LocalDateTime.now();
    }

    public Float getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public abstract String toString();

    public int getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public int getSenderRoutingNumber() {
        return senderRoutingNumber;
    }

    public int getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public int getReceiverRoutingNumber() {
        return receiverRoutingNumber;
    }

    public boolean isTodays(){
        LocalDateTime today = LocalDateTime.now();
        return date.getDayOfYear() == today.getDayOfYear() && date.getYear() == today.getYear();
    }

    // Determines if it is read by the manager before or not
    public boolean isRead(LocalDateTime lastTimeBankerReadReports){
        return date.isBefore(lastTimeBankerReadReports);
    }

    public Currency getCurrency() {
        return currency;
    }
}
