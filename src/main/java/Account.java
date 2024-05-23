import java.util.InputMismatchException;
import java.util.Scanner;

//Attributes
public class Account {
    private int accountNumber;
    private String accountName;
    private String password;

    //Constructors
    public Account(int accountNumber, String accountName, String password) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.password = password;
    }

    //Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Method
    //Account owner details
    public void displayAccountHolderInfo() {
        Scanner accountDetailsInput = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        this.accountName = accountDetailsInput.nextLine();

        boolean validInput = false;
        while (!validInput) {
            System.out.println("\nPlease enter your 7 digits account number: ");
            try {
                int input = accountDetailsInput.nextInt();
                if (String.valueOf(input).length() == 7) {
                    this.accountNumber = input;
                    validInput = true;
                } else {
                    System.out.println("Account number must be 7 digits. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid account number.");
                accountDetailsInput.next(); // Clear the invalid input
            }
        }

        System.out.println("\nName: " + accountName);
        System.out.println("Account Number: " + accountNumber);
    }

    //Set password
    public void enterPassword() {
        Scanner userInput = new Scanner(System.in);
            final int minPasswordLength = 6;
            final int maxPasswordLength = 10;
            int attempts = 0;

        System.out.println("\nLet's set up a password...");

            while (attempts < 3) {
                System.out.println("\nPlease enter your password between " + minPasswordLength + " and " + maxPasswordLength + " characters:");

                String passwordInputOne = userInput.nextLine();
                int passwordLength = passwordInputOne.length();

                if (passwordLength >= minPasswordLength && passwordLength <= maxPasswordLength) {
                    System.out.println("\nPlease re-enter your password:");

                    String passwordInputTwo = userInput.nextLine();

                    if (passwordInputOne.equals(passwordInputTwo)) {
                        System.out.println("\nPassword match. Access granted.");
                        return;
                    } else {
                        System.out.println("\nPassword does not match. Please try again.");
                        attempts++;
                    }
                } else {
                    System.out.println("\nPassword should be between " + minPasswordLength + " and " + maxPasswordLength + " characters.");
                }
            }
            System.out.println("\nYou have exceeded the maximum number of attempts. Try again later.");
            System.out.println("Exiting...");
        System.exit(0);
        }
    }
