import java.util.Scanner;

public class Email {
    
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String department;

    private String alternativeEmail;
    
    private int mailboxCapacity = 50;
    private int defaultPasswordLength = 8;
    private String companySuffix = "company.com";

    // constructor to receive the first name and the last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = setRandomPassword(defaultPasswordLength);
        this.email = this.firstName.toLowerCase() + "." 
                    +this.lastName.toLowerCase() + "@"
                    +this.department.toLowerCase() + "."
                    +this.companySuffix;
    }

    // ask for the Department
    private String setDepartment() {
        System.out.println(
            "New worker: " + this.firstName + ",\n" +
            "Enter the Department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none" 
        );
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 1) return "sales";
        else if (choice == 2) return "dev";
        else if (choice == 3) return "accounting";
        return "";
    }

    // set the random password
    private String setRandomPassword(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@£$%";
        char[] password = new char[length];
        for (int i=0; i<length; ++i) {
            int rand_index = (int) (Math.random() * alphabet.length());
            password[i] = alphabet.charAt(rand_index);
        }
        return new String(password);
    }

    public void showInfo() {
        System.out.println( 
            "\nDISPLAY NAME: " + firstName + " " + lastName+
            "\nCOMPANY EMAIL: " + email +
            "\nMAILBOX CAPASITY: " + mailboxCapacity + "mb" + 
            "\n"
        );
    }

    // DATA BINDING
    public void setMailboxCapacity(int capacity) { this.mailboxCapacity = capacity; }
    public void setAlternativeEmail(String email) { this.alternativeEmail = email; }
    public void changePassword(String password) { this.password = password; }

    // DATA HIDING
    public int getMailboxCapacity() { return this.mailboxCapacity; }
    public String getEmail() { return this.email; }
    public String getAlternativeEmail() { return this.alternativeEmail; }


}
