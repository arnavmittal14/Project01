package lab01;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permute) or 'exit' to quit:");
            String operation = scanner.next();
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }
            
            // For operations requiring two inputs
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") &&
                !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") &&
                !operation.equalsIgnoreCase("factorial") && !operation.equalsIgnoreCase("permute")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case "divide":
                        if (num2 != 0) {
                            System.out.println("Result: " + divide(num1, num2));
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                        }
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else if (operation.equalsIgnoreCase("permute")) {
                System.out.print("Enter the total number of elements (n): ");
                int n = scanner.nextInt();
                System.out.print("Enter the number of items to be selected (r): ");
                int r = scanner.nextInt();
                System.out.println("Result: " + permutationRecursive(n, r));
            } else {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(num));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(num));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(num));
                        break;
                    case "factorial":
                        System.out.println("Result: " + factorial((int) num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }
        scanner.close();
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    public static double log(double number) {
        return Math.log(number);
    }

    public static double log10(double number) {
        return Math.log10(number);
    }

    public static double sin(double num) {
        return Math.sin(num);
    }

    public static double cos(double num) {
        return Math.cos(num);
    }

    public static double tan(double num) {
        return Math.tan(num);
    }

    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num < 1) {
        	//Here the num being <= 1 prevented 1 from being included in the progress so changing it to <1 fixes it.
            System.out.println("\rCalculating factorial: 100%");
            return 1;
        }
        int progress = (int) (((originalNum - num) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }
    public static long permutationRecursive(int n, int r) {
        if (n < 0 || r < 0) {
            System.out.println("Error: The number of elements or selected items is out of valid range.");
            return -1;
        }
        if (r > n) {
            System.out.println("Error: The number of selected items cannot be greater than the total number of elements.");
            return -1;
        }
        return permutationHelper(n, r);
    }

    private static long permutationHelper(int n, int r) {
        if (r == 0) {
            return 1;
        }
        return n * permutationHelper(n - 1, r - 1);
    }
}

