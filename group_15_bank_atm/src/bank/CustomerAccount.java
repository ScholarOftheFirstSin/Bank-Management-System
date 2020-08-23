/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

import java.util.ArrayList;

/*
There are two not-so-clear points here. The first is collateral. The way I have implemented this a customer either has collateral or does not.
If he/she has that means that he can have any kind of loans he/she asks. If not, well, he/she does not. At any time the manager can change
this trust indicator of a client. The second kind of blurry part is the cancelLastTransferWithdrawal. As stated,
This method was used as a helper method for a transfer. A transfer consists from two parts, the withdraw and the deposit part.
However if the withdraw part succeeds and the deposit part for some reason fails this is the method that returns the
system to the previous status like neither of the parts ever happened
 */

public class CustomerAccount {
    private Person person;
    private ArrayList<CheckingAccount> checkingAccounts;
    private ArrayList<SavingsAccount> savingsAccounts;
    private ArrayList<Loan> loans;
    private ArrayList<Transaction> transactions;
    private SecurityAccount securityAccount;
    private boolean collateral;

    public CustomerAccount(Person person, boolean collateral, int newAccountUniqueID) {
        this.person = person;
        this.collateral = collateral;
        this.checkingAccounts = new ArrayList<CheckingAccount>();
        this.savingsAccounts = new ArrayList<SavingsAccount>();
        this.transactions = new ArrayList<Transaction>();
        this.loans= new ArrayList<Loan>();
        securityAccount = new SecurityAccount(0.0f, 0, newAccountUniqueID, true, new Currency("USD"), 0.0f, 0.0f);
    }

    public CustomerAccount(Person person) {
        this(person, true, Bank.getNewUniqueAccountNum());
    }

    @Override
    public String toString() {
        return person.toString();
    }

    public void addNewCheckingAccount(int newAccountUniqueID){
        Currency currency = new Currency("USD");
        checkingAccounts.add(new CheckingAccount(0.0f, 0, newAccountUniqueID, true, currency,
                0.0f, 0.0f, 0.0f,0.0f));
    }

    public void addNewCheckingAccount(CheckingAccount checkingAccount){
        checkingAccounts.add(checkingAccount);
    }

    public SecurityAccount getSecurityAccount() {
        return securityAccount;
    }

    public void addNewSavingsAccount(int newAccountUniqueID){
        Currency currency = new Currency("USD");
        savingsAccounts.add(new SavingsAccount(0.0f, 0, newAccountUniqueID, true, currency,
                0.0f, 0.0f, 0.0f));
    }

    public void addNewSavingsAccount(SavingsAccount savingsAccount){
        savingsAccounts.add(savingsAccount);
    }

    public boolean addNewLoan(Float amount, Currency currency){
        if (collateral){
            //Currency currency = new Currency("USD");
            loans.add(new Loan(currency, 5.5f, amount));
            return true;
        }
        return false;
    }

    public boolean addNewLoan(Loan loan){
        loans.add(loan);
        return true;
    }

    public void addExistingDepositTransaction(Deposit deposit){
        transactions.add(deposit);
    }

    // Method that tries to find in this customer the account specified by receiverAccountNumber and receiverRoutingNumber to perform a deposit
    // If it is found it adds this transaction to this users transactions and returns true, if the account is not found
    // it returns false
    public boolean depositAmount(Float amount, Currency currency, int receiverAccountNumber, int receiverRoutingNumber){
        for (CheckingAccount checkingAccount :
                checkingAccounts) {
            if (checkingAccount.getAccountNumber() == receiverAccountNumber && checkingAccount.getRoutingNumber() == receiverRoutingNumber){
                checkingAccount.depositAmount(amount);
                transactions.add(new Deposit(amount*Currency.getRate(currency.toString()), currency, receiverAccountNumber, receiverRoutingNumber));
                return true;
            }
        }

        for (SavingsAccount savingsAccount :
                savingsAccounts) {
            if (savingsAccount.getAccountNumber() == receiverAccountNumber && savingsAccount.getRoutingNumber() == receiverRoutingNumber){
                savingsAccount.depositAmount(amount);
                transactions.add(new Deposit(amount*Currency.getRate(currency.toString()), currency, receiverAccountNumber, receiverRoutingNumber));
                return true;
            }
        }
        return false;
    }

