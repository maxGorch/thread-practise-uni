package org.example;

import java.util.List;
import java.util.Random;

public class task6 {
    private static final int NUM_ITERS = 10;
    static Random rand = new Random();

    public static void solve(List<Integer> syncList) throws InterruptedException {

        Runnable addRunnable = () -> {
            try {
                for (int i = 0; i < NUM_ITERS; i++) {
                    synchronized (syncList) {
                        syncList.add((int) (Math.random() * (75 - 10 + 1)) + 10);
                        System.out.println(syncList);
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        };

        Runnable deleteRunnable = () -> {
            try {
                for (int i = 0; i < NUM_ITERS; i++) {
                    synchronized (syncList) {
                        if (!syncList.isEmpty()) {
                            System.out.println(syncList);
                            int index = new Random().nextInt(syncList.size());
                            syncList.remove(index);
                        }
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        };

        Thread threadAdd = new Thread(addRunnable);
        Thread threadRemove = new Thread(deleteRunnable);

        threadAdd.start();
        threadRemove.start();
    }
}
