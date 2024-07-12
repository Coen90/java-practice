package coding.test.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bj20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int game = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < game; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            result.append(solution(str, k));
        }
        System.out.println(result);
    }

    public static String solution(String str, int k) {
        StringBuilder sb = new StringBuilder();
        //map을 사용해서 key:알파벳 value:[]idx
        //알파벳 갯수 세기
        int[] alphabet = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            alphabet[idx]++;
        }

        //Min Max 구하기
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            //특정 알파벳이 k개에 못미치면 패스
            if (alphabet[idx] < k) {
                continue;
            }

            if (k == 1) {
                min = 1;
                max = 1;
            }

            int count = 1;
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    count++;
                }
                if (count == k) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE || max == -1) {
            sb.append(-1);
        } else {
            sb.append(min).append(" ").append(max);
        }
        sb.append("\n");
        return sb.toString();
    }
}
