import java.util.Scanner;

public class AccountType {
    //Attribute
    private String accountType;

    //Constructor
    public AccountType(String accountType) {
        this.accountType = accountType;
    }

    //Getter and Setter
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    //Method
    public void selectAccountType() {
        Scanner accountTypeInput = new Scanner(System.in);
        int checking = 1;
        int savings = 2;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("\nPlease select one of the accounts: \n" + 1 + " - Checking \n" + 2 + " - Savings");
            if (accountTypeInput.hasNextInt()) {
                int userInput = accountTypeInput.nextInt();
                if (userInput == 1) {
                    System.out.println("\nAccount selected: Checking");
                    validInput = true;
                } else if (userInput == 2) {
                    System.out.println("\nAccount selected: Savings");
                    validInput = true;
                } else {
                    System.out.println("\nNumber not valid. Please try again!");
                }
                accountTypeInput.nextLine();
            }
        }
    }
}