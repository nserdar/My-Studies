package main.java.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {
    public static void main(String[] args) {

        // compile(String regex) : Bu metot, belirtilen düzenli ifadeyi derler ve bir Pattern nesnesi döner
        Pattern pattern = Pattern.compile("Hello");
        System.out.println(pattern);

        // compile(String regex, int flags) : bu metot belirtilen düzenli ifadeyi verilen flag ile
        // birlikte derler. Flag, regex'in nasıl işleyeceğini kontrol eder örneğin büyük - küçük
        // harf gibi.
        Pattern pattern2 = Pattern.compile("Hello", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern2);

        // matcher(CharSequence input) : Bu metot, verilen girdi üzerinde düzenli ifade eşleştirmesi
        // yapacak bir Matcher nesnesi döner.
        Pattern pattern3 = Pattern.compile("Hello");
        Matcher matcher = pattern3.matcher("Hello World");
        System.out.println(matcher.find());

        // split(CharSequence input) : Bu metot verilen karakter dizisini, düzenli ifadeyi kullanarak
        // böler ve bir array döner.
        Pattern pattern4 = Pattern.compile(" ");
        String[] split = pattern4.split("Hello World");
        for (String s : split) {
            System.out.println(s);
        }

        Pattern pattern5 = Pattern.compile("\\s+");  // Beyaz boşluklara göre böler
        String[] result = pattern5.split("Java is fun");
        for (String s : result) {
            System.out.println(s);
        }

        // split(CharSequence input, int limit) : Bu metot, kaç kez bölme işlemi yapılacağını
        // kontrol eder.
        Pattern pattern6 = Pattern.compile("\\s+");
        String[] result2 = pattern6.split("Java is fun", 2);
        for (String s : result2) {
            System.out.println(s);
        }

        // pattern() : Bu metot, Pattern nesnesinin içerdiği düzenli ifadeyi bir String olarak
        // böler.
        Pattern pattern7 = Pattern.compile("\\s+");
        String patternString = pattern7.pattern();
        System.out.println(patternString);

        Pattern pattern8 = Pattern.compile("a*b");
        System.out.println(pattern8.pattern()); // Çıktı: a*b

        // flags() : Bu metot, bir Pattern nesnesi tarafından kullanılan bayrakları(flag)
        // döner.
        Pattern pattern9 = Pattern.compile("a*b", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern9.flags()); // Çıktı: 2 (CASE_INSENSITIVE bayrağı)

        /*
        Kullanılabilecek Bayraklar (Flags)

Pattern sınıfı ile düzenli ifadelerin nasıl davranacağını kontrol etmek için birkaç bayrak kullanabilirsiniz:

	1.	Pattern.CASE_INSENSITIVE: Düzenli ifade büyük/küçük harf duyarsız hale gelir.
	2.	Pattern.MULTILINE: Birden fazla satırı desteklemek için ^ ve $ karakterlerinin her satırın başına ve sonuna uyacak şekilde çalışmasını sağlar.
	3.	Pattern.DOTALL: Nokta (.) karakteri yeni satır karakterleriyle de eşleşir.
	4.	Pattern.UNICODE_CASE: Unicode karakterleri için büyük/küçük harf duyarsızlığı sağlar.
	5.	Pattern.COMMENTS: Düzenli ifadeye açıklamalar eklemenizi sağlar ve boşluk karakterlerini yok sayar.
         */


    }
}


/*
  Java’daki Pattern sınıfı, düzenli ifadeleri (regex) çalıştırmak için kullanılan bir sınıftır.
 Bu sınıf, bir düzenli ifadeyi derlemek ve bu ifadeyi kullanarak metinlerde arama, eşleştirme
 gibi işlemler yapmak için kullanılır. Pattern sınıfı, java.util.regex paketinin bir parçasıdır
 ve Java’da regex işlemlerini gerçekleştirmenin temel yollarından biridir.

 Pattern sınıfı düzenli bir ifadeyi temsil eder, doğrudan nesne oluşturmayı desteklemez.
 Bunun yerine statik compile() metoduyla bir nesne oluşturulabilir.
 */