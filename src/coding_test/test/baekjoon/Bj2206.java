package coding_test.test.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2206 {
    private static final int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        int result = BFS(map, visited, N-1, M-1);
        System.out.println(result);
    }

    private static int BFS(int[][] map, boolean[][] visited, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1, 1});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int isWallBreakable = now[3];
            if (visited[x][y]) {
                continue;
            }
            System.out.println(x + "" + y);
            if (x == endX && y == endY) {
                return cnt;
            }
            visited[x][y] = true;
            for (int[] dir: dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx <= endX && ny <= endY) {
                    if (map[nx][ny] == 1 && isWallBreakable == 0) {
                        continue;
                    } else if (map[nx][ny] == 1 && isWallBreakable == 1) {
                        q.offer(new int[]{nx, ny, cnt+1, 0});
                        continue;
                    }
                    q.offer(new int[]{nx, ny, cnt+1, isWallBreakable});
                }
            }
        }
        return -1;
    }
}
