package test.java.task.multithreading;

import main.java.task.multithreading.ATM.CashDispenser;
import main.java.task.multithreading.ATM.Deposit;
import main.java.task.multithreading.ATM.DepositATM;
import main.java.task.multithreading.ATM.Dispenser;
import main.java.task.multithreading.BankAccount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CashDispenserTest {
    final int AMOUNT_MONEY = 1000;
    final int NUMBER_THREADS = 50;
    final int AMOUNT_MONEY_PER_THREAD = 20;
    final int DELAY_TIME = 100;

    @Test
    public void testWithdraw() {
        List<BankAccount> listAccounts = new ArrayList<>();
        listAccounts.add(new BankAccount(AMOUNT_MONEY));
        Dispenser cashDispenser = new CashDispenser(listAccounts);
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Callable<Object>> listTasks = Stream.generate(() -> (Callable<Object>) () -> {
            try {
                Thread.sleep(DELAY_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cashDispenser.withdraw(1, AMOUNT_MONEY_PER_THREAD);
            return null;
        }).limit(NUMBER_THREADS).collect(Collectors.toList());
        try {
            executorService.invokeAll(listTasks);
            executorService.shutdown();
            assertEquals(0, (int) listAccounts.get(0).getMoneyAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeposit() {
        List<BankAccount> listAccounts = new ArrayList<>();
        listAccounts.add(new BankAccount(0));
        Deposit depositATM = new DepositATM(listAccounts);
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Callable<Object>> listTasks = Stream.generate(() -> (Callable<Object>) () -> {
            try {
                Thread.sleep(DELAY_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            depositATM.deposit(1, AMOUNT_MONEY_PER_THREAD);
            return null;
        }).limit(NUMBER_THREADS).collect(Collectors.toList());
        try {
            executorService.invokeAll(listTasks);
            executorService.shutdown();
            assertEquals((int) listAccounts.get(0).getMoneyAmount(), AMOUNT_MONEY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
