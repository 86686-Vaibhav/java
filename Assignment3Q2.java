class Employee{
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;

        if (monthlySalary < 0) {
            this.monthlySalary = 0;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public 
 String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary)
 {
        if (monthlySalary >= 0) {
            this.monthlySalary = monthlySalary;
        }
    }

    public double getYearlySalary() {
        return monthlySalary * 12;

    }
}

public class EmployeeTest{
    public static void main(String[] args) {
        Employee employee1 = new Employee("Alice", "Smith", 5000);
        Employee employee2 = new Employee("Bob", "Johnson", 6000);

        System.out.println("Employee 1:");
        System.out.println("Yearly Salary: $" + employee1.getYearlySalary());

        System.out.println("\nEmployee 2:");
        System.out.println("Yearly Salary: $" + employee2.getYearlySalary());

        employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.1);
        employee2.setMonthlySalary(employee2.getMonthlySalary()* 1.1);

        System.out.println("\nAfter 10% raise:");

        System.out.println("Employee 1:");
        System.out.println("Yearly Salary: $" + employee1.getYearlySalary());

        System.out.println("\nEmployee 2:");
        System.out.println("Yearly Salary: $" + employee2.getYearlySalary());
    }
}