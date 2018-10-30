package main.java.task.multithreading.ATM;

/**
 * Interface for ATMs, which can perform deposit operation.
 */
public interface Deposit {
    void deposit(int accountId, int moneyAmount);
}
