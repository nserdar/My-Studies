package main.java.mathOperations;

import java.util.ArrayList;
import java.util.List;

public class NonPrime {
    public static void main(String[] args) {
        int n = 10; // İstenilen asal olmayan sayı miktarı
        List<Integer> nonPrimes = findNonConsecutivePrimes(n);
        System.out.println("İlk " + n + " ardışık asal olmayan sayı: " + nonPrimes);
    }

    public static List<Integer> findNonConsecutivePrimes(int n){
        List<Integer> nonPrimes = new ArrayList<>();
        int num = 4;

        while (nonPrimes.size() < n){
            if (!isPrime(n)){
                nonPrimes.add(n);
            }
            n++;
        }
        return nonPrimes;
    }

    public static boolean isPrime(int n){
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6){
            if (n % i == 0 || n % (i+2) == 0) return false;
        }

        return true;
    }
}
