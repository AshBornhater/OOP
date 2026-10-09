import java.util.ArrayList;

public class BankAccount extends Bank {
    private String username;
    private String password;

    public BankAccount(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public static BankAccount findAccount(ArrayList<BankAccount> list, String username) {
        for (BankAccount acc : list) {
            if (acc.getUsername().equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }

    @Override 
    public void deposit(int depo) {
        if (depo <= 0) {
            System.out.println("Nominal deposit harus lebih dari 0!");
            return;
        }
        increaseBalance(depo);
        System.out.printf("Balance after deposit: Rp %d%n", getBalance());
    }

    @Override 
    public void withDraw(int withDraw) {    
        try {
            if (withDraw <= 0) {
                throw new Exception("Nominal withdraw harus lebih dari 0!");
            }
            if (getBalance() < withDraw) {
                throw new Exception("Saldo tidak cukup!");
            }
            decreaseBalance(withDraw);
            System.out.printf("Balance after withdraw: Rp %d%n", getBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}