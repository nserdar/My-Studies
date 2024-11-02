package main.java.visitor;

// Ağaç düğümü. Amacı: Ağacın genel bir düğümünü temsil eder. Herhangi bir
// düğüm bir TreeNode olabilir. Düğümler bir değere (sayı),
// renge (örneğin kırmızı ya da yeşil) ve derinliğe (ağacın kökünden
// itibaren olan mesafe) sahiptir.Ağacın iç düğümlerini (yaprak olmayan düğümler)
// ve genel düğüm verilerini temsil eder.
public class TreeNode {
    private int value;
    private String color;
    private int depth;

    public TreeNode(int value, String color, int depth){
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    /*
    Diğer sınıflar tarafından kullanılmak üzere düğümün değerini, rengini
     ve derinliğini döndüren getValue, getColor, ve getDepth metodları sağlar.
     */
    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }
}
