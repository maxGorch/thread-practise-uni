package org.example.task11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class mainThread implements Runnable {
    @Override
    public void run() {
        Formatter dateFormatter = new Formatter();

        Thread th1 = new Thread(new thread1(dateFormatter));

        // Thread th2 = new Thread(new thread2(dateFormatter));
        // Thread th3 = new Thread(new thread3(dateFormatter));
        // Thread th4 = new Thread(new thread4(dateFormatter));
        // Thread th5 = new Thread(new thread5(dateFormatter));

        th1.start();
        // th2.start();
        // th3.start();
        // th4.start();
        // th5.start();
    }
}

class Formatter {

    public Date format(Date date) {
        var pattern = "yyyy.MM.dd";
        var newDateFormat = new SimpleDateFormat(pattern);

        newDateFormat.applyLocalizedPattern(date.toString());
        return date;
    }
}

class thread1 implements Runnable {
    public Formatter date;

    thread1(Formatter date) {
        this.date = date;
    }

    @Override
    public void run() {
        Date newDate = new Date("2026.01.01");
        System.out.println(date.format(newDate));
    }
}

class thread2 implements Runnable {
    public Formatter date;

    thread2(Formatter date) {
        this.date = date;
    }

    @Override
    public void run() {
        Date newDate = new Date("2026.02.02");
        System.out.println(date.format(newDate));
    }
}

class thread3 implements Runnable {
    public Formatter date;

    thread3(Formatter date) {
        this.date = date;
    }

    @Override
    public void run() {
        Date newDate = new Date("2026.03.03");
        System.out.println(date.format(newDate));
    }
}

class thread4 implements Runnable {
    public Formatter date;

    thread4(Formatter date) {
        this.date = date;
    }

    @Override
    public void run() {
        Date newDate = new Date("2026.04.04");
        System.out.println(date.format(newDate));
    }
}

class thread5 implements Runnable {
    public Formatter date;

    thread5(Formatter date) {
        this.date = date;
    }

    @Override
    public void run() {
        Date newDate = new Date("2026.05.05");
        System.out.println(date.format(newDate));
    }
}
