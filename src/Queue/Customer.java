package Queue;

public class Customer {
    private final int arrivalTime;
    private final int transactionTime;
    private final int customerNumber;

    public Customer(int arrivalTime, int transactionTime, int customerNumber) {
        this.arrivalTime = arrivalTime;
        this.transactionTime = transactionTime;
        this.customerNumber = customerNumber;
    }

    public int getArrivalTime()     { return arrivalTime; }
    public int getTransactionTime() { return transactionTime; }
    public int getCustomerNumber()  { return customerNumber; }
}
