package main.java.multithreading_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
1. Executor Framework: ThreadPoolExecutor, ScheduledExecutorService gibi farklı
executor türleri, iş parçacıklarının yönetimini ve yeniden kullanılabilirliğini sağlar.
FixedThreadPool Kullanımı:
 */
public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);  // 3 thread'li bir havuz

        //Bu örnekte, 10 görevi 3 thread kullanarak çalıştırıyoruz. Executor havuzu, daha az thread
        //ile çoklu görevleri verimli bir şekilde yönetir.
        for (int i=0; i<10; i++){
            executor.submit(()->{
                System.out.println("Thread: " + Thread.currentThread().getName() + " çalışıyor");
            });
        }

        executor.shutdown();
    }
}
