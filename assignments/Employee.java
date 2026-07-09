public class Employee {
    String name;
    int id;
    static String company = "Test";

    constructor(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void display() {
        System.out.println("Name: "+name+"; Id: "+ id +"; Company"+company);
    }

    public static void main(String args[]) {
        Employee emp1 = new Employee("ABC", 1);
        Employee emp2 = new Employee("ABCD", 2); 

        emp1.display();
        emp2.display();

        Employee.company = "Test2";

        emp1.display();
        emp2.display();

    }
}