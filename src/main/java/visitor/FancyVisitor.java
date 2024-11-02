package main.java.visitor;

/*
Bu sınıf, iki farklı hesaplama yapar:
	1.	Yaprak olmayan düğümlerin çift derinlik değerlerindeki toplamını hesaplar.
	2.	Yeşil yaprak düğümlerinin toplamını hesaplar.
 */
public class FancyVisitor implements TreeVisitor{
    private int sumEvenDepthNonLeaf = 0;
    private int sumGreenLeaves = 0;

    // visitNode metodunu kullanarak yaprak olmayan düğümleri ziyaret eder ve
    // eğer düğümün derinliği çiftse, bu düğümün değerini toplar. Yeşil düğümler,
    // problemde FancyVisitor sınıfının dikkate aldığı düğümlerdir. Yeşil yaprak
    // düğümler bu ziyaretçinin özel olarak işlem yaptığı düğümlerdir.
    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0){
            sumEvenDepthNonLeaf += node.getValue();
        }
    }

    // visitLeaf metodunu kullanarak yaprak düğümleri ziyaret eder ve
    // eğer düğüm yeşil renkteyse, bu düğümün değerini toplar.
    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if ("green".equals(leaf.getColor())){
            sumGreenLeaves += leaf.getValue();
        }
    }

    // getResult metodu, yaprak olmayan çift derinlikli düğümler ile
    // yeşil yaprak düğümlerinin değerlerinin toplamları arasındaki mutlak farkı döndürür.
    @Override
    public int getResult() {
        return Math.abs(sumEvenDepthNonLeaf - sumGreenLeaves);
    }
}
