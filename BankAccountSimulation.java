package Task5;


	import java.util.ArrayList;
	import java.util.Scanner;

	// Account class with deposit, withdraw, and transaction history
	class Account {
	    private String accountHolderName;
	    private String accountNumber;
	    private double balance;
	    private ArrayList<String> transactionHistory;

	    // Constructor
	    public Account(String accountHolder, String accountNumber, double initialBalance) {
	        this.accountHolderName = accountHolder;
	        this.accountNumber = accountNumber;
	        this.balance = initialBalance;
	        this.transactionHistory = new ArrayList<>();
	        transactionHistory.add("Account opened with balance: ₹" + initialBalance);
	    }

	    // Deposit method
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            transactionHistory.add("Deposited: ₹" + amount);
	            System.out.println("Amount deposited successfully.");
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    // Withdraw method
	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            transactionHistory.add("Withdraw: ₹" + amount);
	            System.out.println("Amount"+amount+
	            		" withdrawn successfully.");
	        } else {
	            System.out.println("Invalid or insufficient balance.");
	        }
	    }

	    // Show current balance
	    public void showBalance() {
	        System.out.println("Current Balance: ₹" + balance);
	    }

	    // Show transaction history
	    public void showTransactionHistory() {
	        System.out.println("Transaction History:");
	        for (String transaction : transactionHistory) {
	            System.out.println(" - " + transaction);
	        }
	    }
	}

	// Main class to simulate the bank
	public class BankAccountSimulation {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create a new account
	        System.out.print("Enter account holder name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter account number: ");
	        String accNum = scanner.nextLine();
	        System.out.print("Enter initial deposit amount: ");
	        double initialDeposit = scanner.nextDouble();

	        Account account = new Account(name, accNum, initialDeposit);

	        int choice;
	        do {
	            System.out.println("\n===== Bank Menu =====");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Transaction History");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter amount to deposit: ₹");
	                    double depositAmount = scanner.nextDouble();
	                    account.deposit(depositAmount);
	                    break;
	                case 2:
	                    System.out.print("Enter amount to withdraw: ₹");
	                    double withdrawAmount = scanner.nextDouble();
	                    account.withdraw(withdrawAmount);
	                    break;
	                case 3:
	                    account.showBalance();
	                    break;
	                case 4:
	                    account.showTransactionHistory();
	                    break;
	                case 5:
	                    System.out.println("Thank you for using the Bank Account Simulation. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }

	        } while (choice != 5);

	        scanner.close();
	    }
	}



