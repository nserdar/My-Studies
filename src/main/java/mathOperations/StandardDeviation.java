package main.java.mathOperations;

public class StandardDeviation {
    public static void main(String[] args) {

    }

    public static double standardDeviation(double[] numbers){
        double sum = 0.0;
        int n = numbers.length;

        //Average: ortalama değeri, dizideki sayıların toplamının eleman sayısına bölünmesiyle bulunur.
        for (double number: numbers){
            sum += number;
        }
        double average = sum / n;

        //variance: Her bir değerin ortalamadan sapmasının karesi alınır ve bu kareler toplanır.
        double varianceSum = 0.0;
        for (double number: numbers){
            varianceSum += Math.pow((number - average),2);
        }

        //Bu toplam, eleman sayısına bölünerek varyans bulunur.
        double variance = varianceSum / n;

        //Standart sapma, varyansın karekökünün alınmasıyla elde edilir.
        return Math.sqrt(variance);
    }
}
