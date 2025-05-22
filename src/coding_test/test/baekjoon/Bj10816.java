package coding_test.test.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10816 {
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int first = findFirstIndex(0, arr.length - 1, target);
            int last = findLastIndex(arr.length - 1, 0, target);
            sb.append(last - first).append(" ");
        }
        System.out.println(sb);
    }

    private static int findFirstIndex(int start, int end, int target) {
        int mid = (start + end) / 2;
        while (start < end) {
            if (target < arr[mid]) {
                end = mid - 1;
                continue;
            }
            if (target > arr[mid]) {
                start = mid + 1;
                continue;
            }
            if (target == arr[mid]) {
                return mid;
            }
        }
        return 0;
    }
    private static int findLastIndex(int start, int end, int target) {
        int mid = (start + end) / 2;
        while (start > end) {
            if (target == arr[mid]) {
                return mid;
            }
            if (target >= arr[mid]) {
                end = mid + 1;
                continue;
            }
            if (target < arr[mid]) {
                start = mid - 1;
                continue;
            }
        }
        return 0;
    }
}
