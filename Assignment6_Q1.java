import java.util.Scanner;

class ExceptionLineTooLong extends Exception {
    public ExceptionLineTooLong() {
        super("The string is too long");
    }
}

public class Assignment6_Q1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        try {
            if (input.length() > 80) {
                throw new ExceptionLineTooLong();
            } else {
                System.out.println("String length is: " + input.length());
            }
        } catch (ExceptionLineTooLong e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
