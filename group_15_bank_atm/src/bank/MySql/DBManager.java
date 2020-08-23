package bank.MySql;

import bank.CustomerAccount;

import bank.*;

import java.nio.charset.CharsetEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    Connection con;

    public DBManager(){
        connect();
    }
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank_atm","root","6638woaihuoying");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from person");
            while(rs.next())
                System.out.println(rs.getString(2));
        }catch(Exception e){ System.out.println(e);}
    }
    public void close(){
        try {
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }
    public void addPerson(CustomerAccount customerAccount){
        String sql = "INSERT INTO bank_atm.person (name) VALUES (\'"+ customerAccount.getPerson().getName().getFirstName() + " "+ customerAccount.getPerson().getName().getLastName()+ "\');";
        sqlExecute(sql);
    }
    public void addCheckingAccount(CheckingAccount checkingAccount, CustomerAccount customerAccount){
        String sql = "INSERT INTO bank_atm.account (balance, routing_num, acc_num, active, open_fee, close_fee, transaction_fee, withdrawal_fee, type, person_name, routing_acc) VALUES (\'" + checkingAccount.getBalanceInLocalCurrency() + "\', \'" + checkingAccount.getRoutingNumber() + "\', \'" + checkingAccount.getAccountNumber() + "\', " +
                ""+ checkingAccount.isActive() +", \'"+ checkingAccount.getOpeningCharge() +"\', \'"+ checkingAccount.getClosingCharge() +"\', \'" + checkingAccount.getTransferFee() + "\', \'"+ checkingAccount.getWithdrawalFee() +"\', \'" + "C" +"\', \'" + customerAccount.getPerson().getName().getFirstName() +" "+ customerAccount.getPerson().getName().getLastName() +"\', \'"+checkingAccount.getRoutingNumber() + checkingAccount.getAccountNumber()+"\');";
        System.out.println(sql);
        sqlExecute(sql);
    }
    public void addSavingAccount(SavingsAccount savingsAccount, CustomerAccount customerAccount){
        String sql = "INSERT INTO bank_atm.account (balance, routing_num, acc_num, active, open_fee, close_fee, interest, type, person_name, routing_acc) VALUES (\'" + savingsAccount.getBalanceInLocalCurrency() + "\', \'" + savingsAccount.getRoutingNumber() + "\', \'" + savingsAccount.getAccountNumber() + "\', " +
                ""+ savingsAccount.isActive() +", \'"+ savingsAccount.getOpeningCharge() +"\', \'"+ savingsAccount.getClosingCharge() +"\', \'" + savingsAccount.getInterest() + "\', \'" + "S" +"\', \'" + customerAccount.getPerson().getName().getFirstName() +" "+ customerAccount.getPerson().getName().getLastName() + "\', \'"+savingsAccount.getRoutingNumber() + savingsAccount.getAccountNumber()+"\');";
        System.out.println(sql);
        sqlExecute(sql);
    }
    public void addSecurityAccount(SecurityAccount securityAccount, CustomerAccount customerAccount){
        String sql = "INSERT INTO bank_atm.account (balance, routing_num, acc_num, active, open_fee, close_fee, type, person_name, routing_acc) VALUES (\'" + securityAccount.getBalanceInLocalCurrency() + "\', \'" + securityAccount.getRoutingNumber() + "\', \'" + securityAccount.getAccountNumber() + "\', " +
                ""+ securityAccount.isActive() +", \'"+ securityAccount.getOpeningCharge() +"\', \'"+ securityAccount.getClosingCharge()  + "\', \'" + "I" +"\', \'" + customerAccount.getPerson().getName().getFirstName() +" "+ customerAccount.getPerson().getName().getLastName() + "\', \'"+securityAccount.getRoutingNumber() + securityAccount.getAccountNumber()+"\');";
        System.out.println(sql);
        sqlExecute(sql);
    }

    public void addBoughtStock(BoughtStock boughtStock, SecurityAccount securityAccount){
        String sql = "INSERT INTO bank_atm.bought_stock (share_amount, worth, account_id, stock_name) VALUES (\'"+ boughtStock.getAmountOfStocks() +"\', \'" + boughtStock.getTotalAmountSpentOnBuying() + "\', \'"+ securityAccount.getRoutingNumber() + securityAccount.getAccountNumber() + "\',\'" +boughtStock.getStock().getName()+"\');";
        System.out.println(sql);
        sqlExecute(sql);
    }

    public void addDeposit(Deposit transaction){

        String sql = "INSERT INTO bank_atm.transaction (sender_acc_num, sender_routing_num, rec_acc_num, rec_routing_num, currency, amount, type) VALUES (\'" +transaction.getSenderAccountNumber()+ "\', \'"+ transaction.getSenderRoutingNumber()+"\', \'" + transaction.getReceiverAccountNumber()+ "\', \'"+transaction.getReceiverRoutingNumber()+"\', \'"+transaction.getCurrency().toString()+"\', \'"+transaction.getAmount()+"\', \'D\');";
        System.out.println(sql);
        sqlExecute(sql);
    }
    public void addWithdrawal(Withdrawal transaction){
        String sql = "INSERT INTO bank_atm.transaction (sender_acc_num, sender_routing_num, rec_acc_num, rec_routing_num, currency, amount, type) VALUES (\'" +transaction.getSenderAccountNumber()+ "\', \'"+ transaction.getSenderRoutingNumber()+"\', \'" + transaction.getReceiverAccountNumber()+ "\', \'"+transaction.getReceiverRoutingNumber()+"\', \'"+transaction.getCurrency().toString()+"\', \'"+transaction.getAmount()+"\', \'W\');";
        System.out.println(sql);
        sqlExecute(sql);
    }
    public void addTransfer(Transfer transaction){
        String sql = "INSERT INTO bank_atm.transaction (sender_acc_num, sender_routing_num, rec_acc_num, rec_routing_num, currency, amount, type) VALUES (\'" +transaction.getSenderAccountNumber()+ "\', \'"+ transaction.getSenderRoutingNumber()+"\', \'" + transaction.getReceiverAccountNumber()+ "\', \'"+transaction.getReceiverRoutingNumber()+"\', \'"+transaction.getCurrency().toString()+"\', \'"+transaction.getAmount()+"\', \'T\');";
        System.out.println(sql);
        sqlExecute(sql);
    }

    public void addLoan(Loan loan, CustomerAccount customerAccount){
        String sql = " INSERT INTO bank_atm.loan (initial_amount, debt, owner, interest) VALUES (\'"+loan.getInitialAmountInLocalCurrency()+"\', \'"+loan.getDebtInLocalCurrency()+"\', \'"+customerAccount.getPerson().getName().getFirstName()+ " " +  customerAccount.getPerson().getName().getLastName()+"\', \'"+loan.getInterest()+"\');";
        sqlExecute(sql);
    }

    public void addStock(Stock stock){

        String sql = "INSERT INTO bank_atm.stock (name, price, total_shares, avai_shares) VALUES (\'"+stock.getName()+"\', \' " + stock.getCurrentPrice()+ "\', \'"+ stock.getTotalShares()+"\', \'"+ stock.getCurrentlyAvailableShares()+"\');";
        System.out.println(sql);
        sqlExecute(sql);

    }


    // SELECT
    public List<Person> readPersons(){
        List<Person> list = new ArrayList<>();


        try {
            Statement stmt=con.createStatement();
            String sql = "SELECT * FROM bank_atm.person";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Person temp;
            while(rs.next()) {
                String name = rs.getString("name");
                String[] names = name.split(" ");
                temp = new Person(names[0], names[1]);
                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }

    public List<Loan> readLoans(String firstName, String lastName){
        List<Loan> list = new ArrayList<>();

        try {
            Statement stmt=con.createStatement();
            String sql = "SELECT * FROM bank_atm.loan WHERE owner = \'"+firstName + " " + lastName+"\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Loan temp;
            while(rs.next()) {
                temp = new Loan(new Currency("USD"), rs.getFloat("interest"), rs.getFloat("initial_amount"));
                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }



    public List<CheckingAccount> readCheckingAccounts(String firstName, String lastName){
        List<CheckingAccount> list = new ArrayList<>();


        try {
            Statement stmt=con.createStatement();
            String sql = "select * from account WHERE type = \'C\' AND person_name = \'"+ firstName + " " + lastName+"\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);


            CheckingAccount temp;
            while(rs.next()) {

                temp = new CheckingAccount(rs.getFloat("balance"), rs.getInt("routing_num"), rs.getInt("acc_num"), rs.getBoolean("active"), new Currency("USD")
                        , rs.getFloat("close_fee"), rs.getFloat("open_fee"), rs.getFloat("transaction_fee"), rs.getFloat("withdrawal_fee"));
                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }


    public List<SavingsAccount> readSavingAccounts(String firstName, String lastName){
        List<SavingsAccount> list = new ArrayList<>();


        try {
            Statement stmt=con.createStatement();
            String sql = "select * from account WHERE type = \'S\' AND person_name = \'"+ firstName + " " + lastName+"\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            SavingsAccount temp;
            while(rs.next()) {

                temp = new SavingsAccount(rs.getFloat("balance"), rs.getInt("routing_num"), rs.getInt("acc_num"), rs.getBoolean("active"), new Currency("USD")
                        , rs.getFloat("close_fee"), rs.getFloat("open_fee"), rs.getFloat("interest"));
                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }


    public List<SecurityAccount> readSecurityAccounts(String firstName, String lastName){
        List<SecurityAccount> list = new ArrayList<>();


        try {
            Statement stmt=con.createStatement();
            String sql = "select * from account WHERE type = \'I\' AND person_name = \'"+ firstName + " " + lastName+"\';";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            SecurityAccount temp;
            while(rs.next()) {

                temp = new SecurityAccount(rs.getFloat("balance"), rs.getInt("routing_num"), rs.getInt("acc_num"), rs.getBoolean("active"), new Currency("USD")
                        , rs.getFloat("close_fee"), rs.getFloat("open_fee"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }

    public List<Stock> readStocks(){
        List<Stock> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();

            String sql = "select * from stock";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Stock temp;
            while(rs.next()) {

                temp = new Stock(rs.getFloat("price"), rs.getInt("total_shares"), rs.getInt("avai_shares"), rs.getString("name"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }
    public Stock readStockByName(String stock_name){
        Stock temp = null;
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from stock WHERE name = \'" + stock_name + "\';";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {

                temp = new Stock(rs.getFloat("price"), rs.getInt("total_shares"), rs.getInt("avai_shares"), rs.getString("name"));
                break;
            }
        }
        catch(Exception e){ System.out.println(e);}
        return temp;
    }

    public List<BoughtStock> readBoughtStocks(SecurityAccount securityAccount){
        List<BoughtStock> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from bank_atm.bought_stock WHERE account_id = "+securityAccount.getRoutingNumber() + securityAccount.getAccountNumber()+";";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            BoughtStock temp;

            while(rs.next()) {
                String stock_name = rs.getString("stock_name");
                Stock stock = readStockByName(stock_name);
                temp = new BoughtStock(stock, rs.getInt("share_amount"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }


    public List<Deposit> readDepositsByAccount(int routing_num, int acc_num){
        List<Deposit> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from transaction WHERE type = \'D\' AND rec_acc_num = \'"+ acc_num +"\' AND  rec_routing_num = \'" + routing_num +"\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Deposit temp;

            while(rs.next()) {
                temp = new Deposit(rs.getFloat("amount"), new Currency(rs.getString("currency")),rs.getInt("rec_acc_num"), rs.getInt("rec_routing_num"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }

    public List<Withdrawal> readWithdrawalsByAccount(int routing_num, int acc_num){
        List<Withdrawal> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from transaction WHERE type = \'W\' AND sender_acc_num = \'"+ acc_num +"\' AND sender_routing_num = \'" + routing_num +"\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Withdrawal temp;

            while(rs.next()) {
                temp = new Withdrawal(rs.getFloat("amount"), new Currency(rs.getString("currency")),rs.getInt("sender_acc_num"), rs.getInt("sender_routing_num"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }

    public List<Transfer> readTransfersByAccount(int routing_num, int acc_num){
        List<Transfer> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from transaction WHERE type = \'T\' AND (sender_acc_num = \'"+ acc_num +"\' AND sender_routing_num = \'" + routing_num +"\') OR (rec_acc_num = \'"+ acc_num +"\' AND  rec_routing_num = \'" + routing_num +"\')";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Transfer temp;

            while(rs.next()) {
                temp = new Transfer(rs.getFloat("amount"), new Currency(rs.getString("currency")), rs.getInt("sender_acc_num"), rs.getInt("sender_routing_num"),rs.getInt("rec_acc_num"), rs.getInt("rec_routing_num"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }


    public List<Deposit> readDeposits(){
        List<Deposit> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from transaction WHERE type = \'D\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Deposit temp;

            while(rs.next()) {
                temp = new Deposit(rs.getFloat("amount"), new Currency(rs.getString("currency")),rs.getInt("rec_acc_num"), rs.getInt("rec_routing_num"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }
    public List<Withdrawal> readWithdrawals(){
        List<Withdrawal> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from transaction WHERE type = \'W\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Withdrawal temp;

            while(rs.next()) {
                temp = new Withdrawal(rs.getFloat("amount"), new Currency(rs.getString("currency")),rs.getInt("sender_acc_num"), rs.getInt("sender_routing_num"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }
    public List<Transfer> readTransfers(){
        List<Transfer> list = new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            String sql = "select * from transaction WHERE type = \'T\'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            Transfer temp;

            while(rs.next()) {
                temp = new Transfer(rs.getFloat("amount"), new Currency(rs.getString("currency")), rs.getInt("sender_acc_num"), rs.getInt("sender_routing_num"),rs.getInt("rec_acc_num"), rs.getInt("rec_routing_num"));

                list.add(temp);
            }
        }
        catch(Exception e){ System.out.println(e);}
        return list;
    }

    // UPDATE
    public void updateCheckingAccount(CheckingAccount checkingAccount){
        String sql = "UPDATE bank_atm.account SET balance = \'" + checkingAccount.getBalanceInLocalCurrency() +  "\', active = "+ checkingAccount.isActive() + " , open_fee = \'" + checkingAccount.getOpeningCharge() +"\', close_fee = \'" + checkingAccount.getClosingCharge() +"\', transaction_fee = \'" + checkingAccount.getTransferFee() + "\', " +
                "withdrrawal_fee = \'"+ checkingAccount.getWithdrawalFee() +"\' WHERE (acc_num = \' "+ checkingAccount.getAccountNumber()+" \' AND routing_num = \'"+ checkingAccount.getAccountNumber()+ " \');\n";
        sqlExecute(sql);
    }

    public void updateSavingAccount(SavingsAccount savingsAccount){
        String sql = "UPDATE bank_atm.account SET balance = \'" + savingsAccount.getBalanceInLocalCurrency() +  "\', active = "+ savingsAccount.isActive() + " , open_fee = \'" + savingsAccount.getOpeningCharge() +"\', close_fee = \'" + savingsAccount.getClosingCharge() +"\'," +
                "interest = \'"+ savingsAccount.getInterest() +"\' WHERE (acc_num = \' "+ savingsAccount.getAccountNumber()+" \' AND routing_num = \'"+ savingsAccount.getAccountNumber()+ " \');\n";
        sqlExecute(sql);
    }

    public void updateAccount(Account account){
        String sql = "UPDATE bank_atm.account SET balance = \'" + account.getBalanceInLocalCurrency() +  "\', active = "+ account.isActive() + " , open_fee = \'" + account.getOpeningCharge() +"\', close_fee = \'" + account.getClosingCharge() +"\'," +
                "\' WHERE (acc_num = \' "+ account.getAccountNumber()+" \' AND routing_num = \'"+ account.getAccountNumber()+ " \');\n";
        sqlExecute(sql);
    }

    public void updateStock(Stock stock){
        String sql = "UPDATE bank_atm.stock SET price = \'" +stock.getCurrentPrice()+ "\', total_shares = \'"+ stock.getTotalShares()+"\', avai_shares = \'"+stock.getCurrentlyAvailableShares()+"\', WHERE (name = \'"+stock.getName()+"\');";

        sqlExecute(sql);
    }

    public void updateBoughtStock(BoughtStock boughtStock, SecurityAccount account){


        String sql = "UPDATE bank_atm.bought_stock SET share_amount = \'"+ boughtStock.getAmountOfStocks() +"\', worth = \'" + boughtStock.getTotalAmountSpentOnBuying()+ "\' WHERE (stock_name = \'"+boughtStock.getStock().getName()+"\' AND account_id = \'" + account.getAccountNumber()+"\');";
        sqlExecute(sql);

    }

    // DELETE
    public void deletePerson(){
        String sql = "DELETE FROM bank_atm.person";
        sqlExecute(sql);
    }
    public void deleteAccount(){
        String sql = "DELETE FROM bank_atm.account";
        sqlExecute(sql);
    }
    public void deleteLoan(){
        String sql = "DELETE FROM bank_atm.loan";
        sqlExecute(sql);
    }
    public void deleteStock(){
        String sql = "DELETE FROM bank_atm.stock";
        sqlExecute(sql);
    }
    public void deleteBoughtStock(){
        String sql = "DELETE FROM bank_atm.bought_stock";
        sqlExecute(sql);
    }
    public void deleteTransaction(){
        String sql = "DELETE FROM bank_atm.transaction";
        sqlExecute(sql);
    }






    public void sqlExecute(String sql){
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
        }
        catch(Exception e){ System.out.println(e);}
    }
}

