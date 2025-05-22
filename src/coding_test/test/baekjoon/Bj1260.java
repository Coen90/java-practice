package coding_test.test.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1260 {
    private static int N, M, V;
    private static boolean[] visited;
    private static boolean[][] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = true;
        }

        visited = new boolean[N + 1];
        DFS(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println(sb);
    }

    private static void DFS(int V) {
        visited[V] = true;
        sb.append(V + " ");

        for (int i = 1; i <= N; i++) {
            if (arr[V][i] && !visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);

        while (!q.isEmpty()) {
            int now = q.poll();
            if (visited[now]) continue;

            visited[now] = true;
            sb.append(now + " ");
            for (int i = 1; i <= N; i++) {
                if (arr[now][i] && !visited[i]) {
                    q.offer(i);
                }
            }
        }
    }
}
