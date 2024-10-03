package coding_test.test.baekjoon;

import java.io.*;

public class Bj20437 {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            solve(W, K);
        }

        System.out.println(sb.toString());
    }

    private static void solve(String w, int k) {
        if(k == 1) {
            sb.append("1 1").append("\n");
            return;
        }

        // 알파벳 별로 개수 저장하기
        int[] alpha = new int[26];
        for(int i = 0 ; i < w.length() ; i++) {
            alpha[w.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE; // 최소 길이
        int max = -1; // 첫 번째와 마지막 글자가 같은 가장 긴 연속 문자열의 길이

        for(int i = 0 ; i < w.length() ; i++) {
            // 해당 문자의 갯수가 k개 이하라면 탐색 X
            if(alpha[w.charAt(i) - 'a'] < k)
                continue;

            int cnt = 1;

            // 뒷 문자열과 비교
            for(int j = i+1 ; j < w.length() ; j++) {
                if(w.charAt(i) == w.charAt(j))
                    cnt++;

                // 같은 문자의 수가 k개가 되는 순간
                if(cnt == k) {
                    min = Math.min(min, j-i+1);
                    max = Math.max(max, j-i+1);
                    break;
                }
            }
        }

        if(min == Integer.MAX_VALUE || max == -1) {
            sb.append("-1").append("\n");
            return;
        }

        sb.append(min + " " + max).append("\n");
    }
}
