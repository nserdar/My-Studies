package main.java.visitor;

// Bu sınıf, ağacın kırmızı düğümlerindeki (yaprak veya yaprak olmayan) değerlerin çarpımını hesaplar.
// Hem yaprak düğümleri (visitLeaf) hem de yaprak olmayan düğümleri (visitNode) ziyaret eder,
// ancak yalnızca kırmızı olan düğümlerin değerlerini dikkate alır.
// Kırmızı düğümler, problemde ProductRedNodesVisitor ziyaretçisinin ilgilendiği düğümlerdir. Bu ziyaretçi,
// sadece kırmızı düğümler üzerinde işlem yapar ve bu düğümlerdeki değerlerin çarpımını hesaplar.
public class ProductRedNodesVisitor implements TreeVisitor{
    private long product = 1; // Sıfır durumu için başlangıç
    private boolean hasRedNode = false;

    @Override
    public void visitNode(TreeNode node) {
        if ("red".equals(node.getColor())){
            product *= node.getValue();
            hasRedNode = true;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if ("red".equals(leaf.getColor())){
            product *= leaf.getValue();
            hasRedNode = true;
        }
    }

    // Kırmızı olan düğümlerin değerlerinin çarpımını alır ve bu sonucu getResult metodu ile döndürür.
    // Eğer hiç kırmızı düğüm yoksa, çarpım değeri sıfır olur.
    @Override
    public int getResult() {
        return hasRedNode ? (int) product : 0;
    }
}
