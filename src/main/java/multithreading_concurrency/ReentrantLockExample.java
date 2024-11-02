package main.java.multithreading_concurrency;

import java.util.concurrent.locks.ReentrantLock;

/*
  Concurrency API (Locks, Semaphores, ve diğerleri): Concurrency API, kilitleme, sayıcılar
 ve sinyalizasyon mekanizmaları sağlar.
  ReentrantLock: Gelişmiş kilitleme için synchronized anahtar kelimesine alternatif sunar.
 tryLock veya lockInterruptibly gibi ek özellikler içerir.
  ReadWriteLock: Aynı anda birden çok okuma izni verirken, tek bir yazma izni verir.
  Semaphore: İzin sayısını sınırlayarak thread’lerin aynı kaynağa erişimini kontrol eder.
   ReentrantLock ile Kilitleme:Bu örnekte, ReentrantLock kullanarak count değişkenine güvenli
    erişim sağladık. Bu, birden fazla thread aynı anda aynı kaynağa erişmeye çalıştığında veri bütünlüğünü korur.
 */
public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();
    private static int count = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock();
            try {
                count++;
                System.out.println("Count: " + count + " - " + Thread.currentThread().getName());
            }finally {
                lock.unlock();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }

}
