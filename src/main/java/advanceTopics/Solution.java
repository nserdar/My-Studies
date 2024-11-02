package main.java.advanceTopics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        CustomAnnotation test = new CustomAnnotation();

        //Bu döngü, test nesnesinin sınıfındaki tüm metodları getirir (getDeclaredMethods()),
        //yani TestClass içindeki tüm metodlar bir Method nesneleri listesi olarak döner.
        for (Method method: test.getClass().getDeclaredMethods()){

            //Bu satır, her bir metodun @CanRun anotasyonuna sahip olup olmadığını kontrol eder.
            if (method.isAnnotationPresent(CanRun.class)){

                //Bu satır, anotasyona sahip olan metodları çalıştırır. method.invoke(test)
                method.invoke(test);
            }
        }

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(123);
        System.out.println("Box içeriği: " + integerBox.getValue());

        Box<String> stringBox = new Box<>();
        stringBox.setValue("string value");
        System.out.println("Box içeriği: " + stringBox.getValue());

    }
}
