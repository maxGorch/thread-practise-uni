package org.example;

import com.sun.source.tree.TryTree;

import java.util.ArrayList;
import java.util.concurrent.Executors;

public class Main {

    private static final int NUM_THREADS =2;
    private static final int NUM_ITERS =10;


    public static void main(String[] args) throws InterruptedException {
        TaskPrintPropertyAndJoinSecondThread th0 = new TaskPrintPropertyAndJoinSecondThread();
        Thread threadPrintProperty = new Thread(th0);

        /// Чтобы все вставки удалялись и выполнялись параллельно
        threadOne thread1 = new threadOne();
        threadTwo thread2 = new threadTwo();
        threadThree thread3 = new threadThree();

        Thread th1 = new Thread(thread1);
        Thread th2 = new Thread(thread2);
        Thread th3 = new Thread(thread3);

        threadPrintProperty.start();
        th1.start();
        th2.start();
        th3.start();

        threadPrintProperty.join();
        th1.join();
        th2.join();
        th3.join();

        //В основном потоке создать ArrayList. Запустить 2 потока на базе разных
        //классов: один поток 10000 раз добавляет в список случайное целое число,
        //другой 10000 раз удаляет элемент по случайному индексу. Использовать
        //внешний synchronized блок
        ArrayList<Integer> arr = new ArrayList();
        var data = new DataHolder();
        try(final var executor = Executors.newFixedThreadPool(NUM_THREADS)){

                executor.submit(new Runnable() {
                    @Override
                    public void run()
                    {
                        for (int j=0;j<NUM_ITERS;j++)
                        {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            data.add();
                            //System.out.println("Получаем элемент, который мы будем ДОБАВЛЯТЬ: " + data.getDataElement(j));

                        }
                    }
            });

            executor.submit(new Runnable() {
                @Override
                public void run()
                {
                    for (int j=0;j<NUM_ITERS;j++)
                    {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //System.out.println("Получаем элемент, который мы будем УДАЛЯТЬ: " + data.getDataElement(j));
                        //data.delete();
                }
                }
            });

        }
        System.out.println("Ожидаем: "+(NUM_ITERS) +"\n"
                + ", актуально: " + data.getDataSize());

    }

}
