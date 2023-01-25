package coding.test.baekjoon;

import java.io.*;
import java.util.*;

public class Bj1049 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] packs = new int[M];
        int[] eaches = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packs[i] = Integer.parseInt(st.nextToken());
            eaches[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packs);
        Arrays.sort(eaches);

        if(packs[0] > eaches[0] * 6) {
            System.out.println(eaches[0] * N);
            return;
        }

        int needPacks = N / 6;
        int needEaches = N % 6;
        long result = 0L;

        if (needPacks != 0) {
            result += packs[0] * needPacks;
            result += (packs[0] <= needEaches * eaches[0] ? packs[0] : needEaches * eaches[0]);
        } else {
            result += needEaches * eaches[0];
        }

        System.out.println(result);
    }
}
