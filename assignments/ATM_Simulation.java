import java.util.Scanner;
public class ATM_Simulation {
    public static void main(String args[]) {
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
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        double balance = 2000;

        switch(option) {
            case 1: {
                System.out.println(balance);
                break;
            }
            case 2: {
                System.out.println("Enter Amount");
                int amount = sc.nextInt();
                while(amount < 0) {
                    System.out.println("Enter Correct Amount");
                    amount = sc.nextInt();
                }
                balance += amount;
                System.out.println("Your Balance" + balance);
                break;
            }
            case 3: {
                System.out.println("Enter Amount to Withdraw");
                int amount = sc.nextInt();
                while (amount > balance) {
                    System.out.println("You have less balance. Enter again");
                    amount = sc.nextInt();
                }
                balance -= amount;
                System.out.println("Your Balance" + balance);
                break;
            }
            case 4:
                System.out.println("Thank you for using ATM");
                break;
            default:
                System.out.println("Invalid Option");

        }
        sc.close();
    }
}