public class Exercise2 {
    public static void main(String[] args) {
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
    }
}