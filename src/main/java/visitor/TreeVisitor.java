package main.java.visitor;

// Visitor arayüzü. Amacı: Bu arayüz, ağacın düğümlerini gezmek ve işlem yapmak
// için kullanılan bir şablondur. Herhangi bir ziyaretçinin ağacı gezmesi ve
// düğümler üzerinde işlem yapması için gereken metodları tanımlar.
// Her ziyaretçi sınıfı bu arayüzü implement eder ve belirli bir işlem gerçekleştirir.
public interface TreeVisitor {

    void visitNode(TreeNode node);   // Yaprak olmayan düğümleri ziyaret eder.
    void visitLeaf(TreeLeaf leaf);   // Yaprak düğümleri ziyaret eder.
    int getResult();

}
