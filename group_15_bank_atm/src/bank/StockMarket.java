package bank;

import bank.MySql.DBManager;

import java.util.ArrayList;

public class StockMarket {
    public  ArrayList<Stock>  stocks;
    public  int numsOfStocks;

    StockMarket() {
        stocks = new ArrayList<>();
        numsOfStocks = 0;
    }

    public void addStock(String name, int totalShares, int current, float pricePerShare) {
        stocks.add(new Stock(pricePerShare, totalShares, current, name, "", ""));
    }

    public void loadAllStocks(DBManager dbManager){
        addStocks((ArrayList<Stock>)dbManager.readStocks());
    }

    public void addStocks(ArrayList<Stock> stocks) {
        this.stocks.addAll(stocks);
    }

    public Stock getStockByName(String name) {
        int temp = stockExists(name);
        return stocks.get(temp);
    }

    public boolean deleteStock(String name) {
        int temp = stockExists(name);
        if (temp != -1){
            stocks.remove(temp);
            return true;
        }
        return false;

    }

    private int stockExists(String name){
        for (int i = 0; i < stocks.size(); i ++){
            if (stocks.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public boolean changeStockPrice(String name, Float newPrice) {
        int temp = stockExists(name);
        if (temp != -1){
            stocks.get(temp).setPrice(newPrice);
            return true;
        }
        return false;
    }

    public boolean changeStockCurrentShare(String name, int newShare) {
        int temp = stockExists(name);
        if (temp != -1){
            stocks.get(temp).setCurrentlyAvailableShares(newShare);
            return true;
        }
        return false;
    }

    public boolean changeStockTotalShare(String name, int newTotal){
        int temp = stockExists(name);
        if (temp != -1){
            stocks.get(temp).setTotalShares(newTotal);
            return true;
        }
        return false;
    }



    public  ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void saveStocks(DBManager dbManager){
        for (Stock stock : stocks) {
            dbManager.addStock(stock);
        }
    }
}
