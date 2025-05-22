package coding_test.test.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2606 {
    private static StringTokenizer st;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        boolean[][] graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = true;
        }

        System.out.println(BFS(graph));
    }

    private static int BFS(boolean[][] graph) {
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (visited[now]) {
                continue;
            }
            result++;
            visited[now] = true;
            for (int i = 1; i < graph.length; i++) {
                if (graph[now][i] || graph[i][now]) {
                    q.offer(i);
                }
            }
        }
        return result-1;
    }
}
