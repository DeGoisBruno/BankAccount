import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter your account details");
        // Create an account object
        Account account = new Account(0, "", "");

        // Display account holder information
        account.displayAccountHolderInfo();

        // Enter password
        account.enterPassword();

        //Select account type
        AccountType accountType = new AccountType("");
        accountType.selectAccountType();
        accountType.getAccountType();

        Operations operations = new Operations(0);
        Menu menu = new Menu(new Operations(0), scanner, account.getAccountName(), account.getAccountNumber());
        menu.displayMenu();
        }
    }