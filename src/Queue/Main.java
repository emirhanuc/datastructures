package Queue;

public class Main {
    public static void main(String[] args) {
        WaitLine wl = new WaitLine();
        wl.simulate(
                60,   // duration: 60 dakika
                0.5,  // arrivalProbability: her dakikada %50 ihtimalle müşteri
                5     // maxTransactionTime: 1..5 dakika
        );
        wl.displayResults();
    }
}