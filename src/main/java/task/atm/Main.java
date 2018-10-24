package main.java.task.atm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> list = new ArrayList<>();
        list.add(new BankAccount(100));
        ATM atm = new ATM(list);
        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atm.withdraw(1,10);
                /*System.out.println(Thread.currentThread().getName() +
                        "Result: " + );*/

            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0).moneyAmount);

    }
}
