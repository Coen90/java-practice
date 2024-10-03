package coding_test.test.programmers.course.week3.spy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[][] fake1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] fake2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(fake1));
        System.out.println(solution(fake2));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> counts = new HashMap<>();

        int codeType = 2;

        if(codeType == 1) {
            for (String[] c : clothes) {
                String type = c[1];
                counts.put(type, counts.getOrDefault(type, 0) + 1);
            }

            int answer = 1;

            for (Integer c : counts.values()) {
                answer *= c + 1;
            }

            return answer - 1;
        } else if (codeType == 2) {

            int answer = Arrays.stream(clothes)
                    .map(c -> c[1])
                    .distinct()
                    .map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())
                    .map(c -> c + 1)
                    .reduce(1, (c, n) -> c * n);

            return answer - 1;
        }
        return 0;
    }
}
