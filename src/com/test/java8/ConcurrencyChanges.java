package com.test.java8;

import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class ConcurrencyChanges {

    public static void main(String[] args) {

    }

    //ComparableFuture(1.8) vs Future(1.5)
    //Future didn't have method to combine computations/handle errors.
    //ComparableFuture contains methods to combine results/handle errors.

    public Future<Integer> getSquareAsynchronously(int num) throws InterruptedException {
        CompletableFuture<Integer> completableFuture  = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            // The complete() call will complete this CompetableFuture.
            completableFuture.complete(num * num);
            return null;
        });

        return completableFuture;
    }

}
