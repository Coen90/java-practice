package coding_test.test.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2178 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int MAX = Integer.MAX_VALUE;

    private static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] num = br.readLine().split("");
            for (int j = 0; j < num.length; j++) {
                map[i][j] = Integer.parseInt(num[j]);
            }
        }
        BFS();
        System.out.println(MAX);
    }

    public static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];

            //map을 벗어나는지
            if (x >= N || y >= M || x < 0 || y < 0) {
                continue;
            }
            //0 이면 접근 불가
            if (map[x][y] == 0) {
                continue;
            }
            //이미 방문
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            cnt += 1;
            //도착지면?
            if (x == N-1 && y == M-1) {
                MAX = Math.min(MAX, cnt);
            }

            //다음 방향으로
            for (int[] dir: dirs) {
                q.offer(new int[]{x + dir[0], y + dir[1], cnt});
            }
        }
    }
}
