// abstract - we can't create objects of Account, but we can do it from children
public abstract class Account implements IBaseRate { 
    // list common properties for savings and checking accounts
    private String name;
    private String ssn;            // social security number
    private double balance;

    protected String accountNumber;
    protected double rate;

    private static int index = 10000;

    // Constructor to set base properties and initialise the account
    public Account(String name, String ssn, double initDeposit) {
        this.name = name;
        this.ssn = ssn;
        this.balance = initDeposit;

        // set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate(); // this is going to call the respective rates in children classes
    }

    public abstract void setRate(); // we are forcing children to implement this method

    private String setAccountNumber() {
        String lastTwoOfSSN = ssn.substring(ssn.length()-2, ssn.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interest: " + accruedInterest);
        printBalance();
    }

    // List common methods 
    // when we don't override them in children methods, they are used from parent class
    public void deposit(double amount) {
        balance += amount;
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your Balance is now: $" + balance);
    }


    public void showInfo() {
        System.out.println(
            "\n*******************************" +
            "\nNAME: " + name +
            "\nACCOUNT NUMBER: " + accountNumber +
            "\nBALANCE: " + balance +
            "\nRATE: " + rate + "%"
        );
    }
}