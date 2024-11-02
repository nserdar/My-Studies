package main.java.visitor;

/*
Bu sınıf, ağacın yaprak düğümlerindeki değerlerin toplamını hesaplar.

 */
public class SumInLeavesVisitor implements TreeVisitor{

    private int sum = 0;

    // Yaprak olmayan düğümler (visitNode) için herhangi bir işlem yapmaz.
    @Override
    public void visitNode(TreeNode node) {
        // Yaprak değil, hiçbir şey yapma
    }

    // visitLeaf metodunu kullanarak sadece yaprak düğümleri ziyaret eder ve bu düğümlerin değerlerini toplar.
    @Override
    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }

    // getResult metodu, hesaplanan toplam değeri döndürür.
    @Override
    public int getResult() {
        return sum;
    }
}
