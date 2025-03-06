import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        try {
            double number = scanner.nextDouble();
            if (number < 0) {
                System.out.println("Error: Cannot calculate the square root of a negative number.");
            } else {
                System.out.println("Square Root: " + Math.sqrt(number));
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        }
        
        scanner.close();
    }
}
