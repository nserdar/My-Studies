package main.java.multithreading_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/*
 Atomic Değişkenler: Bazı durumlarda kilit kullanmadan güvenli değişken
 güncellemeleri yapabiliriz. AtomicInteger, AtomicBoolean gibi sınıflar
 atomik işlemler sağlar ve kilitlemeye gerek kalmadan çok iş parçacıklı
  ortamda güvenli bir şekilde çalışır.
  AtomicInteger Kullanımı: Burada AtomicInteger, her thread’in count değerini
   güvenli bir şekilde artırmasını sağlar.
 */
public class AtomicExample {
    private static final AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable task = () -> {
            int value = atomicCount.incrementAndGet();  // Güvenli bir şekilde arttırma
            System.out.println("Atomic Count: " + value);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
