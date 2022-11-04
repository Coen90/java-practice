package coding.test.programmers.week1.gijigook;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /**
     * Queue
     * Queue.offer = 값 넣기
     * Queue.peek = 첫번째 값 참조
     * Queue.poll = 첫번째 값 반환하고 제거, 비어있다면 null
     */

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        int result = solution(n, stations, w);

        System.out.println("result = " + result);
    }

    public static int solution(int n, int[] stations, int w) {
        int type = 1;
        int answer = 0;
        if(type == 0) { // Queue 사용
            Queue<Integer> sq = new LinkedList<>(); // Java 는 Primitive Type 이 Object Type 사용하는거보다 빠르다.

            for(int s : stations) {
                sq.offer(s);
            }

            int position = 1;
            while (position <= n) {
                if (!sq.isEmpty() && sq.peek() - w <= position) {
                    position = sq.poll() + w + 1;
                } else {
                    answer += 1;
                    position += w * 2 + 1; // (전파범위 * 2) +기지국
                }
            }

        } else if (type == 1) { // Primitive Type 사용

            int si = 0;

            int position = 1;
            while (position <= n) {
                if (si < stations.length && stations[si] - w <= position) {
                    position = stations[si] + w + 1;
                    si += 1;
                } else {
                    answer += 1;
                    position += w * 2 + 1; // (전파범위 * 2) +기지국
                }
            }
        }



        return answer;
    }
}
