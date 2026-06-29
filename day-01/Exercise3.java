public class Exercise3 {
    public static void main(String[] args) {
        int age = 27;
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