    // Method that tries to find in this customer the account specified by receiverAccountNumber and receiverRoutingNumber to perform a transfer deposit
    // If it is found it adds this transaction to this users transactions and returns true, if the account is not found
    // it returns false
    public boolean depositTransferAmount(Float amount, Currency currency, int senderAccountNumber, int senderRoutingNumber, int receiverAccountNumber, int receiverRoutingNumber){
        for (CheckingAccount checkingAccount :
                checkingAccounts) {
            if (checkingAccount.getAccountNumber() == receiverAccountNumber && checkingAccount.getRoutingNumber() == receiverRoutingNumber){
                checkingAccount.depositAmountFromTransfer(amount);
                transactions.add(new Transfer(amount*Currency.getRate(currency.toString()), currency, senderAccountNumber, senderRoutingNumber, receiverAccountNumber, receiverRoutingNumber));
                return true;
            }
        }

        for (SavingsAccount savingsAccount :
                savingsAccounts) {
            if (savingsAccount.getAccountNumber() == receiverAccountNumber && savingsAccount.getRoutingNumber() == receiverRoutingNumber){
                savingsAccount.depositAmountFromTransfer(amount);
                transactions.add(new Transfer(amount*Currency.getRate(currency.toString()), currency, senderAccountNumber, senderRoutingNumber, receiverAccountNumber, receiverRoutingNumber));
                return true;
            }
        }
        return false;
    }

    public void addExistingWithdrawalTransaction(Withdrawal withdrawal){
        transactions.add(withdrawal);
    }

