package coding_test.test.programmers.test;

import java.util.Arrays;

public class P181188 {
    public int solution(int[][] targets) {
        int cur = 0;
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        for (int[] target : targets) {
            if (cur <= target[0]) {
                cur = target[1];
                answer++;
            }
        }
        return answer;
    }
}
