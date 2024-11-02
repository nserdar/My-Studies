package main.java.multithreading_concurrency;

import java.util.concurrent.CompletableFuture;

/*
CompletableFuture, daha basit bir API ile asenkron işlemler yürütmenizi sağlar ve
 thenApply, thenAccept, thenCombine gibi yöntemler ile farklı aşamalara göre veri işleyebilir.
 CompletableFuture Kullanımı: Bu kodda supplyAsync, asenkron bir şekilde çalışır ve thenApply
  ile bir sonucu işleyerek sonuca ulaşırız. Asenkron programlama ile I/O işlemlerinde büyük
  bir hız artışı sağlanır.
 */

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Birinci görev çalışıyor...");
            return 10;
        }).thenApply(result -> {
            System.out.println("İkinci görev çalışıyor...");
            return result * 2;
        }).thenAccept(result -> {
            System.out.println("Sonuç: " + result);
        });

        future.join();  // Tüm işlemlerin tamamlanmasını bekle
    }
}
