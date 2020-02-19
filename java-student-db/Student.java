import java.util.Scanner;

public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String courses = "";

    private int tutionBalance = 0;
    private static int costOfCourse = 600; // static = is true for every object, but not a specific one
    private static int id = 1000;


    public Student() {

        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter the student's first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter the student's last name: ");
        this.lastName = in.nextLine();

        System.out.print("\n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nChoose the year: ");
        this.gradeYear = in.nextInt();
        System.out.print("\n");

        setStudentID();
    }

    private void setStudentID() {
        id++;
        this.studentID = this.gradeYear + "" + id;
    }

    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                this.courses = this.courses + " " + course;
                tutionBalance -= costOfCourse;
            } else {
                break;
            }
        } while ( 1!= 0);
    }

    public void viewBalance() {
        System.out.println("Your balance is: " + tutionBalance);
    }

    public void payTution() {
        System.out.print("\nEnter your payment: ");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();

        this.tutionBalance += payment;
        System.out.print("\nThank you for your payment!\n");
        viewBalance();
    }

    public void showInfo() {
        System.out.println("\nSTUDENT: " +
                        "\nNAME: " + this.firstName + " " + this.lastName +
                        "\nGRADE LEVEL: " + this.gradeYear +
                        "\nID: " + this.studentID +
                        "\nCOURSES: " + this.courses +
                        "\nBALANCE: $" + this.tutionBalance + "\n"
        ); 
    }


}