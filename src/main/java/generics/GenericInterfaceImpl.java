package main.java.generics;

/*
İnterface'i implemente eden class'ın data tipini belirlemezsek <T> 'yi class'a eklemeliyiz
 */
public class GenericInterfaceImpl<T> implements GenericInterface<T>{

    @Override
    public void print(T value) {

    }

    @Override
    public T getT() {
        return null;
    }

    @Override
    public void setT(T t) {

    }

    @Override
    public T add(T t1, T t2) {
        return null;
    }
}
