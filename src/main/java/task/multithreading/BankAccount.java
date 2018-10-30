package main.java.task.multithreading;

/**
 * Class that wraps bank account information.
 */
public class BankAccount {
    private static Integer accountId = 0;
    Integer moneyAmount;

    /**
     * Constructor that creates new BankAccounts with chosen moneyAmount on account
     * and new account Id.
     * @param moneyAmount chosen amount of money.
     */
    public BankAccount(Integer moneyAmount) {
        this.accountId = ++accountId;
        this.moneyAmount = moneyAmount > 0 ? moneyAmount : 0;
    }

    public static Integer getAccountId() {
        return accountId;
    }

    public Integer getMoneyAmount() {
        return moneyAmount;
    }

    /**
     * Withdraw money from account.
     * @param moneyAmount chosen money amount
     * @return            true, if operation was a success, otherwise false
     */
    public boolean withdraw(int moneyAmount) {
        if (this.moneyAmount < moneyAmount) {
            return false;
        } else {
            this.moneyAmount -= moneyAmount;
            return true;
        }
    }

    public void deposit(int moneyAmount) {
        this.moneyAmount += moneyAmount;
    }
}
