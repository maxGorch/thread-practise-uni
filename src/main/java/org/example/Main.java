package org.example;

import com.sun.source.tree.TryTree;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskPrintPropertyAndJoinSecondThread th0 = new TaskPrintPropertyAndJoinSecondThread();

        Runnable task = () -> {
            try {
                System.out.println("SubThread start!" + Thread.currentThread().getName());
                Thread.sleep(300);
                System.out.println("SubThread finish!"+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("interrupted sbuThread" );
            }
        };

        /// Чтобы все вставки и удалялись выполнялись параллельно

        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);
        Thread th3 = new Thread(task);

        th0.start();
        th1.start();
        th2.start();
        th3.start();

        th0.join();
        th1.join();
        th2.join();
        th3.join();


    }

}
