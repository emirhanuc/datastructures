package Queue;

public class StockPurchase {
    private int shares;
    private final double costPerShare;

    public StockPurchase(int shares, double costPerShare) {
        if (shares <= 0) throw new IllegalArgumentException("shares > 0");
        if (costPerShare < 0) throw new IllegalArgumentException("negatif maliyet olamaz");
        this.shares = shares;
        this.costPerShare = costPerShare;
    }
    public int getShares() { return shares; }
    public double getCostPerShare() { return costPerShare; }
    public void removeShares(int k) {
        if (k < 0 || k > shares) throw new IllegalArgumentException("Geçersiz miktar");
        shares -= k;
    }
    @Override public String toString() { return shares + " @ $" + costPerShare; }
}