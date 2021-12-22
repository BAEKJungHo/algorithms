package inflearn.greedy.ssireumplayer;

import java.util.*;

class Player implements Comparable<Player> {

    private int height;
    private int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isOutCompareTo(Player o) {
        return o.height > this.height && o.weight > this.weight;
    }

    @Override
    public int compareTo(Player o) {
        return this.height - o.height;
    }
}

// 씨름 선수
public class Main {

    private static int N;
    private static Player[] players;
    private static int selectionCount;

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(selectionCount);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        players = new Player[N];
        for (int i = 0; i < N; i++) {
            players[i] = new Player(sc.nextInt(), sc.nextInt());
        }
    }

    private static void solution() {
        Arrays.sort(players);
        for (int i = 0; i < players.length; i++) {
            boolean selected = true;
            Player target = players[i];
            for (int k = i + 1; k < players.length; k++) {
                if(target.isOutCompareTo(players[k])) {
                    selected = false;
                    break;
                }
            }
            if(selected) {
                selectionCount++;
            }
        }
    }

    // O(N) 으로 해결
    private static void solution2() {
        Arrays.sort(players);
        int max = Integer.MIN_VALUE;
        for(Player player : players) {
            if(player.getWeight() > max) {
                max = player.getWeight();
                selectionCount++;
            }
        }
    }
}
