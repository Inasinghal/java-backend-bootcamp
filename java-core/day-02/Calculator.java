import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number");
        int x = sc.nextInt();
        System.out.println("Enter 2nd number");
        int y = sc.nextInt();

        System.out.printf("Addition: %d%n", x+y);
        System.out.printf("Subtraction: %d%n", x-y);
        System.out.printf("Multiplication: %d%n", x*y);
        System.out.printf("Division: %d%n", x/y);
        System.out.printf("Modulus: %d%n", x%y);

    }
}