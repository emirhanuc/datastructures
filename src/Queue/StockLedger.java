package Queue;

public class StockLedger {
    private final QueueInterface<StockPurchase> lots = new LinkedQueue<>();

    public void buy(int shares, double price) {
        lots.enqueue(new StockPurchase(shares, price));  // enqueue
    }

    public double sell(int sharesToSell, double sellPrice) {
        if (sharesToSell <= 0) throw new IllegalArgumentException("sharesToSell > 0 olmalı");
        if (getTotalShares() < sharesToSell)
            throw new IllegalStateException("Yetersiz hisse. Elde: " + getTotalShares());

        double gain = 0.0;
        int remaining = sharesToSell;

        while (remaining > 0) {
            StockPurchase lot = lots.getFront(); // front'u silmeden gör
            int available = lot.getShares();
            int take = Math.min(available, remaining);

            gain += (sellPrice - lot.getCostPerShare()) * take;

            if (take == available) {
                lots.dequeue(); // lot bitti → dequeue
            } else {
                lot.removeShares(take); // kısmi
            }
            remaining -= take;
        }
        return gain;
    }

    public int getTotalShares() {
        int total = 0;
        // LinkedQueue için basit bir dolaşma API’n yoksa, geçici bir taşıma yapabilirsin:
        // Pratikte, LinkedQueue'na bir iterator eklemeni öneririm. Şimdilik hızlı yol:
        QueueInterface<StockPurchase> tmp = new LinkedQueue<>();
        while (!lots.isEmpty()) {
            StockPurchase x = lots.dequeue();
            total += x.getShares();
            tmp.enqueue(x);
        }
        while (!tmp.isEmpty()) lots.enqueue(tmp.dequeue());
        return total;
    }

    public void printHoldings() {
        System.out.println("== FIFO Lotlar ==");
        if (lots.isEmpty()) { System.out.println("(boş)"); return; }
        QueueInterface<StockPurchase> tmp = new LinkedQueue<>();
        while (!lots.isEmpty()) {
            StockPurchase x = lots.dequeue();
            System.out.println("  " + x);
            tmp.enqueue(x);
        }
        while (!tmp.isEmpty()) lots.enqueue(tmp.dequeue());
        System.out.println("Toplam: " + getTotalShares());
    }
}