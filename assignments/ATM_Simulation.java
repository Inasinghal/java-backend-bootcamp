import java.util.Scanner;
public class ATM_Simulation {
    static double balance = 2000;
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int option;

        do {

            option = showMenu();

            processOption(option);

        } while(option != 4);

        sc.close();
    }

    static int showMenu() {
        System.out.println("Choose from Menu:");
        System.out.println("Menu:\n" +
                "\n" +
                "1. Check Balance\n" +
                "\n" +
                "2. Deposit\n" +
                "\n" +
                "3. Withdraw\n" +
                "\n" +
                "4. Exit");

        return sc.nextInt();
    }

    static void processOption(int option) {
        switch(option) {
            case 1:
                System.out.println(balance);
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using ATM");
                break;
            default:
                System.out.println("Invalid Option");

        }
    }

    static void deposit() {
        System.out.println("Enter Amount");
        int amount = sc.nextInt();
        while(amount < 0) {
            System.out.println("Enter Correct Amount");
            amount = sc.nextInt();
        }
        balance += amount;
        System.out.println("Your Balance" + balance);
    }

    static void withdraw() {
        System.out.println("Enter Amount to Withdraw");
        int amount = sc.nextInt();
        while (amount > balance) {
            System.out.println("You have less balance. Enter again");
            amount = sc.nextInt();
        }
        balance -= amount;
        System.out.println("Your Balance" + balance);
    }
}