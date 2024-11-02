package main.java.multithreading_concurrency;

import java.util.concurrent.RecursiveTask;

/*
Fork/Join, büyük görevleri küçük parçalara bölerek işleyen bir framework’tür.
 RecursiveTask ve RecursiveAction sınıflarını kullanarak işlemi recursive şekilde bölebiliriz.
  Bu özellikle CPU yoğunluklu işler için kullanılır.
  RecursiveTask Kullanarak Fibonacci Hesaplama:
 */
class FibonacciTask extends RecursiveTask<Integer> {
    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) return n;

        FibonacciTask f1 = new FibonacciTask(n-1);
        FibonacciTask f2 = new FibonacciTask(n-2);

        f1.fork();  // İlk görev asenkron başlatılıyor
        return f2.compute() + f1.join();   // İkinci görev hemen hesaplanıyor ve ilk görev tamamlanması bekleniyor
    }
}

