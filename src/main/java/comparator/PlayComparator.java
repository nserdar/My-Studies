package main.java.comparator;

import java.awt.desktop.PrintFilesEvent;
import java.util.Comparator;

//Sıralama kurallarını belirlemek için Comparator kullanıyoruz
public class PlayComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {

        //Puanları büyükten küçüğe kıyaslama
        //Buradaki işlem, büyük puanların küçük puanlardan önce
        // gelmesini sağlamak için kullanılır (azalan sırada sıralama).
        //	•	Eğer p2.score büyükse, sonuç pozitif olur ve p2 daha önce sıralanır (azalan sıra).
        //	•	Eğer p1.score büyükse, sonuç negatif olur ve p1 daha önce sıralanır.
        if (p1.score != p2.score) {
            return p2.score- p1.score;
        }

        //Eğer puanlar eşitse isimleri küçükten büyüğe kıyasla
        return p1.name.compareTo(p2.name);
    }
}
