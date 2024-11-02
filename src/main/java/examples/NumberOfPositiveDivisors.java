package main.java.examples;

public class NumberOfPositiveDivisors {
    public static void main(String[] args) {

        int n = numberOfDivisors(12);
        System.out.println(n);

        int k = multiplyOfNumbers(new int[]{1,2,3,4,5});
        System.out.println(k);

    }

    public static int numberOfDivisors(int number){
        int numberOfDiv = 0;
        for(int i = 1; i <= Math.sqrt(number); i++){ // for döngüsü, 1’den başlayarak n sayısının kareköküne kadar gider.
            if(number % i == 0){
                numberOfDiv ++;
                if (i != number / i) { // Eğer karekök değilse
                    numberOfDiv++; // Diğer bölen
                }
            }
        }
        return numberOfDiv;
    }

    public static int multiplyOfNumbers(int[] array){
        int result = 1;
        for(int i: array){
            result *= i;
        }
        return result;
    }

}
