import java.util.Scanner;

public class Assignment2Q1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept integer input from the user
        System.out.print("Enter Number: ");
        int number = scanner.nextInt();
        
        // Print the original number
        System.out.println("Given Number: " + number);

        // Convert and print in binary, octal, and hexadecimal formats
        System.out.println("Binary equivalent: " + Integer.toBinaryString(number));
        System.out.println("Octal equivalent: " + Integer.toOctalString(number));
        System.out.println("Hexadecimal equivalent: " + Integer.toHexString(number).toUpperCase()); // To show hex in uppercase
    }
}
