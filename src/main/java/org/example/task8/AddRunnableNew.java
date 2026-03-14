package org.example.task8;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class AddRunnableNew implements Runnable {
    private List<Integer> arr;
    private static final int NUM_ITERS = 100;
    private final ReentrantLock lock;

    public AddRunnableNew(List<Integer> arr, ReentrantLock lock) {
        this.arr = arr;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_ITERS; i++) {
            lock.lock();
            try {
                arr.add((int) (Math.random() * (75 - 10 + 1)) + 10);
                System.out.println(arr);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}