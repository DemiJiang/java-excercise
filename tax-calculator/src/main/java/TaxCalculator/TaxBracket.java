package TaxCalculator;

public class TaxBracket {
    private int lowBand;
    private int highBand;
    private int amount;
    private double rate;

    public int getLowBand() {
        return lowBand;
    }

    public int getHighBand() {
        return highBand;
    }

    public int getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }

    public TaxBracket(int lowBand, int highBand, int amount, double rate) {
        this.lowBand = lowBand;
        this.highBand = highBand;
        this.amount = amount;
        this.rate = rate;
    }



}
