import java.util.Scanner;

public class MarksProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int m = sc.nextInt();
            total = total + m;
        }

        double avg = (double) total / n;

        String grade;

        if (avg >= 90) {
            grade = "A+";
        }
        else if (avg >= 75) {
            grade = "A";
        }
        else if (avg >= 60) {
            grade = "B";
        }
        else if (avg >= 50) {
            grade = "C";
        }
        else if (avg >= 40) {
            grade = "D";
        }
        else {
            grade = "Fail";
        }

        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average Percentage: " + avg);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}