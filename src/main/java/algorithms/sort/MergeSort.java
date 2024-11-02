package main.java.algorithms.sort;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right){

        //Eğer left ve right eşit veya left büyüklüğünde olursa, bu durumda dizi zaten tek bir
        //öğeden oluşuyor demektir ve sıralamaya gerek yoktur. Bu koşul, rekürsif çağrıların durmasını sağlar.
       if (left < right){
           int mid = left + (left + right) / 2;
           mergeSort(arr, left, mid);              // Sol yarıyı sıralar
           mergeSort(arr, mid + 1, right);     // Sağ yarıyı sıralar
           merge(arr, left, mid, right);           //sıralanmış iki alt diziyi (sol ve sağ yarılar) birleştirerek sıralı tam diziyi oluşturur.
       }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //L ve R adlı iki geçici dizi, sırasıyla sol ve sağ yarının elemanlarını tutar.
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Bu döngüler, orijinal dizinin left ile mid arasındaki elemanları L dizisine ve
        //mid + 1 ile right arasındaki elemanları R dizisine kopyalar.
        for (int i=0; i<n1; i++) L[i] = arr[left + i];
        for (int j=0; j<n2; j++) R[j] = arr[mid + 1 + j];

        int i=0, j=0, k=left;

        //Bu döngü, L ve R dizilerini karşılaştırarak, L[i] küçükse arr[k] içine L[i] değerini,
        //R[j] küçükse arr[k] içine R[j] değerini yerleştirir ve k indeksini arttırır.
        while (i<n1 && j<n2){
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        //Eğer L veya R dizisinde hala eklenmemiş eleman kalmışsa, bu döngülerle kalan elemanları doğrudan arr içine ekler.
        while (i<n1) arr[k++] = L[i++];
        while (j<n2) arr[k++] = R[j++];

    }

}
/*
Diyelim ki arr = {4, 3, 1, 5, 2} ve mergeSort(arr, 0, arr.length - 1) çağrılır:

	1.	İlk çağrıda dizi iki alt diziye bölünür: {4, 3, 1} ve {5, 2}.
	2.	Bu alt diziler sıralanır: {1, 3, 4} ve {2, 5}.
	3.	merge metodu, sıralı bu iki alt diziyi birleştirerek {1, 2, 3, 4, 5} dizisini oluşturur.

Sonuç olarak, Merge Sort sıralı bir dizi döndürür.
 */