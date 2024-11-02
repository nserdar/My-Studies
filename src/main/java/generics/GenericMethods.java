package main.java.generics;

import java.util.Arrays;

public class GenericMethods {
    public static void main(String[] args) {

        Integer[] intArray = {4,7,98};
        Double[] doubleArray = {4.5,7.8,98.9};
        String[] stringArray = {"java","C#","Python"};




    }

    public static void print(Integer[] intArray){
        Arrays.stream(intArray).forEach(System.out::println);
    }

    public static void print(Double[] doubleArray){
        Arrays.stream(doubleArray).forEach(System.out::println);
    }

    public static void print(String[] stringArray){
        Arrays.stream(stringArray).forEach(System.out::println);
    }

    // Generic metotlar
    // Burada da metot, generik bir tür (<T>) kabul eder, ancak hiçbir şey döndürmez (dönüş tipi void’dir).
    public static <T> void printAllTypes(T[] array){
        Arrays.stream(array).forEach(System.out::println);
    }

    //Burada metot, generic bir tür (<T>) kabul eder ve bu generik türde bir değer döndürür.
    public static <T> T getFirstElement(T[] array){
        T firstElement = array[0];
        return firstElement;
    }

    public static <S,U> void print(S s, U u){
        System.out.println(s);
        System.out.println(u);
    }

    public static <S,U> void printArrayAndElement(S[] array, U element){
        Arrays.stream(array).forEach(System.out::println);
        System.out.println(element);
    }


}













