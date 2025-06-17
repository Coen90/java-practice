package coding_test.test.programmers.test;

import java.util.Arrays;

public class P42884 {

    public static void main(String[] args) {
        int[][] route1 = new int[][]{{-20, -15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(Solution(route1));;
    }

    public static int Solution(int[][] routes) {
        int answer = 1;
        int end;

        //진입 시점, 진출 시점 순 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        end = routes[0][1];

        for (int[] route : routes) {
            if (end < route[0]) {
                answer++;
                end = route[1];
            }
        }
        return answer;
    }
}
