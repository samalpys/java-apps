import java.util.Scanner;

public class StudentDB {
    public static void main(String[] args) {

        System.out.print("\nEnter the number of students: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Student[] students = new Student[num];

        for (int i=0; i<num; ++i) {
            Student student = new Student();
            student.enroll();
            student.payTution();
            students[i] = student;
        }

        for (int i=0; i<students.length; ++i) {
            students[i].showInfo();
        }

    }

}