package org.example.practiseSelf;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class practiseExecServ
{
    public void exServiceGetString() throws InterruptedException, ExecutionException
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(()->
        {
            Thread.sleep(1000);
            return "Результат задачи";
        });
        executor.shutdown();
        String result = future.get();
        System.out.println(result);
    }
}