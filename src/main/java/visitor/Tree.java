package main.java.visitor;

import java.util.ArrayList;
import java.util.List;

/*
Amacı: Ağacı temsil eder ve ağaçtaki düğümler ile kenarlar arasında bağlantı
 kurar. Tree sınıfı, düğümler ve kenarlar hakkında bilgi saklar ve ziyaretçi
 sınıflarının ağacın yapısını gezebilmesi için bir yapı sunar.
 */
public class Tree {
    private final List<TreeNode> nodes = new ArrayList<>();
    private final List<List<Integer>> edges = new ArrayList<>();

    public Tree(int[] values, String[] colors, int[][] edges){
        for (int i = 0; i < values.length; i++){
            if ("leaf".equals(colors[i])){
                nodes.add(new TreeLeaf(values[i], colors[i], 0));
            } else {
                nodes.add(new TreeNode(values[i], colors[i], 0));
            }
        }
        // Kenarları kaydet
        for (int[] edge : edges){
            this.edges.add(List.of(edge[0], edge[1]));
        }
    }

    // Ağacı ziyaret et. Ziyaretçilerin ağacın düğümlerini gezmesine olanak
    // tanır. accept metodu ile bir ziyaretçi çağrıldığında, ağacın tüm
    // düğümleri bu ziyaretçiye sırayla verilir.
    public void accept(TreeVisitor visitor){
        for (TreeNode node : nodes){
            if (node instanceof TreeLeaf){
                visitor.visitLeaf((TreeLeaf) node);
            } else {
                visitor.visitNode(node);
            }
        }
    }
}
