abstract class Bank {
    private int balance;

    public Bank() {
        this.balance = 100000;
    }

    public int getBalance() {
        return balance;
    }

    protected void increaseBalance(int amount) {
        balance += amount;
    }

    protected void decreaseBalance(int amount) {
        balance -= amount;
    }

    public abstract void deposit(int depo);
    public abstract void withDraw(int withDraw);
}