package main.java.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherExample {
    public static void main(String[] args) {
        //Matcher sınıfı, bir düzenli ifadenin (regex) belirli bir karakter dizisinde (string)
        // ne kadar, nerelerde ve nasıl eşleştiğini anlamak için kullanılır.

        // matches() : Bu metot, verilen tüm girdinin regex ile tam eşleşip eşleşmediğini
        // kontrol eder.
        String regex = "Hello";
        String text = "Hello World";
        boolean result = text.matches(regex);
        System.out.println(result);

        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaaab");
        System.out.println(matcher.matches()); // true

        // find() : Bu metot, verilen girdide regex e uygun bir alt dize bulur. Her çağrıldığında
        // bir sonraki olası eşlelmeyi bulur.
        Matcher matcher1 = pattern.matcher("aaaaabxxb");
        while (matcher1.find()) {
            System.out.println("Eşleşme bulundu: " + matcher1.group());
        }


        // group() : Son yapılan eşleşmeye karşılık gelen alt diziyi döner.
        Matcher matcher2 = pattern.matcher("aaaaabxxb");
        if (matcher2.find()) {
            System.out.println("İlk eşleşme: " + matcher2.group());
        }


        // group(int group) : Parantezlerle (capture groups) tanımlanmış alt grupları döner.
        Pattern pattern3 = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");
        Matcher matcher3 = pattern3.matcher("123-456-7890");
        if (matcher.matches()) {
            System.out.println("Area Code: " + matcher3.group(1)); // 123
            System.out.println("First Part: " + matcher3.group(2)); // 456
            System.out.println("Second Part: " + matcher3.group(3)); // 7890
        }


        // start() : Eşleşen dizenin başlangıç indeksini döner. Genellikle find() başarılı olduktan
        // sonra kullanılır.
        Pattern pattern4 = Pattern.compile("a*b");
        Matcher matcher4 = pattern4.matcher("aaaaabxxb");
        if (matcher.find()) {
            System.out.println("Eşleşmenin başlangıç indeksi: " + matcher4.start()); // 0
        }


        // end() : Eşleşen dizenin sonundaki indeksin bir fazlasını döner.Eşleşmenin sonlandığı
        // indeksin bir sonrasını gösterir.
        Pattern pattern5 = Pattern.compile("a*b");
        Matcher matcher5 = pattern5.matcher("aaaaabxxb");
        if (matcher5.find()) {
            System.out.println("Eşleşmenin bittiği yerin bir fazlası: " + matcher5.end());
        }


        // replaceAll(String replacement) : Girdide regex'e uyan her alt diziyi verilen replacement ile
        // değiştirir.
        Pattern pattern6 = Pattern.compile("cat");
        Matcher matcher6 = pattern6.matcher("one cat, two cats, three cats");
        String result1 = matcher6.replaceAll("dog");
        System.out.println(result1); // one dog, two dogs, three dogs


        // replaceFirst(String replacement) : Girdide regex'e uyan ilk alt dizeyi verilen replacement
        // ile değiştirir.
        Pattern pattern7 = Pattern.compile("cat");
        Matcher matcher7 = pattern7.matcher("one cat, two cats, three cats");
        String result2 = matcher7.replaceFirst("dog");
        System.out.println(result2); // one dog, two cats, three cats


        // lookingAt() : girdinin başındaki kısmının regex ile eşleşip eşleşmediğini kontrol eder
        Pattern pattern8 = Pattern.compile("a*b");
        Matcher matcher8 = pattern8.matcher("aaaaabxxb");
        System.out.println(matcher8.lookingAt()); // true (çünkü girdi aaaaab ile başlıyor)


        // reset() : Matcher nesnesini yeniden başlatır, aynı regex'i yeni bir girdi üzerinde
        // tekrar kullanmak için Matcher nesnesini sıfırlar.
        Matcher matcher9 = pattern8.matcher("aaaaabxxb");
        matcher9.find(); // ilk eşleşmeyi bulur
        matcher9.reset(); // Sıfırlanır ve tekrar kullanılabilir.


        Pattern pattern10 = Pattern.compile("\\d+");
        String text1 = "There are 123 apples, 45 oranges, and 6789 bananas.";
        Matcher matcher10 = pattern10.matcher(text);
        while (matcher10.find()) {
            System.out.println("Eşleşme: " + matcher10.group() + ", Başlangıç: " + matcher10.start() + ", Bitiş: " + matcher10.end());
        }
        /*
        Eşleşme: 123, Başlangıç: 10, Bitiş: 13
        Eşleşme: 45, Başlangıç: 22, Bitiş: 24
        Eşleşme: 6789, Başlangıç: 38, Bitiş: 42
        */


    }
}


/*
Java’da Matcher sınıfı, bir düzenli ifade (regex) ile belirli bir metin üzerinde eşleştirme
işlemlerini gerçekleştirmek için kullanılır. Matcher sınıfı, java.util.regex paketinin bir
 parçasıdır ve bir Pattern nesnesi ile eşleştirilmiş bir metin üzerinde işlemler yapar.
 */