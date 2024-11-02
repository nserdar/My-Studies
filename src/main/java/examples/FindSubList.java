package main.java.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<int[]> subLists = findSubLists(arr);
        for (int[] i: subLists){
            System.out.print("[ ");
            for (int j: i){
                System.out.print(j + " ");
            }
            System.out.println("]");
        }
    }

    // List<int[]>: alt dizileri listelemek için
    public static List<int[]> findSubLists(int[] list) {
        List<int[]> subLists = new ArrayList<>();
        int n = list.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {  // j < n olmalı
                int[] subList = new int[j - i + 1];
                for (int k = i; k <= j; k++) {  // k, j dahil
                    subList[k - i] = list[k];
                }
                subLists.add(subList);
            }
        }
        return subLists;
    }
}