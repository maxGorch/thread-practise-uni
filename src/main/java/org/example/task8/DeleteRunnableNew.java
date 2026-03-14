package org.example.task8;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class DeleteRunnableNew implements Runnable {
    private static final int NUM_ITERS = 100;
    private List<Integer> arr;
    private final ReentrantLock lock;

    public DeleteRunnableNew(List<Integer> arr, ReentrantLock lock) {
        this.arr = arr;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_ITERS; i++) {
            lock.lock();
            try {
                if (!arr.isEmpty()) {
                    System.out.println(arr);
                    Thread.sleep(200);
                    int index = new Random().nextInt(arr.size());
                    arr.remove(index);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}