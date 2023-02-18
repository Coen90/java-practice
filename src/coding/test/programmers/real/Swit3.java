package coding.test.programmers.real;

import java.util.*;

public class Swit3 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int solution(int[][] board, int c) {
        int n = board.length;
        int m = board[0].length;

        int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                }
                if (board[i][j] == 3) {
                    endRow = i;
                    endCol = j;
                }
            }
        }

        int[][] costs = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[startRow][startCol] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{startRow, startCol, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], cost = curr[2];

            if (row == endRow && col == endCol) {
                return costs[row][col];
            }

            if (cost > costs[row][col]) {
                continue;
            }

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }

                int nextCost = cost + 1;
                if (board[nextRow][nextCol] == 1) {
                    nextCost += c;
                }

                if (nextCost < costs[nextRow][nextCol]) {
                    costs[nextRow][nextCol] = nextCost;
                    pq.add(new int[]{nextRow, nextCol, nextCost});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] arr1 = {
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0, 1, 0}
        };
        int c1 = 1;
        int[][] arr2 = {
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0, 1, 0}
        };
        int c2 = 2;
        System.out.println(solution(arr1, c1));
        System.out.println(solution(arr2, c2));
    }
}
