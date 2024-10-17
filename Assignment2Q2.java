import java.util.Scanner;

public class Assignment2Q2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] prices = {50, 30, 40, 60, 25, 20, 100, 80, 45, 0}; // Last item is "Generate Bill"

        int totalBill = 0;
        int choice, quantity;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Dosa - Rs 50");
            System.out.println("2. Samosa - Rs 30");
            System.out.println("3. Idli - Rs 40");
            System.out.println("4. Vada - Rs 60");
            System.out.println("5. Tea - Rs 25");
            System.out.println("6. Coffee - Rs 20");
            System.out.println("7. Pizza - Rs 100");
            System.out.println("8. Burger - Rs 80");
            System.out.println("9. Sandwich - Rs 45");
            System.out.println("10. Generate Bill");

            System.out.print("Enter your choice (1-10): ");
            choice = scanner.nextInt();

            if (choice == 10) {
                System.out.println("Generating bill...");
                break;
            }
            
            if (choice < 1 || choice > 10) {
                System.out.println("Invalid choice. Please select a valid item.");
                continue;
            }

            
            System.out.print("Enter quantity: ");
            quantity = scanner.nextInt();

            totalBill += prices[choice - 1] * quantity;

            System.out.println("Item added to the bill.\n");
        }

        System.out.println("Total Bill: Rs " + totalBill);
    }
}
