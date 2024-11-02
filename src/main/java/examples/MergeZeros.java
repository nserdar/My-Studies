package main.java.examples;

import java.util.ArrayList;
import java.util.List;

public class MergeZeros {
    public static int[] mergeZeros(int[] array) {
        List<Integer> resultList = new ArrayList<>();
        int sum = 0;

        for(int w: array){
            if(w == 0){
                resultList.add(sum);
                resultList.add(0);
                sum = 0;
            }
            else{
                sum += w;
            }
        }
        if (sum != 0) {
            resultList.add(sum);
        }

// Sonucu bir diziye dönüştür
        return resultList.stream().mapToInt(i -> i).toArray();

    }
}
