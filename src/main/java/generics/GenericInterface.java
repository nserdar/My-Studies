package main.java.generics;

public interface GenericInterface<T> {

    void print(T value);
    T getT();
    void setT(T t);
    T add(T t1,T t2);
}
