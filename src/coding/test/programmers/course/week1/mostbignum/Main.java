package coding.test.programmers.course.week1.mostbignum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));
    }

    /**
     * 숫자 -> 문자 -> 내림차순정렬 -> 조합
     */
    public static String solution(int[] numbers) {
        String answer = "";
        int type = 2;

        if(type == 0) {
            String[] strNums = new String[numbers.length];
            for(int i = 0; i < numbers.length; i++) {
                strNums[i] = "" + numbers[i];
            }

            for(int i = 0; i < strNums.length; i++) { // Quick Sort
                for(int j = i + 1; j < strNums.length; j++) {
                    String s1 = strNums[i];
                    String s2 = strNums[j];
                    if((s1 + s2).compareTo(s2+s1) < 0) {
                        strNums[i] = strNums[j];
                        strNums[j] = s1;
                    }
                }
            }

            for (String s : strNums) {
                answer += s;
            }

            if(answer.charAt(0) == '0') return "0";
        } else if (type == 1) {
            String[] strNums = new String[numbers.length];
            for(int i = 0; i < numbers.length; i++) {
                strNums[i] = "" + numbers[i];
            }

            Arrays.sort(strNums, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });

            for (String s : strNums) {
                answer += s;
            }

            if(answer.charAt(0) == '0') return "0";
        } else if (type == 2) {
            answer = IntStream.of(numbers)
                    .mapToObj(String::valueOf)
                    .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                    .collect(Collectors.joining());

            if(answer.startsWith("0")) return "0";
        }
        return answer;
    }
}
