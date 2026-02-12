package coding_test.test.real;

import java.util.*;

public class NaverCloud1 {
    public int solution(int[] A) {
        int result = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : A) {
            int cnt = counter.getOrDefault(num, 0);
            counter.put(num, ++cnt);
        }
        List<Integer> sortedKeys = sortKeys(counter.keySet());
        for (int key : sortedKeys) {
            int cnt = counter.get(key);
            if (key == cnt && result < cnt) {
                result = cnt;
                break;
            }
        }
        return result;
    }

    public int finalSolution(int[] A) {
        int result = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : A) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (int key : counter.keySet()) {
            int cnt = counter.get(key);
            if (key == cnt && result < cnt) {
                result = cnt;
            }
        }
        return result;
    }

    private static List<Integer> sortKeys(Set<Integer> keySet) {
        return keySet.stream()
                .sorted(Collections.reverseOrder())
                .toList();
    }

    public static void main(String[] args) {
        NaverCloud1 solution = new NaverCloud1();
        System.out.println(solution.finalSolution(new int[]{1, 2, 2, 3, 3, 3})); // Output: 3
        System.out.println(solution.finalSolution(new int[]{3, 8, 2, 3, 3, 2})); // Output: 3
        System.out.println(solution.finalSolution(new int[]{7, 1, 2, 8, 2})); // Output: 2
        System.out.println(solution.finalSolution(new int[]{5, 5, 5, 5, 5})); // Output: 5
    }
}
