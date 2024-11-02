package main.java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        //Oyuncuları tutan liste
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            players.add(new Player(name,score));
        }
        scanner.close();

        //sıralama:
        Collections.sort(players, new PlayComparator());
        //players.sort(new PlayComparator());

        //sıralananları yazdırma:
        for (Player player: players){
            System.out.println(player.name + ": " + player.score);
        }
    }
}
