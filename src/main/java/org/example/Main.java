package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.example.task11.mainThread;
import org.example.task4.task4;
import org.example.task7.MonitorCapt;
import org.example.task8.task8;
import org.example.task9.task9;

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

        // Задание №7
        // “Ping Pong”, задача заключается в том, чтобы бесконечно выводить на консоль
        // сообщения “ping” или “pong” из двух разных потоков. При этом сообщения
        // обязаны чередоваться, т.е. не может быть ситуации, когда ping или pong
        // появляется в консоли более одного раза подряд.

        // Thread t = new Thread(new MonitorCapt());
        // t.start();

        // Задание №8
        // Переписать пункт 4 этого упражнения, используя ReentrantLock

        // List<Integer> arr = new ArrayList<>();
        // task8.solve(arr);

        // task8 obj = new task8();
        // obj.solve(arr);
        // Здание №9
        // “Ping Pong” на базе ReentrantLock и Conditional переменной.

        // Thread t = new Thread(new task9());
        // t.start();

        // Задание №11
        // Написать класс Formatter, с методом format(Date date), форматирующим
        // дату-время.
        // Использовать для форматирования класс SimpleDateFormat.
        // В основном потоке создается единственный экземпляр класса Formatter.
        // Создать 5 потоков, каждому потоку передается при инициализации этот
        // экземпляр.
        // Потоки должны корректно форматировать дату-время, синхронизация не
        // разрешается.

        Thread th1 = new Thread(new mainThread());
        th1.start();

    }

}
