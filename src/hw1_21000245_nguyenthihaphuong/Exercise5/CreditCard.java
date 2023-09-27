package hw1_21000245_nguyenthihaphuong.Exercise5;

public class CreditCard {
    protected double balance; // current balance
    // Instance variables:
    private final String customer; // name of the customer
    private final String bank; // name of the bank
    private final String account; // account identifier
    private int limit; // credit limit

    // Constructors:
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0); // use a balance of zero as default
    }

    // Utility method to print a card's information
    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance); // implicit cast
        System.out.println("Limit = " + card.limit); // implicit cast
    }

    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);

        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3 * val); // Corrected multiplication symbol
            wallet[1].charge(2 * val); // Corrected multiplication symbol
            wallet[2].charge(val);
        }

        for (CreditCard card : wallet) {
            CreditCard.printSummary(card); // calling static method
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }

    // Accessor methods:
    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Charges the given price to the card, assuming sufficient credit limit.
     *
     * @param price the amount to be charged
     * @return true if charge was accepted; false if charge was denied
     */
    public boolean charge(double price) {
        if (price + balance > limit) // if charge would surpass limit
            return false; // refuse the charge
        // at this point, the charge is successful
        balance += price; // update the balance
        return true; // announce the good news
    }

    /**
     * Processes customer payment that reduces balance.
     *
     * @param amount the amount of payment made
     */
    public void makePayment(double amount) { // make a payment
        balance -= amount;
    }

    // Method that updates the credit limit
    public void updateCreditLimit(int newLimit) {
        limit = newLimit;
    }

}
