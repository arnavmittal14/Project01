package lab01;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Process CLI arguments
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide, factorial):");
            String operation = scanner.next();
            // scanner is used to take user input for what operation they need performed.
            switch (operation.toLowerCase()) {
                case "add":
                    System.out.println("Enter the first operand:");
                    double num1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num2 = scanner.nextDouble();
                    System.out.println("Result: " + add(num1, num2));
                    break;

                case "subtract":
                    System.out.println("Enter the first operand:");
                    double subNum1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double subNum2 = scanner.nextDouble();
                    System.out.println("Result: " + subtract(subNum1, subNum2));
                    break;

                case "multiply":
                    System.out.println("Enter the first operand:");
                    double mulNum1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double mulNum2 = scanner.nextDouble();
                    System.out.println("Result: " + multiply(mulNum1, mulNum2));
                    break;

                case "divide":
                    System.out.println("Enter the first operand:");
                    double divNum1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double divNum2 = scanner.nextDouble();
                    if (divNum2 != 0) {
                        System.out.println("Result: " + divide(divNum1, divNum2));
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;

                case "factorial":
                    System.out.println("Enter a number:");
                    double number = scanner.nextDouble();
                    System.out.println("Result: " + factorial(number));
                    break;

                default:
                    System.out.println("Invalid operation");
                    break;
                    // error message
            }
        }
    }

    public static double add(double a, double b) {
        return a + b;
        // performs simple add
    }

    public static double subtract(double a, double b) {
        return a - b;
        // performs simple subtract
    }

    public static double multiply(double a, double b) {
        return a * b;
        // performs simple multiply
    }

    public static double divide(double a, double b) {
        return a / b;
        // performs simple divide
    }

    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
            // performs factorial calculation
        }
    }
}
