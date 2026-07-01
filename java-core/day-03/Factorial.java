import java.util.Scanner;
public class Factorial {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int factorial = 1;
        while(x>1) {
            factorial *= x--;
        }

        System.out.println(factorial);
    }
}