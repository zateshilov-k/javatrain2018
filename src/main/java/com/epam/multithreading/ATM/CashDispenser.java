package com.epam.multithreading.ATM;

import com.epam.multithreading.BankAccount;

import java.util.List;

/**
 * ATM class that implements Dispenser interface.
 */
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
