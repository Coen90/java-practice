package coding_test.test.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1012 {
    private static final int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    private static int[][] map;
    private static boolean[][] visited;
    private static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            System.out.println(field(br));
        }
    }

    private static int field(BufferedReader br) throws Exception {
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void BFS(int x, int y) throws Exception {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (visited[nowX][nowY]) {
                continue;
            }
            visited[nowX][nowY] = true;

            for (int[] dir: dirs) {
                int nextX = nowX + dir[0];
                int nextY = nowY + dir[1];
                if (isMovable(nextX, nextY)) {
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean isMovable(int x, int y) {
        if (x >= N || y >= M || x < 0 || y < 0) {
            return false;
        }
        if (map[x][y] == 0) {
            return false;
        }
        return true;
    }
}
