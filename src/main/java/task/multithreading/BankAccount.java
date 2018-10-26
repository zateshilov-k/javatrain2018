package main.java.task.multithreading;

public class BankAccount {
    private static Integer accountId = 0;
    Integer moneyAmount;

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
