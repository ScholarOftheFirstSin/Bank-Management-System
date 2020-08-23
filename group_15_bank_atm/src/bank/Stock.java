package bank;

/*
I added the variables forecast and demand that we will not use in this implementation but may be useful in a future expansion
 */
public class Stock {
    private Float price; // The current price of the stock
    private int totalShares; // The total amount of shares that exist for this stock at this moment
    private int currentlyAvailableShares; // The total amount of shares that are available to be bought for this stock at this moment
    private final String name;
    private String forecast;
    private String demand;

    public Stock(Float price, int totalShares, int currentlyAvailableShares, String name, String forecast, String demand) {
        this.price = price;
        this.totalShares = totalShares;
        this.currentlyAvailableShares = currentlyAvailableShares;
        this.name = name;
        this.forecast = forecast;
        this.demand = demand;
    }

    public Stock(Float price, int totalShares, int currentlyAvailableShares, String name) {
        this.price = price;
        this.totalShares = totalShares;
        this.currentlyAvailableShares = currentlyAvailableShares;
        this.name = name;
    }

    public Float getCurrentPrice() {
        return price;
    }

    public int getTotalShares() {
        return totalShares;
    }

    public int getCurrentlyAvailableShares() {
        return currentlyAvailableShares;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setCurrentlyAvailableShares(int currentlyAvailableShares) {
        this.currentlyAvailableShares = currentlyAvailableShares;
    }

    // Checks if there are at least n available shares to be bought from this stock
    public boolean checkIfThereAreAvailableShares(int n){
        return currentlyAvailableShares >= n;
    }

    // Try to buy n shares of this stock. If there are enough available deduct n and return true
    // otherwise reply false
    public boolean buyShares(int n){
        if (checkIfThereAreAvailableShares(n)){
            currentlyAvailableShares -= n;
            return true;
        }
        return false;
    }

    // When a customer sells his shares we have to return the amount of sold shares to the bank
    public void returnSoldShares(int n){
        currentlyAvailableShares += n;
    }

    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }
}
