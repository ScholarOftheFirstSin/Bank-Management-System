/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankManagerAccount {
    private Person person;
    private LocalDateTime lastReportTimestamp;


    public BankManagerAccount(Person person) {
        this.person = person;
        this.lastReportTimestamp = LocalDateTime.now();

    }

    public Person getPerson() {
        return person;
    }

    public ArrayList<Transaction> getDailyReport(ArrayList<Transaction> allTransactions){
        //System.out.println(allTransactions.size());
        ArrayList<Transaction> todaysTransactions = new ArrayList<Transaction>();
        for (Transaction transaction:
             allTransactions) {
            if (transaction.isTodays()){
                todaysTransactions.add(transaction);
            }
        }
        lastReportTimestamp = LocalDateTime.now();
        //System.out.println(todaysTransactions.size());
        return todaysTransactions;
    }

    public ArrayList<Transaction> getUnreadReports(ArrayList<Transaction> allTransactions){
        ArrayList<Transaction> unreadTransactions = new ArrayList<Transaction>();
        for (Transaction transaction:
                allTransactions) {
            if (!transaction.isRead(lastReportTimestamp)){
                unreadTransactions.add(transaction);
            }
        }
        lastReportTimestamp = LocalDateTime.now();
        return unreadTransactions;
    }
}
