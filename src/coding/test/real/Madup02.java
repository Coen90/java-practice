package coding.test.real;

import java.util.*;

public class Madup02 {

    //상하좌우
    public static final int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    public static int boardSize;

    public static void main(String[] args) {
        int[][] testCase1 = {
                {0, 0, 1, 0, 0, 0},
                {0, 2, 0, 0, 0, 1},
                {0, 0, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
        };
        int k1 = 2;
        int ax1 = 1;
        int ay1 = 2;
        System.out.println(solution(testCase1, k1, ax1, ay1));
        int[][] testCase2 = {
                {0, 0, 0, 1},
                {0, 2, 0, 1},
                {2, 0, 0, 1},
                {0, 2, 0, 1},
        };
        int k2 = 2;
        int ax2 = 2;
        int ay2 = 1;
        System.out.println(solution(testCase2, k2, ax2, ay2));
    }

    public static int solution(int[][] board, int k, int ax, int ay) {
        boardSize = board.length;
        //폭탄 영향범위 보드
        boolean[][] bombBoard = new boolean[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                //폭탄이라면?!
                if (board[i][j] == 1) {
                    bombBoard[i][j] = true;
                    for (int[] dir : dirs) {
                        for (int l = 1; l <= k; l++) {
                            int nx = i + dir[0] * l;
                            int ny = j + dir[1] * l;
                            // 벽이 있거나 board 사이즈 초과하면 break
                            if (isValid(nx, ny) && !isWall(board, nx, ny)) {
                                bombBoard[nx][ny] = true;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }

        //bfs
        List<Integer> results = new ArrayList<>();
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{ax, ay, 0});
        while (!bfs.isEmpty()) {
            int[] current = bfs.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];
            // 탈출조건 폭발범위가 아니면
            if (!bombBoard[x][y]) {
                results.add(cnt);
                break;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (isValid(nx, ny) && !isWall(board, nx, ny) && !isBomb(board, nx, ny)) {
                    bfs.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        Collections.sort(results);

        return results.get(0);
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < boardSize && y >= 0 && y < boardSize;
    }

    public static boolean isWall(int[][] board, int x, int y) {
        return board[x][y] == 2;
    }

    public static boolean isBomb(int[][] board, int x, int y) {
        return board[x][y] == 1;
    }
}
