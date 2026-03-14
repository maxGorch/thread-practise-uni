package org.example.task4;

import java.util.List;
import java.util.Random;

public class task4 {
    private static final int NUM_ITERS = 100;
    static Random rand = new Random();

    // В основном потоке создать ArrayList. Запустить 2 потока на базе разных
    // классов: один поток 10000 раз добавляет в список случайное целое число,
    // другой 10000 раз удаляет элемент по случайному индексу. Использовать
    // внешний synchronized блок
    public static void solve(List<Integer> arr) throws InterruptedException {

        Thread threadAdd = new Thread(new AddRunnable(arr));
        Thread threadRemove = new Thread(new DeleteRunnable(arr));

        threadAdd.start();
        threadRemove.start();
    }
}
