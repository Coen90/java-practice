package coding_test.test.programmers.test.p131704;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr1 = {4, 3, 1, 2, 5};
        System.out.println(s.solution(arr1));
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(s.solution(arr2));
    }
    public static class Solution {
        public int solution(int[] order) {
            int answer = 0;
            int idx = 0;
            Stack<Integer> s = new Stack<>();
            for (int i = 1; i <= order.length; i++) {
                s.push(i);
                while (!s.isEmpty()) {
                    if (s.peek() == order[idx]) {
                        answer++;
                        idx++;
                        s.pop();
                    } else break;
                }
            }

            return answer;
        }
    }
}

