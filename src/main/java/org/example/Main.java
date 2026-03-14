package org.example;

import java.util.concurrent.ExecutionException;

import org.example.task7.MonitorCapt;

public class Main {
    private static final int NUM_ITERS = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Задание №1-3
        // TaskPrintPropertyAndJoinSecondThread th0 = new
        // TaskPrintPropertyAndJoinSecondThread();
        // Thread threadPrintProperty = new Thread(th0);

        // /// Чтобы все вставки удалялись и выполнялись параллельно
        // threadOne thread1 = new threadOne();
        // threadTwo thread2 = new threadTwo();
        // threadThree thread3 = new threadThree();

        // Thread th1 = new Thread(thread1);
        // Thread th2 = new Thread(thread2);
        // Thread th3 = new Thread(thread3);

        // threadPrintProperty.start();
        // th1.start();
        // th2.start();
        // th3.start();

        // threadPrintProperty.join();
        // th1.join();
        // th2.join();
        // th3.join();

        // Задание №4

        // List<Integer> arr = new ArrayList<>();
        // task4.solve(arr);

        // Задание №5
        // То же самое что №4, но оба потока на базе одного и того же класса,
        // использовать synchronized методы.

        // task5 data = new task5();
        // Runnable dataAdd = () -> {
        // try {
        // for (int i = 0; i < NUM_ITERS; i++) {
        // data.add();
        // System.out.println(data.getData());
        // }
        // } catch (Exception e) {
        // System.out.println(e);
        // }
        // };
        // Runnable dataDelete = () -> {
        // try {
        // for (int i = 0; i < NUM_ITERS; i++) {
        // System.out.println(data.getData());
        // data.delete();
        // }
        // } catch (Exception e) {
        // System.out.println(e);
        // }
        // };
        // Thread threadAdd = new Thread(dataAdd);
        // Thread threadRemove = new Thread(dataDelete);

        // threadAdd.start();

        // threadRemove.start();

        // Задание №6
        // То же самое. использовать метод Collections.synchronizedList

        // List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        // task6.solve(syncList);

        // Задача №7
        // “Ping Pong”, задача заключается в том, чтобы бесконечно выводить на консоль
        // сообщения “ping” или “pong” из двух разных потоков. При этом сообщения
        // обязаны чередоваться, т.е. не может быть ситуации, когда ping или pong
        // появляется в консоли более одного раза подряд.

        Thread t = new Thread(new MonitorCapt());
        t.start();
        
        


        // SemaphorRes semaphorRun = new SemaphorRes(semaphore1, semaphore2);
        // new Thread(semaphorRun).start();



    }

}
