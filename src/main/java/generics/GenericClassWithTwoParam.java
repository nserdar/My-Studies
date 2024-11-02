package main.java.generics;

public class GenericClassWithTwoParam <S,U>{

    private S s;
    private U u;

    public GenericClassWithTwoParam(S key, U value){
        this.s = key;
        this.u = value;
    }

    public S getKey() {
        return s;
    }

    public void setKey(S s) {
        this.s = s;
    }

    public U getValue() {
        return u;
    }

    public void setValue(U u) {
        this.u = u;
    }
}
