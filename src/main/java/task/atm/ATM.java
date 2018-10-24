package main.java.task.atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ATM {
    List<BankAccount> bankAccounts = new ArrayList<>();

    public ATM(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public boolean withdraw(int accountId, int moneyAmount) throws IllegalArgumentException {
        Optional<BankAccount> optionalBankAccount = bankAccounts.stream()
                .filter(e -> e.getAccountId() == accountId)
                .findFirst();
        if (!optionalBankAccount.isPresent()) {
            throw new IllegalArgumentException("Wrong accountId");
        } else {
            synchronized (optionalBankAccount.get()) {
                return optionalBankAccount.get().withdraw(moneyAmount);
            }
        }
    }

    public void deposit(int accountId, int moneyAmount) {

    }

}
