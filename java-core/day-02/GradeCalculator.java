import java.util.Scanner;
public class GradeCalculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your marks");

        int total = 0;
        int totalSubject = 0;
        while(sc.hasNext()) {
            if(sc.hasNextInt()) {
                int num = sc.nextInt();
                total += num;
                totalSubject++;
            } else {
                String input = sc.next();
                if (input.equalsIgnoreCase("done") || input == "" +
                        "") {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or type 'done' to finish.");
                }
            }
        }

        double percentage = total/totalSubject * 100;
        if(percentage >= 80) {
            System.out.println("A");
        } else if(percentage < 80 && percentage >= 60) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
    }
}