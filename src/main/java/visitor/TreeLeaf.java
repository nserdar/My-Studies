package main.java.visitor;

// Yaprak düğümü. Amacı: Bir TreeNode sınıfından türetilmiş olup, ağacın yaprak
// düğümlerini temsil eder. Bir yaprak düğüm, çocuk düğümü olmayan en son düğümlerdir.
public class TreeLeaf extends TreeNode{

    public TreeLeaf(int value, String color, int depth) {
        super(value, color, depth);
    }

}
