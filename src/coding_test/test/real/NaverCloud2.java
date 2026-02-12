package coding_test.test.real;

import java.util.ArrayList;
import java.util.List;

public class NaverCloud2 {
    public static int minMovesToClusterRedBalls(String S) {
        int n = S.length();
        int[] rPositions = new int[n];
        int rCount = 0;

        // R의 위치만 저장
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'R') {
                rPositions[rCount++] = i;
            }
        }

        if (rCount <= 1) return 0;

        int midIndex = rCount / 2;
        int median = rPositions[midIndex];

        long moves = 0;
        for (int i = 0; i < rCount; i++) {
            int idealPosition = median - (midIndex - i);
            moves += Math.abs(rPositions[i] - idealPosition);
            if (moves > 1_000_000_000L) return -1;
        }

        return (int) moves;
    }

    private static final String RED_BALL_CHARACTER = "R";
    private static final int RESULT_EXCEEDS_COUNT = 1_000_000_000;

    public int solution(String S) {
        String[] balls = S.split("");
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < balls.length; i++) {
            pickRedBall(balls[i], i, positions);
        }
        int redBallCnt = positions.size();

        if (redBallCnt <= 1) {
            return 0;
        }

        int centerIndex = redBallCnt / 2;
        int mediumValue = positions.get(centerIndex);

        int cnt = 0;
        for (int i = 0; i < redBallCnt; i++) {
            int idealPosition = mediumValue - (centerIndex - i);
            cnt += Math.abs(positions.get(i) - idealPosition);
            if (cnt > RESULT_EXCEEDS_COUNT) {
                return -1;
            }
        }
        return cnt;
    }

    private void pickRedBall(String ball, int i, List<Integer> positions) {
        if (RED_BALL_CHARACTER.equals(ball)) {
            positions.add(i);
        }
    }

    // 테스트용 메인
    public static void main(String[] args) {
        NaverCloud2 solution = new NaverCloud2();
        System.out.println(solution.solution("WRRWWR"));      // 2
        System.out.println(solution.solution("WWRWWWRWR"));   // 4
        System.out.println(solution.solution("WWW"));         // 0
        System.out.println(solution.solution("WWR"));         // 0
        System.out.println(solution.solution("RWWRRRWWWWWR"));         // 7
        System.out.println(solution.solution("RW".repeat(100_000))); // -1
    }
}
