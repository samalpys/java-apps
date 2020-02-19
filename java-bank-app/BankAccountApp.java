import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        // Read a CSV File then create new accounts based on that data

        List<Account> accounts = new LinkedList<Account>();

        String file = "./NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);

        for (String[] holder : newAccountHolders) {
            String name = holder[0];
            String ssn = holder[1];
            String accountType = holder[2];
            double initDeposit = Double.parseDouble(holder[3]);

            if (accountType.equals("Savings")) {
                System.out.println("OPEN A SAVINGS ACCOUNT");
                accounts.add(new SavingsAccount(name, ssn, initDeposit));
            } else if (accountType.equals("Checking")) {
                System.out.println("OPEN A CHECKING ACCOUNT");
                accounts.add(new CheckingAccount(name, ssn, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc : accounts) {
            acc.showInfo();
        }
    }
}
