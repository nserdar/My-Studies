package main.java.visitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Programın ana sınıfıdır ve problemi çözmek için tüm işlemleri yönetir.
 Ağacı oluşturur, verilen girdi üzerinden düğümleri ve kenarları okur,
 üç ziyaretçiyi ağacı ziyaret ettirir ve sonuçları yazdırır.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        String[] colors = new String[n];

        String[] valueStrings = br.readLine().split(" ");
        String[] colorStrings = br.readLine().split(" ");

        for (int i = 0; i < n; i++){
            values[i] = Integer.parseInt(valueStrings[i]);
            colors[i] = colorStrings[i];
        }

        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n; i++){
            String[] edgeStrings = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(edgeStrings[0]);
            edges[i][1] = Integer.parseInt(edgeStrings[1]);
        }

        // Girdiyi okur ve verilen değerlere göre bir ağaç oluşturur.
        Tree tree = new Tree(values, colors, edges);

        // Ziyaretçileri (SumInLeavesVisitor, ProductRedNodesVisitor,
        // FancyVisitor) ağacı ziyaret ettirir ve sonuçları ekrana yazdırır.
        SumInLeavesVisitor sumVisitor = new SumInLeavesVisitor();
        tree.accept(sumVisitor);
        System.out.println(sumVisitor.getResult());

        ProductRedNodesVisitor productVisitor = new ProductRedNodesVisitor();
        tree.accept(productVisitor);
        System.out.println(productVisitor.getResult());

        FancyVisitor fancyVisitor = new FancyVisitor();
        tree.accept(fancyVisitor);
        System.out.println(fancyVisitor.getResult());
    }
}
/*
Visitor Tasarım Deseni Nedir?

Visitor Tasarım Deseni, bir yapıdaki (örneğin bir ağaç) elemanlar üzerinde işlem yapmayı
kolaylaştıran bir tasarım desenidir. Bu desen sayesinde:
	•	Yapıdaki elemanları (düğümleri) değiştirmeden üzerinde işlem yapılabilir.
	•	Yeni işlemler eklemek kolaydır. Örneğin, yeni bir ziyaretçi yazılarak farklı işlemler uygulanabilir.
	•	Mevcut sınıfların kodu değiştirilmez, böylece açık/kapalı prensibi korunur.
 */

/*
Derinlik Nedir?

	•	Derinlik (Depth): Bir düğümün ağacın kökünden ne kadar uzakta olduğunu belirtir.
	 Kök düğümün derinliği her zaman 0’dır. Kök düğümden bir sonraki düğümlerin derinliği 1’dir,
	 bir sonraki katmandaki düğümler 2’dir, ve bu şekilde devam eder.

	Çift Derinlik Nedir?

    .   Bir düğümün derinliği çift bir sayı ise, o düğüm çift derinlikte kabul edilir. Yani,
    derinlik değerleri 0, 2, 4, 6, … olan düğümler çift derinliktedir.

	•	Kök düğümün derinliği: 0 (çift)
	•	Kök düğüme bağlı olan çocuk düğümlerin derinliği: 1 (tek)
	•	Bu düğümlerin çocukları: 2 (çift)
	•	Onların çocukları: 3 (tek)

	Problemde Çift Derinliğin Rolü

Bu kavram, FancyVisitor sınıfında kullanılır. Bu ziyaretçi, sadece çift derinlikteki yaprak olmayan düğümlerin değerlerini toplar. Yani:

	•	Ağacın yaprak olmayan düğümlerini gezerken, düğümün derinliği çiftse (0, 2, 4, …) o düğümün değerini toplar.
	•	Yaprak olan düğümler bu hesaba dahil edilmez, sadece yaprak olmayan düğümler dikkate alınır.

Bu nedenle, ağacın yapısı üzerinde bu derinlik değerleri belirli işlemlerin hangi düğümler üzerinde yapılacağını belirler.

 */

















