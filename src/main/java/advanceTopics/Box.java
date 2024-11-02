package main.java.advanceTopics;

//Belirli türdeki elemanları içeren bir listeye yalnızca belirli türde eleman
//eklenmesini sağlayan bir generic sınıf oluşturun.
public class Box<T> {
    private T value;

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }
}
