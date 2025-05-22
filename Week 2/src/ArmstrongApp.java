import java.util.Scanner;

public class ArmstrongApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Armstrong Number Checker ===");

        try {
            System.out.print("Enter a number: ");
            int number = Integer.parseInt(scanner.nextLine());
            boolean result = ArmstrongChecker.isArmstrong(number);

            System.out.println(number + (result ? " is" : " is not") + " an Armstrong number.");

            try {
                DatabaseManager.initializeDatabase();
                DatabaseManager.saveResult(number, result);
            } catch (Exception e) {
                System.out.println("Database error: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
