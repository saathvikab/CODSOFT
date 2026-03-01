import java.util.Scanner;

class Account {

    double bal;

    Account(double start) {
        bal = start;
    }

    void deposit(double amt) {
        if (amt > 0) {
            bal = bal + amt;
            System.out.println("Money deposited.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Invalid amount.");
        } 
        else if (amt > bal) {
            System.out.println("Not enough balance.");
        } 
        else {
            bal = bal - amt;
            System.out.println("Please collect cash.");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + bal);
    }
}

class ATM {

    Account acc;

    ATM(Account a) {
        acc = a;
    }

    void start() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- ATM MENU ----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice == 1) {
                acc.showBalance();
            }
            else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double d = sc.nextDouble();
                acc.deposit(d);
            }
            else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double w = sc.nextDouble();
                acc.withdraw(w);
            }
            else if (choice == 4) {
                System.out.println("Thank you for using ATM.");
            }
            else {
                System.out.println("Wrong option.");
            }

        } while (choice != 4);

        sc.close();
    }
}

public class ATMApp {

    public static void main(String[] args) {

        Account myAcc = new Account(1000); 
        ATM machine = new ATM(myAcc);

        machine.start();
    }
}