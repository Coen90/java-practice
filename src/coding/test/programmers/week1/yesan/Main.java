package coding.test.programmers.week1.yesan;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] numbers1 = {120, 110, 140, 150};
        int m = 485;
        System.out.println(solution(numbers1, m));
    }

    public static int solution(int[] budgets, int m) {
        int answer = 0;
        int type = 2;

        if(type == 1) {

            int min = 0;
            int max = 0;
            for (int b : budgets) {
                if(b > max) max = b;
            }

            while(min <= max) {
                int mid = (min + max) / 2;

                int sum = 0;
                for (int b : budgets) {
                    if (b > mid) sum += mid;
                    else sum += b;
                }

                if(sum <= m) {
                    min = mid + 1;
                    answer = mid;
                } else {
                    max = mid - 1;
                }
            }

        } else if (type == 2) {
            int min = 0;
            int max = IntStream.of(budgets).max().orElse(0);

            while(min <= max) {
                final int mid = (min + max) / 2;

                int sum = IntStream.of(budgets)
                        .map(b -> Math.min(b, mid))
                        .sum();

                if(sum <= m) {
                    min = mid + 1;
                    answer = mid;
                } else {
                    max = mid - 1;
                }
            }
        }


        return answer;
    }


}
