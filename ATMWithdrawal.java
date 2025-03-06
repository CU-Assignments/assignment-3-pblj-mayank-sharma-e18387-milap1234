import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ATM {
    private static final int PIN = 1234;
    private double balance;
    
    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void authenticate(int enteredPin) throws InvalidPinException {
        if (enteredPin != PIN) {
            throw new InvalidPinException("Error: Invalid PIN.");
        }
    }
    
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Error: Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Current Balance: " + balance);
    }
    
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(3000);
        
        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            atm.authenticate(enteredPin);
            
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            atm.withdraw(amount);
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            atm.displayBalance();
        }
        
        scanner.close();
    }
}
