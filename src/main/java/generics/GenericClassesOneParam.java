package main.java.generics;

public class GenericClassesOneParam<T>{

    public GenericClassesOneParam() {
    }

    private T numberOfBooks;

    public T getT() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(T t) {
        this.numberOfBooks = t;
    }

}