    // Method that tries to find in this customer the account specified by receiverAccountNumber and receiverRoutingNumber to perform a withdrawal
    // If it is found it adds this transaction to this users transactions and returns true, if the account is not found
    // it returns false
    public boolean withdrawAmount(Float amount, Currency currency, int senderAccountNumber, int senderRoutingNumber){
        for (CheckingAccount checkingAccount :
                checkingAccounts) {
            if (checkingAccount.getAccountNumber() == senderAccountNumber && checkingAccount.getRoutingNumber() == senderRoutingNumber){
                if (checkingAccount.withdrawAmount(amount)){
                    transactions.add(new Withdrawal(amount*Currency.getRate(currency.toString()), currency, senderAccountNumber, senderRoutingNumber));
                    return true;
                }else {
                    return false;
                }
            }
        }

        for (SavingsAccount savingsAccount :
                savingsAccounts) {
            if (savingsAccount.getAccountNumber() == senderAccountNumber && savingsAccount.getRoutingNumber() == senderRoutingNumber){
                if (savingsAccount.withdrawAmount(amount)){
                    transactions.add(new Withdrawal(amount*Currency.getRate(currency.toString()), currency, senderAccountNumber, senderRoutingNumber));
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    // Method that tries to find in this customer the account specified by receiverAccountNumber and receiverRoutingNumber to perform a transfer withdrawal
    // If it is found it adds this transaction to this users transactions and returns true, if the account is not found
    // it returns false
    public boolean withdrawTransferAmount(Float amount, Currency currency, int senderAccountNumber, int senderRoutingNumber, int receiverAccountNumber, int receiverRoutingNumber){
        for (CheckingAccount checkingAccount :
                checkingAccounts) {
            if (checkingAccount.getAccountNumber() == senderAccountNumber && checkingAccount.getRoutingNumber() == senderRoutingNumber){
                if (checkingAccount.withdrawAmount(amount)){
                    transactions.add(new Transfer(amount*Currency.getRate(currency.toString()), currency, senderAccountNumber, senderRoutingNumber, receiverAccountNumber, receiverRoutingNumber));
                    return true;
                }else{
                    return false;
                }
            }
        }

        for (SavingsAccount savingsAccount :
                savingsAccounts) {
            if (savingsAccount.getAccountNumber() == senderAccountNumber && savingsAccount.getRoutingNumber() == senderRoutingNumber){
                if (savingsAccount.withdrawAmount(amount)){
                    transactions.add(new Transfer(amount*Currency.getRate(currency.toString()), currency, senderAccountNumber, senderRoutingNumber, receiverAccountNumber, receiverRoutingNumber));
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public void addExistingTransferTransaction(Transfer transfer){
        transactions.add(transfer);
    }

    // Method that is called if the second part of a transfer fails. The purpose of this method is to give back the money to the account
    // from which we made the transfer withdrawal and to delete the transaction from its list of transactions. I know that this may be confusing
    // feel free to contact aflpd@bu.edu for more details
    public void cancelLastTransferWithdrawal(){
        Transaction lastTransaction = transactions.get(transactions.size() - 1);
        int lastTransAccN = lastTransaction.getSenderAccountNumber();
        int lastTransRoutN = lastTransaction.getSenderRoutingNumber();
        Float lastTransAmount = lastTransaction.getAmount()*Currency.getRate(lastTransaction.getCurrency().toString());

        boolean transferCanceled = false;

        for (CheckingAccount checkingAccount :
                checkingAccounts) {
            if (checkingAccount.getAccountNumber() == lastTransAccN && checkingAccount.getRoutingNumber() == lastTransRoutN){
                checkingAccount.reimbursement(lastTransAmount);
                transactions.remove(transactions.size() - 1);
                transferCanceled = true;
            }

        }

        if (!transferCanceled){
            for (SavingsAccount savingsAccount :
                    savingsAccounts) {
                if (savingsAccount.getAccountNumber() == lastTransAccN && savingsAccount.getRoutingNumber() == lastTransRoutN){
                    savingsAccount.reimbursement(lastTransAmount);
                    transactions.remove(transactions.size() - 1);
                    break;
                }

            }
        }

    }

    public Person getPerson() {
        return person;
    }


    public ArrayList<Transaction> getAllTransactions() {
        return transactions;

    }

    public ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> allButDepositTransfTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions){
            if (transaction instanceof Transfer){
                if (checkIfAccountExists(transaction.getSenderAccountNumber(), transaction.getSenderRoutingNumber())){
                    allButDepositTransfTransactions.add(transaction);
                }
            }else{
                allButDepositTransfTransactions.add(transaction);
            }
        }
        return allButDepositTransfTransactions;
    }

    public SavingsAccount getLastSavingsAccount(){
        if (savingsAccounts.size() > 0){
            return savingsAccounts.get(savingsAccounts.size() - 1);
        }
        return null;
    }

    public CheckingAccount getLastCheckingAccount(){
        if (checkingAccounts.size() > 0){
            return checkingAccounts.get(checkingAccounts.size() - 1);
        }
        return null;
    }

    public boolean isCollateral() {
        return collateral;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<CheckingAccount> getCheckingAccounts() {
        return checkingAccounts;
    }

    public ArrayList<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }
    
    public boolean checkIfAccountExists(int targetAccountN, int targetRoutingN){
        for (CheckingAccount checkingAccount :
                checkingAccounts) {
            if (checkingAccount.getAccountNumber() == targetAccountN && checkingAccount.getRoutingNumber() == targetRoutingN){
                return true;
            }
        }
        for (SavingsAccount savingsAccount :
                savingsAccounts) {
            if (savingsAccount.getAccountNumber() == targetAccountN && savingsAccount.getRoutingNumber() == targetAccountN){
                return true;
            }
        }
        return false;
    }

    public boolean checkIfBalanceSufficientForTransfer(Float amount, int targetAccountN, int targetRoutingN){
        for (CheckingAccount checkingAccount :
                checkingAccounts) {
            Boolean checkFlag = checkingAccount.checkIfBalanceSufficientForTransfer(amount, targetAccountN, targetRoutingN);
            if (checkFlag != null){
                return checkFlag;
            }else{
                return false;
            }
        }
        for (SavingsAccount savingsAccount :
                savingsAccounts) {
            Boolean checkFlag = savingsAccount.checkIfBalanceSufficientForTransfer(amount, targetAccountN, targetRoutingN);
            if (checkFlag != null){
                return checkFlag;
            }else{
                return false;
            }
        }
        return false;
    }

    public void setSecurityAccount(SecurityAccount securityAccount) {
        this.securityAccount = securityAccount;
    }
}
