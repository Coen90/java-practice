package coding.test.baekjoon;

import java.io.*;
import java.util.*;

public class Bj1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        Integer[] bags = new Integer[K];
        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[1] - o1[1] : o2[0]  - o1[0];
            }
        });

        Arrays.sort(bags, Comparator.reverseOrder());
        long result = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int maxBag = bags[0];
        for(int i = 0; i < jewels.length; i++) {
            if(jewels[i][0] > maxBag) {
                continue;
            }
            for(int j = 0; j < bags.length; j++) {
                if(bags[j] != null) {
                    if(jewels[i][0] <= bags[j]) {
                        min = j;
                    }
                }
            }
            if(min != Integer.MAX_VALUE) {
                result += jewels[i][1];
                 bags[min] = null;
            }
            if(cnt == bags.length) {
                break;
            }
        }
        System.out.println(result);
    }
}
