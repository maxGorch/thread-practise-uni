package org.example;

import java.util.List;
import java.util.Random;

public class DeleteRunnable implements Runnable {
    private static final int NUM_ITERS = 10;
    private List<Integer> arr;

    public DeleteRunnable(List<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < NUM_ITERS; i++) {
                synchronized (arr) {
                    if (!arr.isEmpty()) {
                        Thread.sleep(100);
                        System.out.println(arr);
                        int index = new Random().nextInt(arr.size());
                        arr.remove(index);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}