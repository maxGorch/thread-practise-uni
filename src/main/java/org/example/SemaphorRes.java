package org.example;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class SemaphorRes implements Runnable {
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public SemaphorRes(Semaphore semaphore1, Semaphore semaphore2) {
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
    }

    @Override
    public void run() {
        try {
            Thread t1 = new Thread(
                    () -> {
                        while (true) {
                            try {
                                synchronized (Thread.currentThread()) {
                                    Thread.currentThread().wait();
                                }

                                System.out.println("ping");
                                Thread.currentThread().notify();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    });
            Thread t2 = new Thread(
                    () -> {
                        while (true) {
                            try {
                                synchronized (Thread.currentThread()) {
                                    Thread.currentThread().wait();
                                }
                                System.out.println("pong");
                                synchronized (Thread.currentThread()) {
                                    Thread.currentThread().notify();
                                }

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    });
            t1.start();
            t2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
