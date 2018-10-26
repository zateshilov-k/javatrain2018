package main.java.task.multithreading.ATM;

import main.java.task.multithreading.BankAccount;

import java.util.List;

public class CashDispenser extends AbstractATM implements Dispenser {
    public CashDispenser(List<BankAccount> bankAccounts) {
        this.bankAccounts.addAll(bankAccounts);
    }

    @Override
    public boolean withdraw(int accountId, int moneyAmount) throws IllegalArgumentException {
        BankAccount bankAccount = findAccount(accountId);
        synchronized (bankAccount) {
            return bankAccount.withdraw(moneyAmount);
        }
    }
}
