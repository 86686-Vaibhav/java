import java.util.*;

class Student implements Comparable<Student> {
    private int roll;
    private String name;
    private String city;
    private double marks;

    public Student(int roll, String name, String city, double marks) {
        this.roll = roll;
        this.name = name;
        this.city = city;
        this.marks = marks;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.roll - other.roll;
    }

    @Override
    public String toString() {
        return "Roll: " + roll + ", Name: " + name + ", City: " + city + ", Marks: " + marks;
    }
}

class SortByCity implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getCity().compareTo(b.getCity());
    }
}

class SortByMarks implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getMarks(), a.getMarks());
    }
}

class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }
}

public class Assignment_7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        
        students.add(new Student(3, "Rahul", "Pune", 85.6));
        students.add(new Student(1, "Sumit", "Ujjain", 91.4));
        students.add(new Student(2, "Amit", "Indore", 78.2));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Sort by City (Asc)");
            System.out.println("2. Sort by Marks (Desc)");
            System.out.println("3. Sort by Name (Asc)");
            System.out.println("4. Sort by Roll (Asc)");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    students.sort(new SortByCity());
                    break;
                case 2:
                    students.sort(new SortByMarks());
                    break;
                case 3:
                    students.sort(new SortByName());
                    break;
                case 4:
                    Collections.sort(students);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}