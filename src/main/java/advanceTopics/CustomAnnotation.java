package main.java.advanceTopics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Özel bir anotasyon oluşturun ve bir sınıfın metoduna ekleyin.
// Bu anotasyon, metodun çalışıp çalışmadığını kontrol edecek.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CanRun {}
class CustomAnnotation {

    @CanRun
    public void testMethod(){
        System.out.println("Test çalışıyor");
    }

    public void anotherMethod() {
        System.out.println("Bu metod çalışmıyor çünkü @CanRun anotasyonuna sahip değil.");
    }
}

/*
@Retention anotasyonu, tanımlanan anotasyonun ne kadar süre saklanacağını belirtir.
RetentionPolicy üç farklı değere sahiptir:

	•	RetentionPolicy.SOURCE: Anotasyon sadece kaynak kodda bulunur ve derleme (compilation)
	 aşamasında yok edilir. Yani, çalıştırılabilir koda dahil edilmez. Bu tür anotasyonlar
	 sadece kodu okuyan IDE’ler veya araçlar için kullanışlıdır.

	•	RetentionPolicy.CLASS: Anotasyon derleme sürecinde sınıf dosyasına (bytecode) dahil edilir,
	 ancak çalıştırma sırasında (runtime) bulunmaz. Bu tür anotasyonlar, çalıştırma anında değil,
	 yalnızca derleyiciler veya bytecode analiz araçları için kullanılabilir.

	 •	RetentionPolicy.RUNTIME: Anotasyon, çalıştırma sırasında (runtime) erişilebilir hale getirilir.
	  Bu, reflection kullanılarak çalıştırma sırasında anotasyonları okuyabilmenize olanak tanır.

@Target, anotasyonun hangi tür yapılara uygulanabileceğini belirtir. ElementType şu tür değerler alabilir:

    •	ElementType.TYPE: Anotasyon sınıf, arayüz veya enum üzerine uygulanabilir.
	•	ElementType.FIELD: Anotasyon, sınıf alanlarına (field) uygulanabilir.
	•	ElementType.METHOD: Anotasyon, metodlara uygulanabilir.
	•	ElementType.PARAMETER: Anotasyon, metod parametrelerine uygulanabilir.
	•	ElementType.CONSTRUCTOR: Anotasyon, yapıcı metodlara (constructor) uygulanabilir.
	•	ElementType.LOCAL_VARIABLE: Anotasyon, yerel değişkenlere uygulanabilir.
	•	ElementType.ANNOTATION_TYPE: Anotasyon, başka anotasyon türlerine uygulanabilir.

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CanRun {}
Bu yapı, @CanRun adlı bir anotasyon tanımlar:

	•	RetentionPolicy.RUNTIME ile çalıştırma anında erişilebilir ve reflection ile kontrol edilebilir.
	•	ElementType.METHOD ile yalnızca metodlar üzerinde kullanılabilir.

 */
