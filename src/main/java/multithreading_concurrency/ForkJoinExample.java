package main.java.multithreading_concurrency;

import java.util.concurrent.ForkJoinPool;

//Bu kod, verilen n değeri için Fibonacci sayısını hesaplar ve
//ForkJoinPool sayesinde hesaplamalar paralel olarak gerçekleştirilir.
public class ForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(10);

        int result = pool.invoke(task);
        System.out.println("Fibonacci sonucu: " + result);
    }
}
