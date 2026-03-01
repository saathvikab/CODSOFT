import java.util.Scanner;
import java.util.Random;

public class Game {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int wins = 0;
        String ch;

        do {

            int num = r.nextInt(100) + 1;
            int count = 6;
            boolean ok = false;

            System.out.println("\nGuess number between 1 and 100");
            System.out.println("You have 6 chances");

            while (count > 0) {

                System.out.print("Enter guess: ");
                int g = sc.nextInt();

                if (g < 1 || g > 100) {
                    System.out.println("Enter number in range");
                    continue;
                }

                if (g == num) {
                    System.out.println("Correct");
                    wins++;
                    ok = true;
                    break;
                } 
                else if (g > num) {
                    System.out.println("Too high");
                } 
                else {
                    System.out.println("Too low");
                }

                count--;
                System.out.println("Chances left: " + count);
            }

            if (!ok) {
                System.out.println("Number was: " + num);
            }

            System.out.println("Wins: " + wins);

            System.out.print("Play again? (yes/no): ");
            ch = sc.next();

        } while (ch.equalsIgnoreCase("yes"));

        System.out.println("Game Over");
        sc.close();
    }
}