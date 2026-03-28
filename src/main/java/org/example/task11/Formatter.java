package org.example.task11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

    public String format(Date date) {
        ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

        var pattern = "dd/MM/yyyy HH:mm:ss";

        threadLocal.set(new SimpleDateFormat(pattern));

        var newDateFormat = threadLocal.get().format(date);

        return newDateFormat;
    }
}