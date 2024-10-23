package coding_test.theory.fibonacci;

import java.util.Arrays;

public class Fibonacci {
    private static int call = 0;
    private static int[] dp;

    public static void main(String[] args) {
        int cnt = 20;
        System.out.println(new Fibonacci().fibonacciRecur(cnt));
        System.out.println("콜 스택 = " + call);

        call = 0;
        dp = new int[cnt+1];
        Arrays.fill(dp, -1);
        System.out.println(new Fibonacci().fibonacciDP(cnt));
        System.out.println("콜 스택 = " + call);
    }

    private int fibonacciRecur(int i) {
        call++;
        if (i  <= 1) {
            return i;
        }
        return fibonacciRecur(i - 2) + fibonacciRecur(i - 1);
    }


    public int solution(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int answer = fibonacciRecur(n);
        return answer;
    }

    private int fibonacciDP(int n) {
        call++;
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n <= 1) {
            return n;
        }
        return dp[n] = (fibonacciDP(n - 2) + fibonacciDP(n - 1)) % 1_234_567;
    }
}
