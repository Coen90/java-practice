package coding_test.test.real;

import java.util.*;

public class Swit3 {

    static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };; // 좌 우 하 상

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
        costs[startRow][startCol] = 0; // 시작점 설정

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 오름차순 정렬
        pq.add(new int[]{startRow, startCol, 0}); // 시작열, 시작행, 에너지

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], cost = curr[2];

            if (row == endRow && col == endCol) { // 도착
                return costs[row][col];
            }

            if (cost > costs[row][col]) { // 현재 도착한 위치의 비용이 현재 비용보다 작을경우 (되돌아왔을 경우)
                continue;
            }

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) { // 맵보다 크다면
                    continue;
                }

                int nextCost = cost + 1;
                if (board[nextRow][nextCol] == 1) { // 벽일경우
                    nextCost += c; // 벽 깨는 비용
                }

                if (nextCost < costs[nextRow][nextCol]) { // 처음으로 작성하거나, 기존 비용보다 적을 경우
                    costs[nextRow][nextCol] = nextCost; // 다음칸에 지금 비용 넣기
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
        int[][] arr3 = {
                { 0, 0, 0, 0, 2, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 3, 0, 1 }
        };
        int c3 = 3;
        System.out.println(solution(arr1, c1));
        System.out.println(solution(arr2, c2));
        System.out.println(solution(arr3, c3));
    }
}
