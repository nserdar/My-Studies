package main.java.generics;

import java.util.ArrayList;
import java.util.List;

/*
  wildcard(?): bilinmeyen data tipi, joker.
  ? extends Integer ifadesi, listeye eleman eklemeye izin vermez. Çünkü Java, wildcard kullanılan yerlerde güvenli ekleme işlemlerine
  izin vermez; hangi tam türün kullanıldığını kesin olarak bilemediği için. Bu yüzden listeye eleman eklenemez, sadece elemanları okuyabiliriz.
 */
public class GenericWithWildcard {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();

        addElement(list1);
        addElement(list2);
        addElement(list3);



    }

    // Alttan sınırlamaya örnek:
    public static void addElement(List<? super Integer> list){   // ? yerine Integer, Number ve Object sınıfları gelebilir
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
    }

    // Üstten sınırlama - upper-bounded:
    public static void multiplyByTwo(List<? extends Integer> list){  // ? yerine Integer yada alt sınıfları(yoktur) gelebilir
       list.forEach(i -> System.out.println(i*2));
    }

    //Sadece wildcard(?)
    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }


    public static <T> void addElement(List<T> list, T element){
        list.add(element);
    }

}
/*
Wildcard (?) kullanımı her zaman read-only (sadece okuma) değildir, ancak nasıl kullanıldığına bağlı olarak bazı kısıtlamalar getirir. Genel bir kural olarak:

	1.	Upper Bounded Wildcard (? extends T): Sadece okuma yapabilirsiniz, yani listeye yeni eleman ekleyemezsiniz. Ancak listedeki elemanları okuyabilir ve işleyebilirsiniz. Bunun nedeni, listeye tam olarak hangi alt sınıfların kabul edildiğini Java’nın bilmemesidir, bu yüzden güvenli eklemelere izin verilmez.
	•	Örneğin, List<? extends Number>: Bu liste Number ve onun alt sınıflarını (örneğin Integer, Double) içerir. Ancak tam olarak hangi türlerin kullanılacağı belirsiz olduğundan, listeye ekleme yapılamaz.
Özellikler:
	•	Listeye ekleme yapılamaz.
	•	Listeden okuma yapılabilir.

	public static void processNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num.doubleValue());
    }
    // list.add(10); // Derleme hatası: add() methodu kullanılamaz!
}

   	2.	Lower Bounded Wildcard (? super T): Listeye eleman ekleyebilirsiniz, ancak elemanları okurken sadece Object türünde alabilirsiniz. Bu, bir listenin en azından T türünden elemanlar içereceğini garanti eder, dolayısıyla T veya onun alt sınıflarını güvenle ekleyebilirsiniz.
	•	Örneğin, List<? super Integer>: Bu listeye Integer veya onun alt sınıfı eklenebilir, ancak listeden aldığınız elemanlar en genel tür olan Object olarak geri dönecektir.
Özellikler:
	•	Listeye ekleme yapılabilir (örneğin Integer eklenebilir).
	•	Listeden okuma yapılabilir, ancak sadece Object türünde.

	public static void addIntegers(List<? super Integer> list) {
    list.add(10);  // Geçerli
    list.add(20);  // Geçerli
    // Integer num = list.get(0); // Derleme hatası: sadece Object olarak geri alınabilir.
    Object obj = list.get(0);    // Geçerli

    	•	? extends T: Sadece okuma yapılabilir, ekleme yapılamaz.
	•	? super T: Sadece ekleme yapılabilir, okuma yapılırsa sadece Object olarak alınabilir.

Bu nedenle, wildcard’ların tamamen read-only olduğunu söylemek doğru değildir, çünkü ? super T ile ekleme yapılabilir.

}




 */







