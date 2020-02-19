public class SavingsAccount extends Account {
    // List properties specific to the savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize Savings account props
    public SavingsAccount(String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox() {
        this.safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        this.safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    // List any methods specific to the savings account
    public void showInfo() {
        System.out.print("\nACCOUNT TYPE: saving account:");
        super.showInfo();
        System.out.println(
            "\n Your saving account features: " +
            "\n Safety Deposit Box ID: " + this.safetyDepositBoxID +
            "\n Safety Deposit Box key: " + this.safetyDepositBoxKey
        );
    }
}