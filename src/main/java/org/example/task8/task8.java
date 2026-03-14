package org.example.task8;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class task8 {

    private final ReentrantLock lock = new ReentrantLock();

    public void solve(List<Integer> arr) throws InterruptedException {
        Thread threadAdd = new Thread(new AddRunnableNew(arr, lock));
        Thread threadRemove = new Thread(new DeleteRunnableNew(arr, lock));

        threadAdd.start();
        threadRemove.start();
    }
}