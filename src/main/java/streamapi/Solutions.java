package main.java.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {
    public static void main(String[] args) {

        //İki farklı liste veriliyor. Bu listelerdeki ortak elemanları filtreleyip
        // benzersiz (duplicate olmayan) bir liste olarak döndürün.
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);

        List<Integer> commonElements = list1.stream()

                //filter(list2::contains): list1’deki her bir eleman list2’de bulunuyorsa, bu eleman akışa dahil edilir.
                .filter(list2::contains)
                .distinct()
                .toList();





        // Verilen bir listenin içindeki en sık tekrar eden elemanı ve kaç kez tekrar ettiğini bulun.
        List<String> words = List.of("apple", "banana", "orange", "apple", "orange", "apple");

        Map.Entry<String,Long> mostFrequent = words.stream()

                // Bu kısım words listesindeki her bir kelimenin kaç defa geçtiğini sayar. groupingBy metodu, listedeki her bir
                // öğe için bir Map<String, Long> yapısı oluşturur.
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))

                //entrySet().stream(): Map yapısının girişlerini (Map.Entry) bir stream olarak alır.
                .entrySet().stream()

                //Map.Entry öğelerinin value değerine göre maksimum değeri bulur
                .max(Map.Entry.comparingByValue())

                //Eğer max() ile bir sonuç bulunamazsa (örneğin, words listesi boşsa), bir NoSuchElementException fırlatılır.
                .orElseThrow();

        System.out.println("En Sık Tekrar Eden Eleman: " + mostFrequent.getKey());
        System.out.println("Tekrar Sayısı: " + mostFrequent.getValue());








        //Verilen bir tamsayı listesindeki ardışık elemanlar arasındaki farkların karesini hesaplayıp yeni bir liste olarak döndürün.
        List<Integer> numbers = List.of(10, 15, 20, 25);

        /*
        IntStream.range(0, numbers.size() - 1): numbers listesindeki elemanlar üzerinde dolaşmak için 0’dan başlayarak numbers.size() - 2 indeksine kadar bir aralık oluşturur. Bu, her iki ardışık elemanı ele alabilmemiz için kullanılır.
		Örneğin, numbers [10, 15, 20, 25] ise, bu akış 0, 1, 2 indekslerini dolaşır.
         */
        List<Integer> differences = IntStream.range(0, numbers.size()-1)

                //map(i -> (int)Math.pow(numbers.get(i + 1) - numbers.get(i), 2)):
                //Bu kısım, her bir i indeksinde, i ve i + 1 elemanları arasındaki farkı hesaplar
                //•	(15 - 10)^2 = 25
                .map(i -> (int)Math.pow(numbers.get(i + 1) - numbers.get(i), 2))

                //boxed(): IntStream akışındaki int değerleri Integer nesnelerine dönüştürür.
                .boxed()
                .toList();

        System.out.println("Ardışık Farkların Kareleri: " + differences);










        //Verilen bir liste içindeki tek ve çift sayıları ayrı ayrı toplayarak sonuçları bir Map yapısında döndürün.
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        /*
        	•	partitioningBy(n -> n % 2 == 0, Collectors.summingInt(n -> n)): partitioningBy yöntemi, numbers1 listesini n % 2 == 0 koşuluna göre ikiye böler. Bu koşul doğru (true) olduğunda sayı çift, yanlış (false) olduğunda ise tek olarak değerlendirilir.
	•	Collectors.summingInt(n -> n): Her iki gruptaki sayıların toplamını alır. Bu işlem sonucunda Map<Boolean, Integer> türünde bir yapı elde edilir, burada:
	•	true anahtarı çift sayıların toplamını,
	•	false anahtarı ise tek sayıların toplamını tutar.
Örneğin, numbers1 listesi [1, 2, 3, 4, 5] olduğunda bu işlem şu sonucu verir: { true=6, false=9 }
         */
        Map<String,Integer> result = numbers1.stream()
                .collect(Collectors.partitioningBy(
                        n -> n % 2 == 0,
                        Collectors.summingInt(n -> n)
                ))

                //entrySet().stream(): İlk adımda oluşturulan Map<Boolean, Integer> yapısındaki her Map.Entry elemanı üzerinde bir stream başlatır.
                .entrySet().stream()

                /*
                toMap: Boolean türündeki anahtarları daha anlamlı hale getirir:
	•	Eğer anahtar true ise, "Çiftlerin toplamı" olarak ayarlanır.
	•	Eğer anahtar false ise, "Teklerin toplamı" olarak ayarlanır.
                 */
                .collect(Collectors.toMap(
                        e -> e.getKey() ? "Çiftlerin toplamı" : "Teklerin toplamı",

                        //	Map.Entry::getValue: Her girdinin değeri doğrudan alınır.
                        //Sonuç olarak, Map<String, Integer> türünde, çift ve tek sayıların toplamlarını içeren bir Map elde edilir.
                        Map.Entry::getValue
                ));
        System.out.println("Toplamlar: " + result);













        //Verilen bir listeyi, her elemanının 10 ile bölümünden kalanına göre gruplandırın ve her grubun ortalamasını bulun.
        List<Integer> numbers2 = List.of(11, 21, 31, 41, 12, 22, 32);

        Map<Integer,Double> averageByRemainder = numbers2.stream()


                //groupingBy(n -> n % 10): numbers2 listesindeki her sayıyı 10’a göre mod alarak gruplar.
                // Böylece Map<Integer, Double> yapısının anahtarı (key), sayının 10’a göre kalanını ifade eder.
                // Collectors.averagingDouble(n -> n): Her bir grup için sayıların ortalamasını alır. averagingDouble ,
                // metodu sayıları double türünde değerlendirerek daha kesin sonuçlar verir.
                .collect(Collectors.groupingBy(n -> n % 10, Collectors.averagingDouble(n -> n)));

        /*
        Örneğin, numbers2 listesi [11, 22, 13, 34, 25] ise, şu şekilde bir Map elde edilir:
	•	Kalan 1 olan sayılar: [11, 22], ortalaması (11 + 22) / 2 = 16.5
	•	Kalan 3 olan sayılar: [13, 34], ortalaması (13 + 34) / 2 = 23.5
	•	Kalan 5 olan sayılar: [25], ortalaması 25.0
	{1=16.5, 3=23.5, 5=25.0}
         */
        System.out.println("Bölüm Kalanına Göre Ortalamalar: " + averageByRemainder);


    }
}















