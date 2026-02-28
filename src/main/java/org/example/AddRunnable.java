package org.example;

import java.util.List;

public class AddRunnable implements Runnable {
    private static final int NUM_ITERS = 10;
    private List<Integer> arr;

    public AddRunnable(List<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < NUM_ITERS; i++) {
                synchronized (arr) {
                    Thread.sleep(100);
                    arr.add((int) (Math.random() * (75 - 10 + 1)) + 10);
                    System.out.println(arr);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}