package main.java.advanceTopics;

import java.lang.reflect.Method;
import java.util.Arrays;

//Java Reflection: Java’da reflection (yansıtma) API’si, runtime (çalışma zamanı) sırasında sınıf
// yapısını analiz etmemize olanak tanır.

//Reflection API kullanarak verilen bir sınıfın tüm metod isimlerini listeleyen bir metod yazma:
public class UsingReflection {
    public static void main(String[] args) {
        Class<Student> student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        // Metod isimlerini alfabetik sıraya koyma işlemi
        Arrays.sort(methods,(Method m1,Method m2)->m1.getName().compareTo(m2.getName()));

        for (Method method: methods){
            System.out.println(method.getName());
        }
    }
}
