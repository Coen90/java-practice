package coding_test.test.programmers.course.week1.numbergame;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};

        System.out.println(solution(a, b));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        int type = 2;

        if(type == 1) {
            Arrays.sort(b);
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < b.length; j++) {
                    if(a[i] < b[j]) {
                        answer++;
                        b[j] = 0;
                        break;
                    }
                }
            }
        } else if(type == 2) {
            Arrays.sort(a);
            Arrays.sort(b);
            int index = b.length - 1;

            for(int i = a.length - 1; i >= 0; i--) {
                if(a[i] < b[index]) {
                    index--;
                    answer++;
                }
            }
        }


        return answer;
    }


}
