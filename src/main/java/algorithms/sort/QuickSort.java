package main.java.algorithms.sort;


import java.util.Arrays;

//Pivot elemanı seçip, bu elemandan küçük ve büyük elemanları ayrı dizilere
//yerleştirerek sıralama yapar. Genellikle hızlı bir sıralama algoritmasıdır.
public class QuickSort {

    /*
    int[] arr: Sıralanacak olan dizi
    int low: Dizinin sıralanacak alt kısmının başlangıç indeksini belirtir
    high: Dizinin sıralanacak üst kısmının son indeksini belirtir.
     */
    public static void quickSort(int[] arr, int low, int high){
        // Eğer low < high koşulu sağlanıyorsa (yani sıralanacak elemanlar varsa),
        // partition metodunu çağırarak pivot indeksini bulur.
        if (low < high){
            int pivotIndex = partition(arr, low, high);

            //Ardından, dizinin sol ve sağ alt dizilerine rekürsif olarak quickSort metodunu çağırır.
            quickSort(arr, low, pivotIndex -1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Bu metod, diziyi iki alt diziye ayırmak için kullanılır ve bir pivot elemanı belirler.
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];  //Pivot olarak dizinin son elemanı seçilir.
        int i = low - 1;   //i indeksi, dizinin sol tarafındaki elemanların sonunu temsil eder

        for (int j = low; j < high; j++){
            if (arr[j] < pivot){   //Eğer mevcut eleman pivot’tan küçükse
                i++;

                //Elemanları yer değiştirir, böylece pivot’tan küçük olan elemanlar dizinin başında toplanır.
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1,high);  //Pivot elemanını doğru konumuna yerleştirir.
        return i + 1;   //Yeni pivot indeksini döner.
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sıralı dizi: " + Arrays.toString(arr));
    }
    /*
    Eğer pivot olarak 5’i seçersek:

	1.	Elemanların Karşılaştırılması:
	•	10 > 5
	•	7 > 5
	•	8 > 5
	•	9 > 5
	•	1 < 5
	•	5 kendisi zaten pivot.

	2.	Diziyi Bölme:
	•	Pivotun sol tarafında: {1}
	•	Pivotun sağ tarafında: {10, 7, 8, 9}
	•	Sonuç olarak, dizi şu hale gelir: {1, 5, 10, 7, 8, 9}.

	3.	Tekrar Sıralama: Şimdi quickSort algoritması, 1 ve 5’in bulunduğu kısım sıralı olduğundan
	 10, 7, 8 ve 9 üzerinde tekrar çalışacaktır.
     */

}

/*
pivot, dizinin sıralanmasında temel bir referans noktasıdır. Pivot, dizi elemanlarını iki alt diziye ayırmak
 için kullanılır: biri pivotun solundaki (pivot’tan küçük elemanlar), diğeri ise pivotun sağındaki
 (pivot’tan büyük veya eşit elemanlar) elemanlardır.

 Pivotun Rolü

	1.	Bölme İşlemi: Pivot, diziyi iki alt diziye ayırmak için kullanılır. Algoritma, her elemanı pivot ile
	 karşılaştırır ve pivot ile karşılaştırılan elemanlar ile yer değiştirerek diziyi böler.
	2.	Sıralama Kriteri: Pivot, sıralama işleminin temel kriterini oluşturur. Diğer elemanların pivot ile
	karşılaştırılması, hangi elemanların daha küçük veya daha büyük olduğunu belirler.
	3.	Hedefleme: Algoritmanın temel hedefi, pivotun doğru konumda yerleştirilmesidir. Bu işlem tamamlandığında,
	 pivot elemanının artık sıralı dizideki doğru yerini bulmuş olur.
 */

/*
Quick Sort, ortalama durumda O(n log n) zaman karmaşıklığına sahiptir ve genellikle hızlı bir sıralama
algoritması olarak kabul edilir. Ancak, kötü pivot seçimlerinde O(n²) zaman karmaşıklığına ulaşabilir.
Bu nedenle, pivot seçim stratejisi önemlidir. Quick Sort, dizi üzerinde in-place (yani ek alan kullanmadan)
sıralama yapabilir, bu da onu hafıza açısından verimli bir seçenek haline getirir.
 */