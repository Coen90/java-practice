package coding_test.test.baekjoon;

import java.io.*;
import java.util.*;


public class Bj1946 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            int interviewee = Integer.parseInt(br.readLine());
            int[] arr = new int[interviewee + 1];
            for (int j = 0; j < interviewee; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }

            int cutLine = arr[1];
            int cnt = 1;
            for (int j = 2; j < interviewee; j++) {
                if(arr[j] < cutLine) {
                    cutLine = arr[j];
                    cnt++;
                }
            }
            bw.append(cnt + "\n");
        }



        bw.flush();
        br.close();
        bw.close();
    }
}