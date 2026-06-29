public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Backend Engineer!");
        String name = "Ina";
        int age = 27;
        double experience = 4.5;
        String currentRole = "Frontend Developer";
        String targetRole = "Full Stack Developer";
        boolean readyForChallenge = true;

        System.out.println("=============================");
        System.out.println("Employee Information");
        System.out.println("=============================");
        System.out.printf("Name:                     %s%n",name);
        System.out.printf("Age:                      %d%n",age);
        System.out.printf("Experience:               %.1f%n",experience);
        System.out.printf("Current Role:             %s%n",currentRole);
        System.out.printf("Target Role:              %s%n",targetRole);
        System.out.printf("Ready For Challenge:      %s%n",readyForChallenge ? "YES" : "NO");

        double my_age = age;
        double salary = 1.7976931348623157E308;
        int my_salary = (int)salary;
        char gender = 'F';
        int my_gender = gender;

        System.out.println("=============================");
        System.out.printf("My Age:                      %f%n",my_age);
        System.out.printf("Salary:                      %d%n",my_salary);
        System.out.printf("Gender:                      %d%n",my_gender);
    }
}