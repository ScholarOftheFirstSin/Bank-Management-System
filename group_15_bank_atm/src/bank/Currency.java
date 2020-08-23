/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

import java.util.Map;

import static java.util.Map.entry;

public class Currency {
    private String abbreviation;
    private static Map<String, String> abbreviationToFullName = Map.ofEntries(
            entry("USD", "US Dollar"),
            entry("EUR", "Euro"),
            entry("CHF", "Swiss Franc")
    );
    private static Map<String, Float> abbreviationToRate = Map.ofEntries(
            entry("USD", 1.0f),
            entry("EUR", 0.91f),
            entry("CHF", 2.0f)
    );

    public Currency(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static String getFullName(String abbreviation) {
        return abbreviationToFullName.get(abbreviation);
    }

    public static Float getRate(String abbreviation) {
        return abbreviationToRate.get(abbreviation);
    }

    public static void setRate(String abbreviation, Float rate) {
        abbreviationToRate.put(abbreviation, rate);
    }

    public static Map<String, String> getAbbreviationToFullName() {
        return abbreviationToFullName;
    }

    public boolean setCurrency(String abbreviation){
        if (abbreviationToFullName.containsKey(abbreviation)){
            this.abbreviation = abbreviation;
        }else{
            return false;
        }
        return true;
    }

    // Method that converts the amount amount to the currency targetAbbr and returns the amount in the specified currency
    // For example, if the current currency is USD and I want to learn how many euros are 100 USD that I will call this like this
    // convertTo("EUR", 100)
    public Float convertTo(String targetAbrr, Float amount){
        if (abbreviation.equals("USD")){
            return amount*abbreviationToRate.get(targetAbrr);
        }else{
            Float amountInDollars = amount/abbreviationToRate.get(abbreviation);
            return amountInDollars*abbreviationToRate.get(targetAbrr);
        }
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
