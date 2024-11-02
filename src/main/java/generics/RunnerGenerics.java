package main.java.generics;

public class RunnerGenerics {
    public static void main(String[] args) {

        GenericClassesOneParam<Integer> numberOfBooks = new GenericClassesOneParam<>();
        numberOfBooks.setNumberOfBooks(4);
        System.out.println(numberOfBooks.getT());

        GenericClassWithTwoParam<String,Integer> products = new GenericClassWithTwoParam<>("Computer",5);
        System.out.println(products.getKey());
        products.setValue(10);
        System.out.println(products.getValue());

        GenericClassWithTwoParam<Double,Double> calc = new GenericClassWithTwoParam<>(30.0,40.0);
        System.out.println(calc.getKey()*(calc.getValue()));


    }
}
