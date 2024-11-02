package main.java.treenode;

/*
Bir ikili ağaç verildiğinde, her düğümün altındaki tüm düğümlerin toplamını
 hesaplayın ve her düğümde kendi değerini bu toplam ile değiştirin.

verilen:
      1
     / \
    2   3
   / \   \
  4   5   6

çözüm:
      21
     / \
    11   9
   / \   \
  4   5   6
 */
public class TreeSum {
    // Her düğümü güncelleyen fonksiyon
    public static int altDugumlerinToplaminiGuncelle(TreeNode node){
        //Eğer düğüm null ise 0 dön:
        if (node == null) return 0;

        //Sol ve sağ alt düğümlerin toplamı:
        int solToplam = altDugumlerinToplaminiGuncelle(node.left);
        int sagToplam = altDugumlerinToplaminiGuncelle(node.right);

        //Geçerli değeri kaydet
        int eskiDeger = node.val;

        // Düğümün değerini güncelle = sol + sağ + kendisi
        node.val = solToplam + sagToplam + eskiDeger;

        // Düğümdeki değeri dön
        return node.val;
    }

    // Ağacı inorder gezip düğüm değerlerini yazdıran fonksiyon
    // Bu ağacı inorderGoster(root); ile gezdiğimizde çıktımız şöyle olacaktır:
    // 4 2 5 1 3 6
    /*
    İnorder gezme sırasında, sağ alt ağaca geçiş yaptıktan sonra sağ alt ağacın en alttaki düğümünden değil,
     kök düğümünden başlıyoruz. Bunun nedeni, inorder (sol-kök-sağ) sırasının sol alt ağaçtaki en küçük
     düğümden başlayıp sağ alt ağaçtaki en büyük düğüme kadar sıralı olarak ilerlemesidir.

Bu yüzden, ağacımızda şu adımları takip ederiz:

	1.	Sol Alt Ağaç: En alt sol düğümden (en küçük değer olan 4) başlar ve sol alt ağacın köküne kadar devam eder.
	2.	Kök Düğüm: Sol alt ağaç tamamlandıktan sonra, ana kök düğüm (1) yazdırılır.
	3.	Sağ Alt Ağaç: Sağ alt ağaca geçildiğinde ise kök olan düğüm (3) önce yazdırılır. Eğer sağ alt ağacın
	 başka düğümleri varsa, sol-kök-sağ sırasına göre devam edilir.

     */
    public static void inorderPrint(TreeNode node){
        if (node == null) return;
        inorderPrint(node.left);    // ile önce sol alt ağacı geziyoruz.
        System.out.println(node.val + " ");   //ile şu anki düğümün (kök düğüm) değerini yazdırıyoruz.
        inorderPrint(node.right);   // ile sağ alt ağacı geziyoruz.
    }

    //main
    public static void main(String[] args) {
        //Ağaç oluşturma
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Ağacın güncellenmeden önceki durumu(inorder): ");
        inorderPrint(root);
        System.out.println();

        //Güncelleme yap
        altDugumlerinToplaminiGuncelle(root);

        System.out.println("Güncellenmiş durum(inorder): ");
        inorderPrint(root);
        System.out.println();
    }

}
















