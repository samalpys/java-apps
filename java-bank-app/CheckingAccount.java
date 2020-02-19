public class CheckingAccount extends Account {
    // List properties specific for checking account
    private int debitCardNumber;
    private int debitCatdPIN;

    // Constructor to initialize Checking account props
    public CheckingAccount(String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard() {
        this.debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        this.debitCatdPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    // List any methods specific to the checking account
    public void showInfo() {
        System.out.print("\nACCOUNT TYPE: checking account:");
        super.showInfo();
        System.out.println(
            "\n Your checking account features: " +
            "\n Debit Card Number: " + this.debitCardNumber +
            "\n Debit Card PIN: " + this.debitCatdPIN
        );
    }
}