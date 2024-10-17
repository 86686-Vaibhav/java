import java.util.Scanner;
public class Assignment1{
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Enter the first number: ");
	        if (!scanner.hasNextDouble()) {
	            System.out.println("Error: The first input is not a valid double.");
	            return;
	        }
	        double num1 = scanner.nextDouble();
	        
	        System.out.println("Enter the second number: ");
	        if (!scanner.hasNextDouble()) {
	            System.out.println("Error: The second input is not a valid double.");
	            return;
	        }
	        double num2 = scanner.nextDouble();
	        
	        double average = (num1 + num2) / 2;
	        System.out.println("The average of the two numbers is: " + average);
	    }
	}

