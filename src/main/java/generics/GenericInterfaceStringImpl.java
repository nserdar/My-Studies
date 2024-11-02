package main.java.generics;

/*
İnterface'i implemente eden class'ın data tipine başta karar verebiliriz
 */
public class GenericInterfaceStringImpl implements GenericInterface<String> {
    @Override
    public void print(String value) {

    }

    @Override
    public String getT() {
        return "";
    }

    @Override
    public void setT(String s) {

    }

    @Override
    public String add(String t1, String t2) {
        return "";
    }
}
