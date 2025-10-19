package Queue;

public class Main1 {
    public static void main(String[] args) {
        StockLedger myStocks = new StockLedger();
        myStocks.buy(20, 45);
        myStocks.buy(20, 75);
        myStocks.printHoldings();

        double gain = myStocks.sell(30, 65);
        System.out.println("Sermaye kazancı: $" + gain);
        myStocks.printHoldings();
    }
}
