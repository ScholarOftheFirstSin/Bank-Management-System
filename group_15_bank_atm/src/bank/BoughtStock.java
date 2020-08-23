package bank;

import java.time.LocalDateTime;

public class BoughtStock {
    private Stock stock;
    private int sharesAmount;
    private Float totalAmountSpentOnBuying;
    private LocalDateTime firstTimeStockWasBought;
    private LocalDateTime lastTimeStockWasBought;

    public BoughtStock(Stock stock, int sharesAmount) {
        this.stock = stock;
        this.sharesAmount = sharesAmount;
        this.totalAmountSpentOnBuying = stock.getCurrentPrice() * sharesAmount;
        this.firstTimeStockWasBought = LocalDateTime.now();
        this.lastTimeStockWasBought = LocalDateTime.now();
    }

    public int getSharesAmount() {
        return sharesAmount;
    }

    public Float getTotalAmountSpentOnBuying() {
        return totalAmountSpentOnBuying;
    }

    public Stock getStock() {
        return stock;
    }

    public int getAmountOfStocks() {
        return sharesAmount;
    }

    public LocalDateTime getFirstTimeStockWasBought() {
        return firstTimeStockWasBought;
    }

    public LocalDateTime getLastTimeStockWasBought() {
        return lastTimeStockWasBought;
    }

    // adds n more shares of that stock
    public void addNStocks(int n){
        sharesAmount += n;
        totalAmountSpentOnBuying += stock.getCurrentPrice() * n;
    }

    // Deducts n shares from this BoughtStock and returns the profit that the user made by selling those
    public Float sellNStocks(int n){
        Float averagePricePaidForEachShare = totalAmountSpentOnBuying / sharesAmount;
        sharesAmount -= n;
        totalAmountSpentOnBuying -= averagePricePaidForEachShare * n;
        //return n * (averagePricePaidForEachShare - stock.getCurrentPrice());
        return n * (stock.getCurrentPrice() - averagePricePaidForEachShare);
    }

    // Returns to the user how much money will he make if he sells right now n shares
    public Float returnPossibleProfit(int n){
        Float averagePricePaidForEachShare = totalAmountSpentOnBuying / sharesAmount;
        //return n * (averagePricePaidForEachShare - stock.getCurrentPrice());
        return n * (stock.getCurrentPrice() - averagePricePaidForEachShare);

    }

    public Float returnBoughtPrice() {
        return totalAmountSpentOnBuying / sharesAmount;
    }

    @Override
    public String toString() {
        return "BoughtStock{" +
                "stock=" + stock +
                ", sharesAmount=" + sharesAmount +
                ", totalAmountSpentOnBuying=" + totalAmountSpentOnBuying +
                '}';
    }
}
