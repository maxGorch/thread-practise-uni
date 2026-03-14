package org.example.practiseSelf;

import java.util.concurrent.CompletableFuture;

public class practiseCompFut {
    public void comFutuAcceptAsyncString()
    {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->
    {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        return "Результат асинхронной операции";
    });

    completableFuture.thenAcceptAsync(result-> System.out.println(result));

    }
}
