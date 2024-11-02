package main.java.treenode;
//Soru: Bir ikili ağaçta (Binary Tree) kökten herhangi bir yaprak düğüme kadar olan
// yollardan en yüksek toplam değere sahip olanı bulun ve bu değeri döndürün.
// Ağacın her düğümünde pozitif veya negatif tamsayılar olabilir.

/*
Bu problemi çözmek için, her düğümün sol ve sağ alt ağaçlarının maksimum toplamını rekürsif olarak
hesaplayabiliriz. Her düğüm için:

	1.	Sol ve sağ çocuk düğümlerinin maksimum yol toplamlarını hesaplarız.
	2.	Toplamı bulmak için düğümün değerini bu iki toplamdan büyük olana ekleriz.
 */
public class Solution {

    // En yüksek toplamı bulmak için bir değişken
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        // root düğümünden başlayarak maksimum yolu hesaplayan yardımcı metod
        findMaxPathSum(root);
        return maxSum;
    }

    private int findMaxPathSum(TreeNode node){
        if (node == null){
            return 0;
        }

        // Sol ve sağ alt ağaçların maksimum toplamını hesapla (sıfırdan küçükse sıfır olarak ele al)
        int leftMax = Math.max(0,findMaxPathSum(node.left));
        int rightMax = Math.max(0,findMaxPathSum(node.right));

        // Geçerli düğümden geçen en büyük yolu bul
        // currentPathSum, mevcut düğüm (node.val) ve sol (leftMax) ile sağ (rightMax) alt
        // ağaçlardan dönen maksimum toplamların toplamıdır.
        int currentPathSum = node.val + leftMax + rightMax;

        // En yüksek toplamı güncelle
        // maxSum sınıf seviyesinde bir değişken olarak doğrudan findMaxPathSum metodunda güncelleniyor.
        maxSum = Math.max(maxSum, currentPathSum);

        // Bu düğümden başlayarak maksimum yolu döndür
        // findMaxPathSum metodu maxSum’u değil, sol veya sağ alt ağaçlardan gelen maksimum toplam değerini
        // döndürür (node.val + Math.max(leftMax, rightMax)). Bu, üst düğümden gelen çağrıya, bu düğümden
        // en yüksek yol toplamını vermek içindir.
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        // Ağacı oluşturma
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("Max yol toplamı: " + maxPathSum);

    }

}
