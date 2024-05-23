import java.util.Scanner;
import java.text.DecimalFormat;


public class Operations {
    //Attributes
    private double balance;
    private static final double feeRate = 0.005; // 0.5% fee rate
    private static final double overdraftLimit = -100.0;

    //Constructors
    public Operations(double balance) {
        this.balance = balance;
    }

    //Getters and Setters
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to get formatted balance
    public String getFormattedBalance() {
        return formatAmount(balance);
    }

    //Deposit method
    public void deposit(Scanner scanner) {
        System.out.println("\nPlease enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        double depositFee = depositAmount * feeRate;

        if (depositAmount > 0) {
            balance += depositAmount - depositFee;
            System.out.println("\nAmount deposited: $" + formatAmount(depositAmount) + ". Deposit Fee: $" + formatAmount(depositFee) + ". Your new balance is: $" + formatAmount(balance));
        } else {
            System.out.println("\nInvalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(Scanner scanner) {
        System.out.println("\nEnter withdraw amount: ");
        double withdrawAmount = scanner.nextDouble();
        double withdrawFee = withdrawAmount * feeRate;
        double totalDeductible = withdrawAmount + withdrawFee;

        if (balance - totalDeductible >= overdraftLimit) {
            balance -= totalDeductible;
            System.out.println("\nAmount withdrawn: $" + formatAmount(withdrawAmount) + ". Withdraw fee: $" + formatAmount(withdrawFee) + ". Remaining balance: $" + formatAmount(balance));
            } else {
                System.out.println("\nYou have insufficient funds.");
            }
    }

    // Helper method to format amounts
    private String formatAmount(double amount) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(amount);
    }
}