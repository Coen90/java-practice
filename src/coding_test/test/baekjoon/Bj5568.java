package coding_test.test.baekjoon;

import java.io.*;
import java.util.*;

public class Bj5568 {
    public static int n, k;
    public static int[] decks;
    public static boolean[] visited;
    public static Set<String> card = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        decks = new int[n];

        for (int i = 0; i < n; i++) {
            decks[i] = Integer.parseInt(br.readLine());
        }
        backTracking(0, "");
        System.out.println(card.size());
    }

    public static void backTracking(int depth, String target) {
        if (depth >= k) {
            card.add(target);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String target1 = target + decks[i];
                backTracking(depth+1, target1);
                visited[i] = false;
            }
        }
    }
}
