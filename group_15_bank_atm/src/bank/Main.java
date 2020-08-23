/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;


import javax.swing.JFrame;

import bank.MySql.*;

public class Main {
	
	

    public static void main(String[] args) {
        Person manager = new Person("Christine", "Papadakis");
        BankManagerAccount managerAccount = new BankManagerAccount(manager);
        Bank bank = new Bank(managerAccount);
        StockMarket stockMarket = new StockMarket();

        DBManager dbManager = new DBManager();

        dbManager.connect();

        bank.loadCustomerAccounts(dbManager);
        stockMarket.loadAllStocks(dbManager);

        Data.setBank(bank);
        Data.setStockMarket(stockMarket);

        WindowsBuilder w = new WindowsBuilder(dbManager);
    }
    
   
}

// adding the my code
