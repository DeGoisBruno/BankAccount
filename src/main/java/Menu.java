import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Operations operations;
    private Scanner scanner;
    private String accountName;
    private int accountNumber;

    // Constructor
    public Menu(Operations operations, Scanner scanner, String accountName, int accountNumber) {
        this.operations = operations;
        this.scanner = scanner;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public void displayMenu() {
        boolean exit = false;

        // Display menu options:
        while (!exit) {
            System.out.println("\nMENU: ");
            System.out.println("1 - View Balance");
            System.out.println("2 - Make a Deposit");
            System.out.println("3 - Withdraw Funds");
            System.out.println("4 - Display Account Details");
            System.out.println("5 - Exit");
            System.out.println("Select an option: ");

            int userInput = -1;

            try {
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clears the invalid input
                continue; // Go back to the menu
            }

            switch (userInput) {
                case 1:
                    System.out.println("\nCurrent balance: $" + operations.getFormattedBalance());
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdraw();
                    break;
                case 4:
                    displayAccountInfo();
                    break;
                case 5:
                    exit = true;
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void handleDeposit() {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            System.out.println("\nDeposit Menu:");
            System.out.println("1 - Enter deposit amount");
            System.out.println("2 - Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = getInput();

            switch (choice) {
                case 1:
                    operations.deposit(scanner);
                    returnToMainMenu = true;
                    break;
                case 2:
                    returnToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleWithdraw() {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            System.out.println("\nWithdraw Menu:");
            System.out.println("1 - Enter withdraw amount");
            System.out.println("2 - Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = getInput();

            switch (choice) {
                case 1:
                    operations.withdraw(scanner);
                    returnToMainMenu = true;
                    break;
                case 2:
                    returnToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private int getInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    public void displayAccountInfo() {
        System.out.println("\nACCOUNT INFORMATION HOLDER");
        System.out.println("Account name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
    }
}