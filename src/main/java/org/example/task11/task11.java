package org.example.task11;

import java.util.Date;

public class task11 implements Runnable {
    final int NUM_THREAD = 5;
    private Formatter dateFormatter;

    public task11(Formatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public void run() {
        Date date = new Date();
        String formattedDate = dateFormatter.format(date);
        System.out.println(formattedDate);
    }
}
