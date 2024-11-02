package main.java.generics;

/*
Generic yapılarda parametre olarak alınan data tipini üstten sınırlandırabiliriz
Burada T üstten Number sınıfı ve alt sınıfları ->Byte, Short, Integer, Long, Float,
Number ile sınırlıdır.
 */
public class GenericUpperBound <T extends Number>{

    public Double doubleValue;

    public void print(T value){
        System.out.println(value);
    }

    public T[] numberArray;

    public Float getFloatAverage(){
        float sum = 0;
        for (T value : numberArray) {
            sum += value.floatValue();
        }
        return sum/numberArray.length;
    }



}
