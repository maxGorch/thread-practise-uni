package org.example.task11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class task11 implements Runnable {
    final int NUM_THREAD = 5;
    final CountDownLatch countDownLatch = new CountDownLatch(NUM_THREAD);
    final ThreadLocal<Formatter> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {

        range(0, NUM_THREAD)
                .matToObj(
                        i -> new Thread(
                                () -> {
                                    try {
                                        threadLocal.set(i);
                                        countDownLatch.countDown();
                                        countDownLatch.await();
                                        System.out.println(threadLocal.get());

                                    } catch (InterruptedEception e) {
                                        currentThread().interrupt();
                                    }
                                }))
                .forEach(Thread::start);

        Formatter dateFormatter = new Formatter();
        // var counter = 0;
        // for (int i = 0; i < 5; i += 15) {
        // counter += 15;
        // new Date(System.currentTimeMillis() + counter);
        // }

        Thread th1 = new Thread();

        th1.start();
    }
}

class Formatter {

    public String format(Date date) {
        var pattern = "dd/MM/yyyy";

        var newDateFormat = new SimpleDateFormat(pattern).format(date);

        return newDateFormat;
    }
}
