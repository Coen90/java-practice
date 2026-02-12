package coding_test.test.real;

import java.util.HashMap;
import java.util.Map;

public class NaverCloud3 {
    static final int MODULO = 1_000_000_007;

    public int solution2(int[] X, int[] Y) {
        Map<String, Integer> fractionMap = new HashMap<>();
        long count = 0;

        for (int i = 0; i < X.length; i++) {
            int num = X[i];
            int den = Y[i];

            int gcd = gcd(num, den);
            num /= gcd;
            den /= gcd;

            // 보수 분수 계산
            int compNum = den - num;
            int compDen = den;
            int compGcd = gcd(compNum, compDen);
            compNum /= compGcd;
            compDen /= compGcd;

            String complementKey = compNum + "/" + compDen;
            count = (count + fractionMap.getOrDefault(complementKey, 0)) % MODULO;

            String key = num + "/" + den;
            fractionMap.put(key, fractionMap.getOrDefault(key, 0) + 1);
        }

        return (int) count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public int solution(int[] X, int[] Y) {
        long count = 0;
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < X.length; i++) {
            int euclidean = euclidean(X[i], Y[i]);
            int x = X[i] / euclidean;
            int y = Y[i] / euclidean;

            int oppositeEuclidean = euclidean(y - x, y);
            int oppositeX = (y - x) / oppositeEuclidean;
            int oppositeY = y / oppositeEuclidean;
            count += map.getOrDefault(new Point(oppositeX, oppositeY), 0) % MODULO;

            Point key = new Point(x, y);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return (int) count;
    }

    private int euclidean(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    private record Point(int x, int y) {
    }

    public static void main(String[] args) {
        NaverCloud3 solution = new NaverCloud3();

        System.out.println(solution.solution(new int[]{1, 1, 2}, new int[]{3, 2, 3})); // 1
        System.out.println(solution.solution(new int[]{1, 1, 1}, new int[]{2, 2, 2})); // 3
        System.out.println(solution.solution(new int[]{1, 2, 3, 1, 2, 12, 8, 4}, new int[]{5, 10, 15, 2, 4, 15, 10, 5})); // 10
    }
}
